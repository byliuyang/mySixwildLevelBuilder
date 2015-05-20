package application.Controllers.EditLevelScreen.GridMap;

import application.Controllers.ButtonController;
import application.Utilities;
import application.Views.Components.StyledButton;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.EditLevelScreenPackage.SquareView;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class SelectGridElementController extends ButtonController {

    EditLevelScreen editLevelScreen;
    SquareView draggedView;

    public SelectGridElementController(StyledButton button, EditLevelScreen editLevelScreen) {
        super(button);
        this.editLevelScreen = editLevelScreen;
        draggedView = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(editLevelScreen.getActiveView() == null) {
            button.actived();

            editLevelScreen.setActiveView(button);
        } else {
            editLevelScreen.getActiveView().inactive();
            editLevelScreen.setActiveView(null);
        }
    }
}
