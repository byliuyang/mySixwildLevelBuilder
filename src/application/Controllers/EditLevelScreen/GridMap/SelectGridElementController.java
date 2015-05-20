package application.Controllers.EditLevelScreen.GridMap;

import application.Controllers.ButtonController;
import application.Views.Components.StyledButton;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class SelectGridElementController extends ButtonController {

    EditLevelScreen editLevelScreen;

    public SelectGridElementController(StyledButton button, EditLevelScreen editLevelScreen) {
        super(button);
        this.editLevelScreen = editLevelScreen;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        editLevelScreen.setActiveView(button);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released");
    }
}
