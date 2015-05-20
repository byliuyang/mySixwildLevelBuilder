package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.GridMap.SelectGridElementController;
import application.Models.Levels.ReleaseLevel;
import application.Models.Square;
import application.Models.Tile;
import application.Models.Value;
import application.Utilities;
import application.Views.Components.NavigationBar;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.EditLevelScreenPackage.GridView;
import application.Views.Screens.EditLevelScreenPackage.SquareView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class SelectGridElementsPanel extends JPanel implements IModelUpdated {

    //    Select grid elements label size and bounds
    final Dimension SELECT_GRID_ELEMENTS_LABEL_SIZE = new Dimension(300, 26);
    final Rectangle SELECT_GRID_ELEMENTS_LABEL_BOUNDS = new Rectangle(20, 20, 300, 26);

    //    No square view size and bounds
    final Dimension NO_SQUARE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle NO_SQUARE_VIEW_BOUNDS = new Rectangle(20, 56, 70, 70);

    //    Empty square view size and bounds
    final Dimension EMPTY_SQUARE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle EMPTY_SQUARE_VIEW_BOUNDS = new Rectangle(100, 56, 70, 70);

    //    Sixes receiver view size and bounds
    final Dimension SIX_RECEIVER_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle SIX_RECEIVER_VIEW_BOUNDS = new Rectangle(180, 56, 70, 70);

    //    One tile view size and bounds
    final Dimension ONE_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle ONE_TILE_VIEW_BOUNDS = new Rectangle(20, 136, 70, 70);

    //    Two tile view size and bounds
    final Dimension TWO_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle TWO_TILE_VIEW_BOUNDS = new Rectangle(100, 136, 70, 70);

    //    Three tile view size and bounds
    final Dimension THREE_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle THREE_TILE_VIEW_BOUNDS = new Rectangle(180, 136, 70, 70);

    //    Four tile view size and bounds
    final Dimension FOUR_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle FOUR_TILE_VIEW_BOUNDS = new Rectangle(20, 216, 70, 70);

    //    Five tile view size and bounds
    final Dimension FIVE_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle FIVE_TILE_VIEW_BOUNDS = new Rectangle(100, 216, 70, 70);

    //    Six tile view size and bounds
    final Dimension SIX_TILE_VIEW_SIZE = new Dimension(70, 70);
    final Rectangle SIX_TILE_VIEW_BOUNDS = new Rectangle(180, 216, 70, 70);

    EditLevelScreen editLevelScreen;

    JLabel selectElementsLabel;

    SquareView emptySquareView;
    SquareView sixReceiverView;
    SquareView noSquareView;

    SquareView oneSquareView;
    SquareView twoSquareView;
    SquareView threeSquareView;
    SquareView fourSquareView;
    SquareView fiveSquareView;
    SquareView sixSquareView;

    public SelectGridElementsPanel(EditLevelScreen editLevelScreen) {

        this.editLevelScreen = editLevelScreen;

        setLayout(null);

        setBackground(Color.WHITE);

        setBorder(BorderFactory.createMatteBorder(
                Utilities.ZERO,
                Utilities.ZERO,
                Utilities.ONE,
                Utilities.ZERO,
                LevelPreferencePanel.BORDER_COLOR_BRIGHT
        ));

//        Add elements into panel
        add(getSelectElementsLabel());

        add(getNoSquareView());
        getNoSquareView().repaint();

        add(getEmptySquareView());
        getEmptySquareView().repaint();

        add(getSixReceiverView());
        getSixReceiverView().normal();

        add(getOneSquareView());
        getOneSquareView().repaint();

        add(getTwoSquareView());
        getTwoSquareView().repaint();

        add(getThreeSquareView());
        getThreeSquareView().repaint();

        add(getFourSquareView());
        getFourSquareView().repaint();

        add(getFiveSquareView());
        getFiveSquareView().repaint();

        add(getSixSquareView());
        getSixSquareView().repaint();

    }

    public JLabel getSelectElementsLabel() {

        if (selectElementsLabel == null)

        {
            selectElementsLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            selectElementsLabel.setFont(font);

            selectElementsLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            selectElementsLabel.setPreferredSize(SELECT_GRID_ELEMENTS_LABEL_SIZE);
            selectElementsLabel.setMinimumSize(SELECT_GRID_ELEMENTS_LABEL_SIZE);
            selectElementsLabel.setMaximumSize(SELECT_GRID_ELEMENTS_LABEL_SIZE);

            selectElementsLabel.setBounds(SELECT_GRID_ELEMENTS_LABEL_BOUNDS);

            selectElementsLabel.setText(TextContact.SELECT_GRID_ELEMENTS_TEXT);

        }

        return selectElementsLabel;
    }

    public SquareView getNoSquareView() {

        if (noSquareView == null) {
            Square square = new Square(null, null);

            noSquareView = new SquareView(
                    Color.WHITE,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );

            noSquareView.setPreferredSize(NO_SQUARE_VIEW_SIZE);
            noSquareView.setMinimumSize(NO_SQUARE_VIEW_SIZE);
            noSquareView.setMaximumSize(NO_SQUARE_VIEW_SIZE);

            noSquareView.setBounds(NO_SQUARE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(noSquareView, editLevelScreen);

            noSquareView.addMouseListener(selectGridElementController);
            noSquareView.addMouseMotionListener(selectGridElementController);

        }

        return noSquareView;
    }

    public SquareView getEmptySquareView() {

        if (emptySquareView == null) {
            Square square = new Square(null, null);

            emptySquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );

            emptySquareView.setPreferredSize(EMPTY_SQUARE_VIEW_SIZE);
            emptySquareView.setMinimumSize(EMPTY_SQUARE_VIEW_SIZE);
            emptySquareView.setMaximumSize(EMPTY_SQUARE_VIEW_SIZE);

            emptySquareView.setBounds(EMPTY_SQUARE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(emptySquareView, editLevelScreen);

            emptySquareView.addMouseListener(selectGridElementController);
            emptySquareView.addMouseMotionListener(selectGridElementController);

        }

        return emptySquareView;
    }

    public SquareView getSixReceiverView() {

        if (sixReceiverView == null) {
            Square square = new Square(null, null);
            square.container();

            sixReceiverView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            sixReceiverView.setPreferredSize(SIX_RECEIVER_VIEW_SIZE);
            sixReceiverView.setMinimumSize(SIX_RECEIVER_VIEW_SIZE);
            sixReceiverView.setMaximumSize(SIX_RECEIVER_VIEW_SIZE);

            sixReceiverView.setBounds(SIX_RECEIVER_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(sixReceiverView, editLevelScreen);

            sixReceiverView.addMouseListener(selectGridElementController);
            sixReceiverView.addMouseMotionListener(selectGridElementController);

        }

        return sixReceiverView;
    }

    public SquareView getOneSquareView() {

        if (oneSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.ONE), null);

            Square square = new Square(null, tile);

            oneSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            oneSquareView.setPreferredSize(ONE_TILE_VIEW_SIZE);
            oneSquareView.setMinimumSize(ONE_TILE_VIEW_SIZE);
            oneSquareView.setMaximumSize(ONE_TILE_VIEW_SIZE);

            oneSquareView.setBounds(ONE_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(oneSquareView, editLevelScreen);

            oneSquareView.addMouseListener(selectGridElementController);
            oneSquareView.addMouseMotionListener(selectGridElementController);

        }

        return oneSquareView;
    }

    public SquareView getTwoSquareView() {

        if (twoSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.TWO), null);

            Square square = new Square(null, tile);

            twoSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            twoSquareView.setPreferredSize(TWO_TILE_VIEW_SIZE);
            twoSquareView.setMinimumSize(TWO_TILE_VIEW_SIZE);
            twoSquareView.setMaximumSize(TWO_TILE_VIEW_SIZE);

            twoSquareView.setBounds(TWO_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(twoSquareView, editLevelScreen);

            twoSquareView.addMouseListener(selectGridElementController);
            twoSquareView.addMouseMotionListener(selectGridElementController);
        }

        return twoSquareView;
    }

    public SquareView getThreeSquareView() {

        if (threeSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.THREE), null);

            Square square = new Square(null, tile);

            threeSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            threeSquareView.setPreferredSize(THREE_TILE_VIEW_SIZE);
            threeSquareView.setMinimumSize(THREE_TILE_VIEW_SIZE);
            threeSquareView.setMaximumSize(THREE_TILE_VIEW_SIZE);

            threeSquareView.setBounds(THREE_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(threeSquareView, editLevelScreen);

            threeSquareView.addMouseListener(selectGridElementController);
            threeSquareView.addMouseMotionListener(selectGridElementController);

        }

        return threeSquareView;
    }

    public SquareView getFourSquareView() {

        if (fourSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.FOUR), null);

            Square square = new Square(null, tile);

            fourSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            fourSquareView.setPreferredSize(FOUR_TILE_VIEW_SIZE);
            fourSquareView.setMinimumSize(FOUR_TILE_VIEW_SIZE);
            fourSquareView.setMaximumSize(FOUR_TILE_VIEW_SIZE);

            fourSquareView.setBounds(FOUR_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(fourSquareView, editLevelScreen);

            fourSquareView.addMouseListener(selectGridElementController);
            fourSquareView.addMouseMotionListener(selectGridElementController);

        }

        return fourSquareView;
    }

    public SquareView getFiveSquareView() {

        if (fiveSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.FIVE), null);

            Square square = new Square(null, tile);

            fiveSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            fiveSquareView.setPreferredSize(FIVE_TILE_VIEW_SIZE);
            fiveSquareView.setMinimumSize(FIVE_TILE_VIEW_SIZE);
            fiveSquareView.setMaximumSize(FIVE_TILE_VIEW_SIZE);

            fiveSquareView.setBounds(FIVE_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(fiveSquareView, editLevelScreen);

            fiveSquareView.addMouseListener(selectGridElementController);
            fiveSquareView.addMouseMotionListener(selectGridElementController);

        }

        return fiveSquareView;
    }

    public SquareView getSixSquareView() {

        if (sixSquareView == null) {

            Tile tile = new Tile(new Value(Utilities.SIX), null);

            Square square = new Square(null, tile);

            sixSquareView = new SquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_HOVERED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    NavigationBar.NO_ROUND
            );


            sixSquareView.setPreferredSize(SIX_TILE_VIEW_SIZE);
            sixSquareView.setMinimumSize(SIX_TILE_VIEW_SIZE);
            sixSquareView.setMaximumSize(SIX_TILE_VIEW_SIZE);

            sixSquareView.setBounds(SIX_TILE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(sixSquareView, editLevelScreen);

            sixSquareView.addMouseListener(selectGridElementController);
            sixSquareView.addMouseMotionListener(selectGridElementController);

        }

        return sixSquareView;
    }

    @Override
    public void modelChanged() {

        if (editLevelScreen.getLevel() instanceof ReleaseLevel) {
            getSixReceiverView().setVisible(true);
        } else {
            getSixReceiverView().setVisible(false);
        }
    }
}
