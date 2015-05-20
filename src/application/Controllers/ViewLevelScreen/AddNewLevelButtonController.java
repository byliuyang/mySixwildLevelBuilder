package application.Controllers.ViewLevelScreen;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/14/15.
 */
public class AddNewLevelButtonController extends ButtonController {

    Application app;

    public AddNewLevelButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.getEditLevelScreen().setLevelId(app.getLevelsScreen().getNumberLevels() + 1);
        app.getEditLevelScreen().initialize();
        app.getEditLevelScreen().modelChanged();

        app.switchTo(app.getEditLevelScreen());
    }
}
