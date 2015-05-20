package application.Controllers.EditLevelScreen.BasicsPreference;

import application.Contracts.LevelTypeContract;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by harryliu on 5/19/15.
 */
public class ChangeLevelTypeController implements ActionListener {

    EditLevelScreen editLevelScreen;

    public ChangeLevelTypeController(EditLevelScreen editLevelScreen) {
        this.editLevelScreen = editLevelScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JComboBox) e.getSource()).getSelectedIndex()) {
            case LevelTypeContract.PUZZLE:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultPuzzleLevel());
                break;
            case LevelTypeContract.LIGHTNING:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultLightningLevel());
                break;
            case LevelTypeContract.ELIMINATION:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultEliminationLevel());
                break;
            case LevelTypeContract.RELEASE:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultReleaseLevel());
                break;
        }

        editLevelScreen.modelChanged();
    }
}
