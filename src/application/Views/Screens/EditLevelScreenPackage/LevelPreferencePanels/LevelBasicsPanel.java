package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Utilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelBasicsPanel extends JPanel {
    //    Level type label size and bounds
    final Dimension LEVEL_TYPE_LABEL_SIZE = new Dimension(100, 26);
    final Rectangle LEVEL_TYPE_LABEL_BOUNDS = new Rectangle(20, 8, 100, 26);

    //    Level type comboBox size and bounds
    final Dimension LEVEL_TYPE_COMBO_BOX_SIZE = new Dimension();
    final Rectangle LEVEL_TYPE_COMBO_BOX_BOUNDS = new Rectangle();

    //    Level number label size and bounds
    final Dimension LEVEL_NUMBER_LABEL_SIZE = new Dimension();
    final Rectangle LEVEL_NUMBER_LABEL_BOUNDS = new Rectangle();

    //    Level number limit text size and bounds
    final Dimension LEVEL_NUMBER_LIMIT_TEXT_SIZE = new Dimension();
    final Rectangle LEVEL_NUMBER_LIMIT_TEXT_BOUNDS = new Rectangle();


    JLabel levelTypeLabel;
    JComboBox levelTypeComboBox;

    JLabel numberLimitLabel;
    JTextField numberLimitTextField;

    public LevelBasicsPanel() {
    }

    public JLabel getLevelTypeLabel() {
        if(levelTypeLabel == null) {
            levelTypeLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            levelTypeLabel.setFont(font);

            levelTypeLabel.setPreferredSize(LEVEL_TYPE_LABEL_SIZE);
            levelTypeLabel.setMinimumSize(LEVEL_TYPE_LABEL_SIZE);
            levelTypeLabel.setMaximumSize(LEVEL_TYPE_LABEL_SIZE);

            levelTypeLabel.setBounds(LEVEL_TYPE_LABEL_BOUNDS);

            add(levelTypeLabel);

        }

        return levelTypeLabel;
    }

    public JComboBox getLevelTypeComboBox() {
        return levelTypeComboBox;
    }

    public JLabel getNumberLimitLabel() {
        return numberLimitLabel;
    }

    public JTextField getNumberLimitTextField() {
        return numberLimitTextField;
    }
}
