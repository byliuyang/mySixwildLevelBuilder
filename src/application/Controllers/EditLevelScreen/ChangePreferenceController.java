package application.Controllers.EditLevelScreen;

import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by harryliu on 5/19/15.
 */
public abstract class ChangePreferenceController implements ActionListener, FocusListener{

    protected EditLevelScreen editLevelScreen;
    protected JTextField numberTextField;

    public ChangePreferenceController(EditLevelScreen editLevelScreen, JTextField numberTextField) {
        this.editLevelScreen = editLevelScreen;
        this.numberTextField = numberTextField;
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public void focusGained(FocusEvent e) {
        return;
    }

    @Override
    public void focusLost(FocusEvent e) {
        actionPerformed(null);
    }
}
