package application.Controllers.EditLevelScreen.BasicsPreference;

import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by harryliu on 5/19/15.
 */
public class ChangeNumberLimitController implements ActionListener {

    EditLevelScreen editLevelScreen;
    JTextField numberTextField;

    public ChangeNumberLimitController(EditLevelScreen editLevelScreen, JTextField numberTextField) {
        this.editLevelScreen = editLevelScreen;
        this.numberTextField = numberTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Level level = editLevelScreen.getLevel();

        if (level instanceof PuzzleLevel) {

            try {
                long numberMoveLeft = Long.parseLong(numberTextField.getText());
                ((PuzzleLevel) level).getSwapNeighborMoveLeft().setValue(numberMoveLeft);
            } catch (Exception ex) {
                editLevelScreen.getLevelPreferencePanel().getLevelBasicsPanel().modelChanged();
            }
        } else if (level instanceof LightningLevel) {
            try {
                long numberMoveLeft = Long.parseLong(numberTextField.getText());
                ((LightningLevel) level).getTime().getEndTime().setValue(numberMoveLeft);
            } catch (Exception ex) {
                editLevelScreen.getLevelPreferencePanel().getLevelBasicsPanel().modelChanged();
            }
        }
    }
}
