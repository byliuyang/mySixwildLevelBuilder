package application.Controllers.EditLevelScreen;

import application.Controllers.NavigationBar.GoBackButtonController;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/20/15.
 */
public class FinishEditingLevelController extends GoBackButtonController {
    public FinishEditingLevelController(StyledButton button, Application app) {
        super(button, app);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Utilities.saveLevelState(app.getEditLevelScreen().getLevel());

        app.getLevelsScreen().setUpLevelList();

        app.getEditLevelScreen().setLevel(null);

        super.mouseClicked(e);
    }
}
