package application.Controllers.EditLevelScreen.MultiplierPreference;

import application.Controllers.EditLevelScreen.ChangePreferenceController;
import application.Models.Levels.Level;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class ChangeMultiplierThreeProbabilityController extends ChangePreferenceController{

    public ChangeMultiplierThreeProbabilityController(EditLevelScreen editLevelScreen, JTextField numberTextField) {
        super(editLevelScreen, numberTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Level level = editLevelScreen.getLevel();

        try {
            long probability = Long.parseLong(numberTextField.getText());
            level.getGrid().getProbabilities().getTileThree().setValue(probability);
        } catch (Exception ex) {
            editLevelScreen.getLevelPreferencePanel().getTileProbabilityPanel().modelChanged();
        }
    }
}
