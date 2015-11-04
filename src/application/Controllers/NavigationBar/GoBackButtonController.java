package application.Controllers.NavigationBar;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class GoBackButtonController extends ButtonController {

    protected Application app;

    public GoBackButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        app.getLevelsScreen().setUpLevelList();
        app.getEditLevelScreen().setLevel(null);
        app.switchTo(app.getLevelsScreen());
    }
}