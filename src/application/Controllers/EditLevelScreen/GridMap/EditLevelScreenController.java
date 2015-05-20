package application.Controllers.EditLevelScreen.GridMap;

import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class EditLevelScreenController extends MouseAdapter {
    EditLevelScreen editLevelScreen;

    public EditLevelScreenController(EditLevelScreen editLevelScreen) {
        this.editLevelScreen = editLevelScreen;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (editLevelScreen.getActiveView() != null) {
            editLevelScreen.getActiveView().setVisible(true);
            editLevelScreen.getActiveView().setLocation(e.getPoint());
        }
    }
}
