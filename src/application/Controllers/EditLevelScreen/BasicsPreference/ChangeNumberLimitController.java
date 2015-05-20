package application.Controllers.EditLevelScreen.BasicsPreference;

import application.Controllers.EditLevelScreen.ChangePreferenceController;
import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class ChangeNumberLimitController extends ChangePreferenceController {

    public ChangeNumberLimitController(EditLevelScreen editLevelScreen, JTextField numberTextField) {
        super(editLevelScreen, numberTextField);
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
