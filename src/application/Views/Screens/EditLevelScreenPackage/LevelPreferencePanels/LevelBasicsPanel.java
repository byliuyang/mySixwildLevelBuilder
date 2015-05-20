package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.BasicsPreference.ChangeLevelTypeController;
import application.Controllers.EditLevelScreen.BasicsPreference.ChangeNumberLimitController;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Utilities;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelBasicsPanel extends JPanel implements IModelUpdated {
    //    Level type label size and bounds
    final Dimension LEVEL_TYPE_LABEL_SIZE = new Dimension(200, 26);
    final Rectangle LEVEL_TYPE_LABEL_BOUNDS = new Rectangle(20, 20, 200, 26);

    //    Level type comboBox size and bounds
    final Dimension LEVEL_TYPE_COMBO_BOX_SIZE = new Dimension(284, 30);
    final Rectangle LEVEL_TYPE_COMBO_BOX_BOUNDS = new Rectangle(20, 56, 284, 30);

    //    Level number label size and bounds
    final Dimension LEVEL_NUMBER_LABEL_SIZE = new Dimension(200, 26);
    final Rectangle LEVEL_NUMBER_LABEL_BOUNDS = new Rectangle(20, 96, 200, 30);

    //    Level number limit text size and bounds
    final Dimension LEVEL_NUMBER_LIMIT_TEXT_SIZE = new Dimension(284, 26);
    final Rectangle LEVEL_NUMBER_LIMIT_TEXT_BOUNDS = new Rectangle(20, 136, 284, 30);

    EditLevelScreen editLevelScreen;

    JLabel levelTypeLabel;
    JComboBox levelTypeComboBox;

    JLabel numberLimitLabel;
    JTextField numberLimitTextField;

    public LevelBasicsPanel(EditLevelScreen editLevelScreen) {

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

//        Add controls into basics panel
        add(getLevelTypeLabel());
        add(getLevelTypeComboBox());

        add(getNumberLimitLabel());
        add(getNumberLimitTextField());
    }

    public JLabel getLevelTypeLabel() {
        if (levelTypeLabel == null) {
            levelTypeLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            levelTypeLabel.setFont(font);

            levelTypeLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            levelTypeLabel.setPreferredSize(LEVEL_TYPE_LABEL_SIZE);
            levelTypeLabel.setMinimumSize(LEVEL_TYPE_LABEL_SIZE);
            levelTypeLabel.setMaximumSize(LEVEL_TYPE_LABEL_SIZE);

            levelTypeLabel.setBounds(LEVEL_TYPE_LABEL_BOUNDS);

            levelTypeLabel.setText(TextContact.SELECT_LEVEL_TYPE_TEXT);

        }

        return levelTypeLabel;
    }

    public JComboBox getLevelTypeComboBox() {
        if (levelTypeComboBox == null) {
            String[] LEVEL_TYPES = {
                    TextContact.LEVEL_TYPE_PUZZLE,
                    TextContact.LEVEL_TYPE_LIGHTNING,
                    TextContact.LEVEL_TYPE_ELIMINATION,
                    TextContact.LEVEL_TYPE_RELEASE
            };

            levelTypeComboBox = new JComboBox(LEVEL_TYPES);
            levelTypeComboBox.setSelectedIndex(0);

            levelTypeComboBox.setPreferredSize(LEVEL_TYPE_COMBO_BOX_SIZE);
            levelTypeComboBox.setMinimumSize(LEVEL_TYPE_COMBO_BOX_SIZE);
            levelTypeComboBox.setMaximumSize(LEVEL_TYPE_COMBO_BOX_SIZE);

            levelTypeComboBox.setBounds(LEVEL_TYPE_COMBO_BOX_BOUNDS);

            levelTypeComboBox.addActionListener(new ChangeLevelTypeController(editLevelScreen));

        }

        return levelTypeComboBox;
    }

    public JLabel getNumberLimitLabel() {
        if (numberLimitLabel == null) {

            numberLimitLabel = new JLabel(TextContact.MOVE_LIMIT_TEXT);

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            numberLimitLabel.setFont(font);

            numberLimitLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            numberLimitLabel.setPreferredSize(LEVEL_NUMBER_LABEL_SIZE);
            numberLimitLabel.setMinimumSize(LEVEL_NUMBER_LABEL_SIZE);
            numberLimitLabel.setMaximumSize(LEVEL_NUMBER_LABEL_SIZE);

            numberLimitLabel.setBounds(LEVEL_NUMBER_LABEL_BOUNDS);

        }

        return numberLimitLabel;
    }

    public JTextField getNumberLimitTextField() {
        if (numberLimitTextField == null) {

            numberLimitTextField = new JTextField();

            numberLimitTextField.setPreferredSize(LEVEL_NUMBER_LIMIT_TEXT_SIZE);
            numberLimitTextField.setMinimumSize(LEVEL_NUMBER_LIMIT_TEXT_SIZE);
            numberLimitTextField.setMaximumSize(LEVEL_NUMBER_LIMIT_TEXT_SIZE);

            numberLimitTextField.setBounds(LEVEL_NUMBER_LIMIT_TEXT_BOUNDS);

            ChangeNumberLimitController changeNumberLimitController = new ChangeNumberLimitController(editLevelScreen, numberLimitTextField);

            numberLimitTextField.addActionListener(changeNumberLimitController);
            numberLimitTextField.addFocusListener(changeNumberLimitController);
        }

        return numberLimitTextField;
    }

    @Override
    public void modelChanged() {

        if (editLevelScreen.getLevel() instanceof PuzzleLevel) {
            getNumberLimitLabel().setText(TextContact.MOVE_LIMIT_TEXT);

            getNumberLimitTextField().setText(((PuzzleLevel) editLevelScreen.getLevel()).getSwapNeighborMoveLeft().toString());

            getNumberLimitLabel().setVisible(true);
            getNumberLimitTextField().setVisible(true);

        } else if (editLevelScreen.getLevel() instanceof LightningLevel) {

            getNumberLimitLabel().setText(TextContact.TIME_LIMIT_TEXT);

            getNumberLimitTextField().setText(((LightningLevel) editLevelScreen.getLevel()).getTime().getEndTime().toString());

            getNumberLimitLabel().setVisible(true);
            getNumberLimitTextField().setVisible(true);

        } else {
            getNumberLimitLabel().setVisible(false);
            getNumberLimitTextField().setVisible(false);
        }
    }
}
