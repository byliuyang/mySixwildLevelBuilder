package application.Controllers.ViewLevelScreen;

import application.Controllers.ButtonController;
import application.Models.Levels.Level;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.StyledButton;
import application.Views.Screens.LevelScreenPackage.LevelDetailPanel;

import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;

/**
 *
 */
public class DeleteLevelButtonController extends ButtonController {

    Application app;
    LevelDetailPanel levelDetailPanel;

    public DeleteLevelButtonController(StyledButton button, LevelDetailPanel levelDetailPanel, Application app) {
        super(button);
        this.levelDetailPanel = levelDetailPanel;
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Level level = levelDetailPanel.getLevel();

        int levelId = (int) level.getId().getValue();

        for (int id = levelId + 1; id <= app.getLevelsScreen().getNumberLevels(); id++) {

            Level tmpLevel = app.getLevelsScreen().getLevels().get(id - 1);
            tmpLevel.getId().decrease(1);
            Utilities.saveLevelState(tmpLevel);
        }

        try {
            //  Delete level file
            Files.delete(
                    new File(
                            System.getProperty(Application.ROOT_PATH)
                                    + Application.LEVEL_PATH
                                    + "/"
                                    + new Integer(app.getLevelsScreen().getNumberLevels()).toString()
                                    + ".level"
                    ).toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        app.getEditLevelScreen().setLevel(null);
        app.getLevelsScreen().setUpLevelList();
    }
}