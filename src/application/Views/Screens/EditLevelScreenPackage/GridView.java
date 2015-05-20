package application.Views.Screens.EditLevelScreenPackage;

import application.Controllers.EditLevelScreen.GridMap.SquareViewController;
import application.Models.Grid;
import application.Models.Levels.Level;
import application.Models.Square;
import application.Views.Application;
import application.Views.Components.NavigationBar;
import application.Views.IModelUpdated;
import application.Views.Screens.Screen;
import application.Views.TransitableView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public class GridView extends TransitableView implements IModelUpdated {

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(654, 654);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 9;
    final int GRID_VIEW_PADDING_TOP = 9;

    public static final Color SQUARE_NORMAL_BACK_COLOR = new Color(245, 243, 243);
    public static final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    public static final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    ArrayList<SquareView> activeSquareViews;
    SquareView[][] squareViews;
    Application app;

    Level level;

    EditLevelScreen editLevelScreen;

    public GridView(Application app, Level level) {
        this.app = app;
        this.level = level;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Screen.BORDER_COLOR));

        setLayout(null);

        activeSquareViews = new ArrayList<SquareView>();
        squareViews = new SquareView[Grid.MAX_ROWS][Grid.MAX_COLUMNS];
    }

    public void initialize(EditLevelScreen editLevelScreen) {

        this.editLevelScreen = editLevelScreen;

        removeAll();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Square square = level.getGrid().getSquare(row, column);

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

                    SquareViewController squareViewController = new SquareViewController(squareView, editLevelScreen);
                    squareView.addMouseListener(squareViewController);
                    squareView.addMouseMotionListener(squareViewController);

                    squareView.normal();
                }
            }
        }
    }

    public Grid getGrid() {
        return level.getGrid();
    }

    @Override
    public void modelChanged() {
        initialize(editLevelScreen);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public SquareView[][] getSquareViews() {
        return squareViews;
    }
}