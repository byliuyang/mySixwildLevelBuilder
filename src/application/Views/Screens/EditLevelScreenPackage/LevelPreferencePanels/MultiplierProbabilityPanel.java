package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.MultiplierPreference.ChangeMultiplierOneProbabilityController;
import application.Controllers.EditLevelScreen.MultiplierPreference.ChangeMultiplierThreeProbabilityController;
import application.Controllers.EditLevelScreen.MultiplierPreference.ChangeMultiplierTwoProbabilityController;
import application.Controllers.EditLevelScreen.TileProbabilitiesPreference.ChangeTileOneProbabilityController;
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
public class MultiplierProbabilityPanel extends JPanel implements IModelUpdated{

    //    Multiplier probability label size and bounds
    final Dimension MULTIPLIER_PROBABILITY_LABEL_SIZE = new Dimension(300, 26);
    final Rectangle MULTIPLIER_PROBABILITY_LABEL_BOUNDS = new Rectangle(20, 20, 300, 26);

    //    Multiplier one view size and bounds
    final Dimension MULTIPLIER_ONE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_ONE_VIEW_BOUNDS = new Rectangle(20, 56, 26, 26);

    //    Multiplier two view size and bounds
    final Dimension MULTIPLIER_TWO_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_TWO_VIEW_BOUNDS = new Rectangle(20, 92, 26, 26);

    //    Multiplier three view size and bounds
    final Dimension MULTIPLIER_THREE_VIEW_SIZE = new Dimension(26, 26);
    final Rectangle MULTIPLIER_THREE_VIEW_BOUNDS = new Rectangle(20, 128, 26, 26);

    //    Multiplier one text size and bounds
    final Dimension MULTIPLIER_ONE_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle MULTIPLIER_ONE_TEXT_BOUNDS = new Rectangle(56, 56, 248, 26);

    //    Multiplier two text size and bounds
    final Dimension MULTIPLIER_TWO_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle MULTIPLIER_TWO_TEXT_BOUNDS = new Rectangle(56, 92, 248, 26);

    //    Multiplier three text size and bounds
    final Dimension MULTIPLIER_THREE_TEXT_SIZE = new Dimension(248, 26);
    final Rectangle MULTIPLIER_THREE_TEXT_BOUNDS = new Rectangle(56, 128, 248, 26);

    EditLevelScreen editLevelScreen;

    JLabel multiplierProbabilitiesLabel;

    SmallSquareView oneMultiplierView;
    SmallSquareView twoMultiplierView;
    SmallSquareView threeMultiplierView;

    JTextField oneText;
    JTextField twoText;
    JTextField threeText;

    public MultiplierProbabilityPanel(EditLevelScreen editLevelScreen) {

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

        add(getMultiplierProbabilitiesLabel());

        add(getOneMultiplierView());
        getOneMultiplierView().repaint();

        add(getTwoMultiplierView());
        getTwoMultiplierView().repaint();

        add(getThreeMultiplierView());
        getThreeMultiplierView().repaint();

        add(getOneText());
        add(getTwoText());
        add(getThreeText());

    }

    public JLabel getMultiplierProbabilitiesLabel() {

        if (multiplierProbabilitiesLabel == null)

        {
            multiplierProbabilitiesLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            multiplierProbabilitiesLabel.setFont(font);

            multiplierProbabilitiesLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            multiplierProbabilitiesLabel.setPreferredSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);
            multiplierProbabilitiesLabel.setMinimumSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);
            multiplierProbabilitiesLabel.setMaximumSize(MULTIPLIER_PROBABILITY_LABEL_SIZE);

            multiplierProbabilitiesLabel.setBounds(MULTIPLIER_PROBABILITY_LABEL_BOUNDS);

            multiplierProbabilitiesLabel.setText(TextContact.MULTIPLIER_PROBABILITIES_TEXT);

        }

        return multiplierProbabilitiesLabel;
    }

    public SmallSquareView getOneMultiplierView() {

        if (oneMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.ONE), null);
            Square square = new Square(null, multiplier);

            oneMultiplierView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            oneMultiplierView.setPreferredSize(MULTIPLIER_ONE_VIEW_SIZE);
            oneMultiplierView.setMinimumSize(MULTIPLIER_ONE_VIEW_SIZE);
            oneMultiplierView.setMaximumSize(MULTIPLIER_ONE_VIEW_SIZE);

            oneMultiplierView.setBounds(MULTIPLIER_ONE_VIEW_BOUNDS);

        }

        return oneMultiplierView;
    }

    public SmallSquareView getTwoMultiplierView() {

        if (twoMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.TWO), null);
            Square square = new Square(null, multiplier);

            twoMultiplierView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            twoMultiplierView.setPreferredSize(MULTIPLIER_TWO_VIEW_SIZE);
            twoMultiplierView.setMinimumSize(MULTIPLIER_TWO_VIEW_SIZE);
            twoMultiplierView.setMaximumSize(MULTIPLIER_TWO_VIEW_SIZE);

            twoMultiplierView.setBounds(MULTIPLIER_TWO_VIEW_BOUNDS);

        }

        return twoMultiplierView;
    }

    public SmallSquareView getThreeMultiplierView() {

        if (threeMultiplierView == null) {

            Tile multiplier = new Tile(new Value(Utilities.THREE), null);
            Square square = new Square(null, multiplier);

            threeMultiplierView = new SmallSquareView(
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    square,
                    Utilities.ZERO
            );

            threeMultiplierView.setPreferredSize(MULTIPLIER_THREE_VIEW_SIZE);
            threeMultiplierView.setMinimumSize(MULTIPLIER_THREE_VIEW_SIZE);
            threeMultiplierView.setMaximumSize(MULTIPLIER_THREE_VIEW_SIZE);

            threeMultiplierView.setBounds(MULTIPLIER_THREE_VIEW_BOUNDS);

        }

        return threeMultiplierView;
    }

    public JTextField getOneText() {

        if (oneText == null) {

            oneText = new JTextField();

            oneText.setPreferredSize(MULTIPLIER_ONE_TEXT_SIZE);
            oneText.setMinimumSize(MULTIPLIER_ONE_TEXT_SIZE);
            oneText.setMaximumSize(MULTIPLIER_ONE_TEXT_SIZE);

            oneText.setBounds(MULTIPLIER_ONE_TEXT_BOUNDS);

            ChangeMultiplierOneProbabilityController changeMultiplierOneProbabilityController =
                    new ChangeMultiplierOneProbabilityController(editLevelScreen, oneText);

            oneText.addActionListener(changeMultiplierOneProbabilityController);
            oneText.addFocusListener(changeMultiplierOneProbabilityController);
        }

        return oneText;
    }

    public JTextField getTwoText() {

        if (twoText == null) {

            twoText = new JTextField();

            twoText.setPreferredSize(MULTIPLIER_TWO_TEXT_SIZE);
            twoText.setMinimumSize(MULTIPLIER_TWO_TEXT_SIZE);
            twoText.setMaximumSize(MULTIPLIER_TWO_TEXT_SIZE);

            twoText.setBounds(MULTIPLIER_TWO_TEXT_BOUNDS);

            ChangeMultiplierTwoProbabilityController changeMultiplierTwoProbabilityController =
                    new ChangeMultiplierTwoProbabilityController(editLevelScreen, twoText);

            twoText.addActionListener(changeMultiplierTwoProbabilityController);
            twoText.addFocusListener(changeMultiplierTwoProbabilityController);
        }

        return twoText;
    }

    public JTextField getThreeText() {

        if (threeText == null) {

            threeText = new JTextField();

            threeText.setPreferredSize(MULTIPLIER_THREE_TEXT_SIZE);
            threeText.setMinimumSize(MULTIPLIER_THREE_TEXT_SIZE);
            threeText.setMaximumSize(MULTIPLIER_THREE_TEXT_SIZE);

            threeText.setBounds(MULTIPLIER_THREE_TEXT_BOUNDS);

            ChangeMultiplierThreeProbabilityController changeMultiplierThreeProbabilityController =
                    new ChangeMultiplierThreeProbabilityController(editLevelScreen, threeText);

            threeText.addActionListener(changeMultiplierThreeProbabilityController);
            threeText.addFocusListener(changeMultiplierThreeProbabilityController);
        }

        return threeText;
    }

    @Override
    public void modelChanged() {
        getOneText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getMultiplierOne().toString());
        getTwoText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getMultiplierTwo().toString());
        getThreeText().setText((editLevelScreen.getLevel()).getGrid().getProbabilities().getMultiplierThree().toString());
    }
}
