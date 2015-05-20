package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.StarMilestonePreference.ChangeThreeStarMilestoneController;
import application.Controllers.EditLevelScreen.TileProbabilitiesPreference.*;
import application.Models.Square;
import application.Models.Tile;
import application.Models.Value;
import application.Utilities;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.LevelScreenPackage.SmallSquareView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class TileProbabilityPanel extends JPanel implements IModelUpdated{

    //    Tile probability label size and bounds
    final Dimension TILE_PROBABILITY_LABEL_SIZE = new Dimension(200, 26);
    final Rectangle TILE_PROBABILITY_LABEL_BOUNDS = new Rectangle(20, 20, 200, 26);

    //    Tile one view size and bounds
    final Dimension TILE_ONE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_ONE_VIEW_BOUNDS = new Rectangle(20, 56, 26, 26);

    //    Tile two view size and bounds
    final Dimension TILE_TWO_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_TWO_VIEW_BOUNDS = new Rectangle(20, 92, 26, 26);

    //    Tile three view size and bounds
    final Dimension TILE_THREE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_THREE_VIEW_BOUNDS = new Rectangle(20, 128, 26, 26);

    //    Tile four view size and bounds
    final Dimension TILE_FOUR_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_FOUR_VIEW_BOUNDS = new Rectangle(20, 164, 26, 26);

    //    Tile five view size and bounds
    final Dimension TILE_FIVE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_FIVE_VIEW_BOUNDS = new Rectangle(20, 200, 26, 26);

    //    Tile six view size and bounds
    final Dimension TILE_SIX_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle TILE_SIX_VIEW_BOUNDS = new Rectangle(20, 236, 26, 26);

    //    Tile one text size and bounds
    final Dimension TILE_ONE_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_ONE_TEXT_BOUNDS = new Rectangle(56, 56, 248, 26);

    //    Tile two text size and bounds
    final Dimension TILE_TWO_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_TWO_TEXT_BOUNDS = new Rectangle(56, 92, 248, 26);

    //    Tile three text size and bounds
    final Dimension TILE_THREE_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_THREE_TEXT_BOUNDS = new Rectangle(56, 128, 248, 26);

    //    Tile four text size and bounds
    final Dimension TILE_FOUR_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_FOUR_TEXT_BOUNDS = new Rectangle(56, 164, 248, 26);

    //    Tile five text size and bounds
    final Dimension TILE_FIVE_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_FIVE_TEXT_BOUNDS = new Rectangle(56, 200, 248, 26);

    //    Tile six text size and bounds
    final Dimension TILE_SIX_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle TILE_SIX_TEXT_BOUNDS = new Rectangle(56, 236, 248, 26);

    EditLevelScreen editLevelScreen;

    JLabel tileProbabilitiesLabel;

    SmallSquareView oneTileView;
    SmallSquareView twoTileView;
    SmallSquareView threeTileView;
    SmallSquareView fourTileView;
    SmallSquareView fiveTileView;
    SmallSquareView sixTileView;

    JTextField oneText;
    JTextField twoText;
    JTextField threeText;
    JTextField fourText;
    JTextField fiveText;
    JTextField sixText;

    public TileProbabilityPanel(EditLevelScreen editLevelScreen) {

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
        add(getTileProbabilitiesLabel());

        add(getOneTileView());
        getOneTileView().repaint();

        add(getTwoTileView());
        getTwoTileView().repaint();

        add(getThreeTileView());
        getThreeTileView().repaint();

        add(getFourTileView());
        getFourTileView().repaint();

        add(getFiveTileView());
        getFiveTileView().repaint();

        add(getSixTileView());
        getSixTileView().repaint();

        add(getOneText());
        add(getTwoText());
        add(getThreeText());
        add(getFourText());
        add(getFiveText());
        add(getSixText());

    }

    public JLabel getTileProbabilitiesLabel() {

        if (tileProbabilitiesLabel == null) {
            tileProbabilitiesLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            tileProbabilitiesLabel.setFont(font);

            tileProbabilitiesLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            tileProbabilitiesLabel.setPreferredSize(TILE_PROBABILITY_LABEL_SIZE);
            tileProbabilitiesLabel.setMinimumSize(TILE_PROBABILITY_LABEL_SIZE);
            tileProbabilitiesLabel.setMaximumSize(TILE_PROBABILITY_LABEL_SIZE);

            tileProbabilitiesLabel.setBounds(TILE_PROBABILITY_LABEL_BOUNDS);

            tileProbabilitiesLabel.setText(TextContact.TILE_PROBABILITIES_TEXT);

        }

        return tileProbabilitiesLabel;
    }

    public SmallSquareView getOneTileView() {

        if (oneTileView == null) {

            Tile tile = new Tile(new Value(Utilities.ONE), null);
            Square square = new Square(null, tile);

            oneTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            oneTileView.setPreferredSize(TILE_ONE_VIEW_SIZE);
            oneTileView.setMinimumSize(TILE_ONE_VIEW_SIZE);
            oneTileView.setMaximumSize(TILE_ONE_VIEW_SIZE);

            oneTileView.setBounds(TILE_ONE_VIEW_BOUNDS);

        }

        return oneTileView;
    }

    public SmallSquareView getTwoTileView() {

        if (twoTileView == null) {

            Tile tile = new Tile(new Value(Utilities.TWO), null);
            Square square = new Square(null, tile);

            twoTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            twoTileView.setPreferredSize(TILE_TWO_VIEW_SIZE);
            twoTileView.setMinimumSize(TILE_TWO_VIEW_SIZE);
            twoTileView.setMaximumSize(TILE_TWO_VIEW_SIZE);

            twoTileView.setBounds(TILE_TWO_VIEW_BOUNDS);

        }

        return twoTileView;
    }

    public SmallSquareView getThreeTileView() {

        if (threeTileView == null) {

            Tile tile = new Tile(new Value(Utilities.THREE), null);
            Square square = new Square(null, tile);

            threeTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            threeTileView.setPreferredSize(TILE_THREE_VIEW_SIZE);
            threeTileView.setMinimumSize(TILE_THREE_VIEW_SIZE);
            threeTileView.setMaximumSize(TILE_THREE_VIEW_SIZE);

            threeTileView.setBounds(TILE_THREE_VIEW_BOUNDS);

        }

        return threeTileView;
    }

    public SmallSquareView getFourTileView() {

        if (fourTileView == null) {

            Tile tile = new Tile(new Value(Utilities.FOUR), null);
            Square square = new Square(null, tile);

            fourTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            fourTileView.setPreferredSize(TILE_FOUR_VIEW_SIZE);
            fourTileView.setMinimumSize(TILE_FOUR_VIEW_SIZE);
            fourTileView.setMaximumSize(TILE_FOUR_VIEW_SIZE);

            fourTileView.setBounds(TILE_FOUR_VIEW_BOUNDS);

        }

        return fourTileView;
    }

    public SmallSquareView getFiveTileView() {

        if (fiveTileView == null) {

            Tile tile = new Tile(new Value(Utilities.FIVE), null);
            Square square = new Square(null, tile);

            fiveTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            fiveTileView.setPreferredSize(TILE_FIVE_VIEW_SIZE);
            fiveTileView.setMinimumSize(TILE_FIVE_VIEW_SIZE);
            fiveTileView.setMaximumSize(TILE_FIVE_VIEW_SIZE);

            fiveTileView.setBounds(TILE_FIVE_VIEW_BOUNDS);

        }

        return fiveTileView;
    }

    public SmallSquareView getSixTileView() {

        if (sixTileView == null) {

            Tile tile = new Tile(new Value(Utilities.SIX), null);
            Square square = new Square(null, tile);

            sixTileView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            sixTileView.setPreferredSize(TILE_SIX_VIEW_SIZE);
            sixTileView.setMinimumSize(TILE_SIX_VIEW_SIZE);
            sixTileView.setMaximumSize(TILE_SIX_VIEW_SIZE);

            sixTileView.setBounds(TILE_SIX_VIEW_BOUNDS);

        }

        return sixTileView;
    }

    public JTextField getOneText() {

        if (oneText == null) {

            oneText = new JTextField();

            oneText.setPreferredSize(TILE_ONE_TEXT_SIZE);
            oneText.setMinimumSize(TILE_ONE_TEXT_SIZE);
            oneText.setMaximumSize(TILE_ONE_TEXT_SIZE);

            oneText.setBounds(TILE_ONE_TEXT_BOUNDS);

            ChangeTileOneProbabilityController changeTileOneProbabilityController =
                    new ChangeTileOneProbabilityController(editLevelScreen, oneText);

            oneText.addActionListener(changeTileOneProbabilityController);
            oneText.addFocusListener(changeTileOneProbabilityController);
        }

        return oneText;
    }

    public JTextField getTwoText() {

        if (twoText == null) {

            twoText = new JTextField();

            twoText.setPreferredSize(TILE_TWO_TEXT_SIZE);
            twoText.setMinimumSize(TILE_TWO_TEXT_SIZE);
            twoText.setMaximumSize(TILE_TWO_TEXT_SIZE);

            twoText.setBounds(TILE_TWO_TEXT_BOUNDS);

            ChangeTileTwoProbabilityController changeTileTwoProbabilityController =
                    new ChangeTileTwoProbabilityController(editLevelScreen, twoText);

            twoText.addActionListener(changeTileTwoProbabilityController);
            twoText.addFocusListener(changeTileTwoProbabilityController);
        }

        return twoText;
    }

    public JTextField getThreeText() {

        if (threeText == null) {

            threeText = new JTextField();

            threeText.setPreferredSize(TILE_THREE_TEXT_SIZE);
            threeText.setMinimumSize(TILE_THREE_TEXT_SIZE);
            threeText.setMaximumSize(TILE_THREE_TEXT_SIZE);

            threeText.setBounds(TILE_THREE_TEXT_BOUNDS);

            ChangeTileThreeProbabilityController changeTileThreeProbabilityController =
                    new ChangeTileThreeProbabilityController(editLevelScreen, threeText);

            threeText.addActionListener(changeTileThreeProbabilityController);
            threeText.addFocusListener(changeTileThreeProbabilityController);
        }

        return threeText;
    }

    public JTextField getFourText() {

        if (fourText == null) {

            fourText = new JTextField();

            fourText.setPreferredSize(TILE_FOUR_TEXT_SIZE);
            fourText.setMinimumSize(TILE_FOUR_TEXT_SIZE);
            fourText.setMaximumSize(TILE_FOUR_TEXT_SIZE);

            fourText.setBounds(TILE_FOUR_TEXT_BOUNDS);

            ChangeTileFourProbabilityController changeTileFourProbabilityController =
                    new ChangeTileFourProbabilityController(editLevelScreen, fourText);

            fourText.addActionListener(changeTileFourProbabilityController);
            fourText.addFocusListener(changeTileFourProbabilityController);
        }

        return fourText;
    }

    public JTextField getFiveText() {

        if (fiveText == null) {

            fiveText = new JTextField();

            fiveText.setPreferredSize(TILE_FIVE_TEXT_SIZE);
            fiveText.setMinimumSize(TILE_FIVE_TEXT_SIZE);
            fiveText.setMaximumSize(TILE_FIVE_TEXT_SIZE);

            fiveText.setBounds(TILE_FIVE_TEXT_BOUNDS);

            ChangeTileFiveProbabilityController changeTileFiveProbabilityController =
                    new ChangeTileFiveProbabilityController(editLevelScreen, fiveText);

            fiveText.addActionListener(changeTileFiveProbabilityController);
            fiveText.addFocusListener(changeTileFiveProbabilityController);
        }

        return fiveText;
    }

    public JTextField getSixText() {

        if (sixText == null) {

            sixText = new JTextField();

            sixText.setPreferredSize(TILE_SIX_TEXT_SIZE);
            sixText.setMinimumSize(TILE_SIX_TEXT_SIZE);
            sixText.setMaximumSize(TILE_SIX_TEXT_SIZE);

            sixText.setBounds(TILE_SIX_TEXT_BOUNDS);

            ChangeTileSixProbabilityController changeTileSixProbabilityController =
                    new ChangeTileSixProbabilityController(editLevelScreen, sixText);

            sixText.addActionListener(changeTileSixProbabilityController);
            sixText.addFocusListener(changeTileSixProbabilityController);
        }

        return sixText;
    }

    @Override
    public void modelChanged() {
        getOneText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileOne().toString());
        getTwoText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileTwo().toString());
        getThreeText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileThree().toString());
        getFourText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileFour().toString());
        getFiveText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileFive().toString());
        getSixText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getTileSix().toString());
    }
}
