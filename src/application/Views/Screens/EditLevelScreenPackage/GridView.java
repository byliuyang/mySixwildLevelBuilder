package application.Views.Screens.EditLevelScreenPackage;

import application.Controllers.ButtonController;
import application.Models.Grid;
import application.Models.Levels.Level;
import application.Models.Square;
import application.Moves.ISpecialMove;
import application.Views.Application;
import application.Views.Components.NavigationBar;
import application.Views.IModelUpdated;
import application.Views.Screens.Screen;
import application.Views.TransitableView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class GridView extends TransitableView implements IModelUpdated {

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(654, 654);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 9;
    final int GRID_VIEW_PADDING_TOP = 9;

    final Color SQUARE_NORMAL_BACK_COLOR = new Color(245, 243, 243);
    final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    ArrayList<SquareView> activeSquareViews;
    SquareView[][] squareViews;
    Application app;

    Grid grid;
    Level level;

    public GridView(Application app, Level level) {
        this.grid = level.getGrid();
        this.app = app;
        this.level = level;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Screen.BORDER_COLOR));

        setLayout(null);
    }

    public void initialize() {

        removeAll();
        activeSquareViews = new ArrayList<SquareView>();
        squareViews = new SquareView[Grid.MAX_ROWS][Grid.MAX_COLUMNS];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {


                Square square = grid.getSquare(row, column);
                if (square != null) {

                    SquareView squareView = new SquareView(
                            SQUARE_NORMAL_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_DISABLED_BACK_COLOR,
                            square,
                            NavigationBar.NO_ROUND
                    );

                    squareViews[row][column] = squareView;

                    squareView.setPreferredSize(SquareView.SQUARE_VIEW_SIZE);
                    squareView.setMaximumSize(SquareView.SQUARE_VIEW_SIZE);
                    squareView.setMinimumSize(SquareView.SQUARE_VIEW_SIZE);

                    squareView.setBounds(
                            GRID_VIEW_PADDING_LEFT + column * ((int) SquareView.SQUARE_VIEW_SIZE.getWidth() - 1),
                            GRID_VIEW_PADDING_TOP + row * ((int) SquareView.SQUARE_VIEW_SIZE.getHeight() - 1),
                            (int) SquareView.SQUARE_VIEW_SIZE.getWidth(),
                            (int) SquareView.SQUARE_VIEW_SIZE.getHeight()
                    );

                    add(squareView);

                    ButtonController squareButtonController = new ButtonController(squareView);
                    squareView.addMouseListener(squareButtonController);
                    squareView.addMouseMotionListener(squareButtonController);

                    squareView.normal();
                }
            }
        }
    }

    public void addActiveSquareView(SquareView squareView) {
        activeSquareViews.add(squareView);
        grid.addActiveSquare(squareView.getSquare());
    }

    public void beginMakeingMove() {
        activeSquareViews.clear();
        level.beginMakeingMove();
    }

    public void finishMakingMove() {
        level.finishMakingMove();
        for (Iterator<SquareView> squareViewIterator = activeSquareViews.iterator(); squareViewIterator.hasNext(); ) {

            SquareView squareView = squareViewIterator.next();

            squareView.inactive();
            squareView.normal();
        }

        activeSquareViews.clear();

        grid.getActiveSquare().clear();

        if (level.hasWon()) {
            app.getGameScreen().levelCompleted();
        }
    }

    public boolean isMakeingMove() {
        return level.isMakeingMove();
    }

    public boolean hasSpecialMove() {
        return level.hasSpecialMove();
    }

    public ISpecialMove getSpecialMove() {
        return level.getSpecialMove();
    }

    public void setSpecialMove(ISpecialMove specialMove) {
        level.setSpecialMove(specialMove);
    }

    public Grid getGrid() {
        return grid;
    }

    public SquareView[][] getSquareViews() {
        return squareViews;
    }

    @Override
    public void modelChanged() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                if (squareViews[row][column] != null) {
                    squareViews[row][column].repaint();
                }
            }
        }
    }

    public ArrayList<SquareView> getActiveSquareViews() {
        return activeSquareViews;
    }

    public void setLevel(Level level) {
        this.level = level;
        this.grid = level.getGrid();
    }
}