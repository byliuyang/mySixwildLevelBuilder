package application.Views;

import application.Contracts.TextContact;
import application.Models.*;
import application.Models.Levels.EliminationLevel;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Models.Levels.ReleaseLevel;
import application.Utilities;
import application.Views.Animation.AnimationManager;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.LevelScreenPackage.LevelsScreen;
import application.Views.Screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 */
public class Application extends JFrame {

    //    Application name
    public static final String APP_NAME = "application";

    //    window width
    public static final int WINDOW_WIDTH = 1024;
    //    windows height
    public static final int WINDOW_HEIGHT = 768;

    //    Root path of application
    public static final String ROOT_PATH = "user.dir";

    public static final String LEVEL_PATH = "/levels";

    //    Font locations of regular, italic and bold.
    public static final String REGULAR_FONT_LOCATION = "/assets/AvenirNextRegular.ttf";
    public static final String ITALIC_FONT_LOCATION = "/assets/AvenirNextIt.ttf";
    public static final String BOLD_FONT_LOCATION = "/assets/AvenirNextBold.ttf";

    //    Application running state. 0 when execution when fine.
    public static final int EXECUTION_FINE = 0;

    //    Default Screen paddings
    final int DEFAULT_SCREEN_PADDING_LEFT = 0;
    final int DEFAULT_SCREEN_PADDING_TOP = 0;

    //    Screens
    EditLevelScreen editLevelScreen;
    LevelsScreen levelsScreen;

    JLayeredPane layeredPane;

    //    Current screen
    Screen currentScreen;

    //    Animation manager
    AnimationManager animationManager;

    public Application() {
        super(Application.APP_NAME);
        Utilities.loadFont();

        this.setSize(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        this.setContentPane(layeredPane);

        this.setLayout(null);

        getLevelsScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.add(levelsScreen);

        currentScreen = levelsScreen;
    }

    public void switchTo(Screen screen) {
        if (currentScreen != null && screen != null) {

            getGraphics().clearRect(0, 0, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            screen.setVisible(true);
            currentScreen.setVisible(false);
            currentScreen = screen;
            repaint();
        }
    }

//    Getters

    public EditLevelScreen getEditLevelScreen() {
        if (editLevelScreen == null) {
            editLevelScreen = new EditLevelScreen(TextContact.APPLICATION_TITLE, this);

            getEditLevelScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            getEditLevelScreen().setVisible(false);

            add(editLevelScreen);
        }

        return editLevelScreen;
    }

    public LevelsScreen getLevelsScreen() {
        if (levelsScreen == null) {
            levelsScreen = new LevelsScreen(TextContact.APPLICATION_TITLE, this, TextContact.LEVELS_SCREEN_TITLE);

            getLevelsScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            getLevelsScreen().setVisible(true);
        }

        return levelsScreen;
    }

    public AnimationManager getAnimationManager() {
        if (animationManager == null) {
            animationManager = new AnimationManager();
        }

        return animationManager;
    }
}