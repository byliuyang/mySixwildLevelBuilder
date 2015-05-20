package application.Controllers.EditLevelScreen.SpecialMovePreference;

import application.Controllers.EditLevelScreen.ChangePreferenceController;
import application.Models.Levels.Level;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class ChangeSwapSquareSpecialMoveLimitController extends ChangePreferenceController {

    public ChangeSwapSquareSpecialMoveLimitController(EditLevelScreen editLevelScreen, JTextField numberTextField) {
        super(editLevelScreen, numberTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Level level = editLevelScreen.getLevel();

        try {
            long numberSwapSpecialMoveLeft = Long.parseLong(numberTextField.getText());
            level.getSpecialMoveLeft().getSwapTileSpecialMove().setValue(numberSwapSpecialMoveLeft);
        } catch (Exception ex) {
            editLevelScreen.getLevelPreferencePanel().getLevelSpecialMovePanel().modelChanged();
        }
    }
}
