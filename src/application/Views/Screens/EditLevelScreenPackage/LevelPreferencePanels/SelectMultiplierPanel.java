package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.GridMap.SelectGridElementController;
import application.Models.Square;
import application.Models.Tile;
import application.Models.Value;
import application.Utilities;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.EditLevelScreenPackage.GridView;
import application.Views.Screens.LevelScreenPackage.SmallSquareView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class SelectMultiplierPanel extends JPanel {

    //    Multiplier probability label size and bounds
    final Dimension MULTIPLIER_PROBABILITY_LABEL_SIZE = new Dimension(300, 26);
    final Rectangle MULTIPLIER_PROBABILITY_LABEL_BOUNDS = new Rectangle(20, 20, 300, 26);

    //    Multiplier one view size and bounds
    final Dimension MULTIPLIER_ONE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_ONE_VIEW_BOUNDS = new Rectangle(20, 56, 26, 26);

    //    Multiplier two view size and bounds
    final Dimension MULTIPLIER_TWO_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_TWO_VIEW_BOUNDS = new Rectangle(56, 56, 26, 26);

    //    Multiplier three view size and bounds
    final Dimension MULTIPLIER_THREE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_THREE_VIEW_BOUNDS = new Rectangle(92, 56, 26, 26);

    EditLevelScreen editLevelScreen;

    JLabel selectMultiplierLabel;

    SmallSquareView oneMultiplierView;
    SmallSquareView twoMultiplierView;
    SmallSquareView threeMultiplierView;

    public SelectMultiplierPanel(EditLevelScreen editLevelScreen) {

        this.editLevelScreen = editLevelScreen;

        setLayout(null);

        setBackground(Color.WHITE);

//        Add elements into panel

        add(getSelectMultiplierLabel());

        add(getOneMultiplierView());
        getOneMultiplierView().repaint();

        add(getTwoMultiplierView());
        getTwoMultiplierView().repaint();

        add(getThreeMultiplierView());
        getThreeMultiplierView().repaint();

    }

    public JLabel getSelectMultiplierLabel() {

        if (selectMultiplierLabel == null)

        {
            selectMultiplierLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            selectMultiplierLabel.setFont(font);

            selectMultiplierLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            selectMultiplierLabel.setPreferredSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);
            selectMultiplierLabel.setMinimumSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);
            selectMultiplierLabel.setMaximumSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);

            selectMultiplierLabel.setBounds(MULTIPLIER_PROBABILITY_LABEL_BOUNDS);

            selectMultiplierLabel.setText(TextContact.SELECT_MULTIPLIER_TEXT);

        }

        return selectMultiplierLabel;
    }

    public SmallSquareView getOneMultiplierView() {

        if (oneMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.ONE), null);
            Square square = new Square(null, multiplier);

            oneMultiplierView = new SmallSquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    Utilities.ZERO
            );

            oneMultiplierView.setPreferredSize(MULTIPLIER_ONE_VIEW_SIZE);
            oneMultiplierView.setMinimumSize(MULTIPLIER_ONE_VIEW_SIZE);
            oneMultiplierView.setMaximumSize(MULTIPLIER_ONE_VIEW_SIZE);

            oneMultiplierView.setBounds(MULTIPLIER_ONE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(oneMultiplierView, editLevelScreen);

            oneMultiplierView.addMouseListener(selectGridElementController);
            oneMultiplierView.addMouseMotionListener(selectGridElementController);

        }

        return oneMultiplierView;
    }

    public SmallSquareView getTwoMultiplierView() {

        if (twoMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.TWO), null);
            Square square = new Square(null, multiplier);

            twoMultiplierView = new SmallSquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    Utilities.ZERO
            );

            twoMultiplierView.setPreferredSize(MULTIPLIER_TWO_VIEW_SIZE);
            twoMultiplierView.setMinimumSize(MULTIPLIER_TWO_VIEW_SIZE);
            twoMultiplierView.setMaximumSize(MULTIPLIER_TWO_VIEW_SIZE);

            twoMultiplierView.setBounds(MULTIPLIER_TWO_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(twoMultiplierView, editLevelScreen);

            twoMultiplierView.addMouseListener(selectGridElementController);
            twoMultiplierView.addMouseMotionListener(selectGridElementController);

        }

        return twoMultiplierView;
    }

    public SmallSquareView getThreeMultiplierView() {

        if (threeMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.THREE), null);
            Square square = new Square(null, multiplier);

            threeMultiplierView = new SmallSquareView(
                    GridView.SQUARE_NORMAL_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    GridView.SQUARE_DISABLED_BACK_COLOR,
                    square,
                    Utilities.ZERO
            );

            threeMultiplierView.setPreferredSize(MULTIPLIER_THREE_VIEW_SIZE);
            threeMultiplierView.setMinimumSize(MULTIPLIER_THREE_VIEW_SIZE);
            threeMultiplierView.setMaximumSize(MULTIPLIER_THREE_VIEW_SIZE);

            threeMultiplierView.setBounds(MULTIPLIER_THREE_VIEW_BOUNDS);

            SelectGridElementController selectGridElementController
                    = new SelectGridElementController(threeMultiplierView, editLevelScreen);

            threeMultiplierView.addMouseListener(selectGridElementController);
            threeMultiplierView.addMouseMotionListener(selectGridElementController);


        }

        return threeMultiplierView;
    }
}
