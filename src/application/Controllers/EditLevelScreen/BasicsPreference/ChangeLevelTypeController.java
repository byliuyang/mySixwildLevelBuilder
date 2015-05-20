package application.Controllers.EditLevelScreen.BasicsPreference;

import application.Contracts.LevelTypeContract;
import application.Models.Grid;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.EditLevelScreenPackage.SquareView;

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
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultPuzzleLevel(editLevelScreen.getLevelId()));
                break;
            case LevelTypeContract.LIGHTNING:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultLightningLevel(editLevelScreen.getLevelId()));
                break;
            case LevelTypeContract.ELIMINATION:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultEliminationLevel(editLevelScreen.getLevelId()));
                break;
            case LevelTypeContract.RELEASE:
                editLevelScreen.setLevel(LevelTypeContract.generateDefaultReleaseLevel(editLevelScreen.getLevelId()));
                break;
        }

        editLevelScreen.modelChanged();
    }
}
