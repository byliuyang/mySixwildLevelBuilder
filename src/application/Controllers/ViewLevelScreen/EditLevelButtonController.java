package application.Controllers.ViewLevelScreen;

import application.Controllers.ButtonController;
import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.StyledButton;
import application.Views.Screens.LevelScreenPackage.LevelDetailPanel;

import java.awt.event.MouseEvent;

/**
 *
 */
public class EditLevelButtonController extends ButtonController {

    Application app;
    LevelDetailPanel levelDetailPanel;

    public EditLevelButtonController(StyledButton button, LevelDetailPanel levelDetailPanel, Application app) {
        super(button);
        this.levelDetailPanel = levelDetailPanel;
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Level level = levelDetailPanel.getLevel();

        app.getEditLevelScreen().setLevel(level);
        app.getEditLevelScreen().initialize();
        app.getEditLevelScreen().modelChanged();

        app.switchTo(app.getEditLevelScreen());
    }
}