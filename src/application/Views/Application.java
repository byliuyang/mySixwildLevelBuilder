package application.Views;

import application.Contracts.TextContact;
import application.Models.*;
import application.Models.Levels.EliminationLevel;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Models.Levels.ReleaseLevel;
import application.Utilities;
import application.Views.Animation.AnimationManager;
import application.Views.Screens.GameScreenPackage.GameScreen;
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
    GameScreen gameScreen;
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

            if (currentScreen instanceof GameScreen) {
                ((GameScreen) currentScreen).suspend();
            }

            getGraphics().clearRect(0, 0, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            screen.setVisible(true);
            currentScreen.setVisible(false);
            currentScreen = screen;
            repaint();
        }
    }

//    Getters

    public GameScreen getGameScreen() {
        if (gameScreen == null) {
            gameScreen = new GameScreen(TextContact.APPLICATION_TITLE, this);

            getGameScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(gameScreen);
            getGameScreen().setVisible(false);
        }

        return gameScreen;
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

    PuzzleLevel generateDummyPuzzleLevel() {
        boolean unlockState = true;
        Value id = new Value(1);
        Score score = new Score(
                new Value(200),
                new Value(500),
                new Value(1000)
        );

        score.setCurrentScore(700);

        Probabilities probabilities = new Probabilities(
                new Value(20),
                new Value(40),
                new Value(60),
                new Value(80),
                new Value(90),
                new Value(100),
                new Value(60),
                new Value(80),
                new Value(100)
        );


        Grid grid = new Grid(probabilities);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Location location = new Location(new Value(row), new Value(column));
                Square square = new Square(location, null);

                grid.addSquare(square);
            }
        }

        grid.removeSquare(0, 0);
        grid.removeSquare(5, 7);
        grid.removeSquare(8, 4);
        grid.removeSquare(8, 3);

        grid.generateTiles();

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(5),
                new Value(20),
                new Value(7)
        );

        Value swapNeighborMoveLeft = new Value(20);

        PuzzleLevel puzzleLevel = new PuzzleLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities,
                swapNeighborMoveLeft
        );

        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH + "/1.level")
            );

            objectOutputStream.writeObject(puzzleLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return puzzleLevel;
    }

    LightningLevel generateDummyLightningLevel() {
        boolean unlockState = false;
        Value id = new Value(2);
        Score score = new Score(
                new Value(200),
                new Value(500),
                new Value(1000)
        );

        Probabilities probabilities = new Probabilities(
                new Value(20),
                new Value(40),
                new Value(60),
                new Value(80),
                new Value(90),
                new Value(100),
                new Value(60),
                new Value(80),
                new Value(100)
        );


        Grid grid = new Grid(probabilities);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Location location = new Location(new Value(row), new Value(column));
                Square square = new Square(location, null);

                grid.addSquare(square);
            }
        }

        grid.removeSquare(0, 0);
        grid.removeSquare(5, 7);
        grid.removeSquare(8, 4);
        grid.removeSquare(8, 3);
        grid.removeSquare(6, 2);
        grid.removeSquare(6, 1);
        grid.removeSquare(6, 0);

        grid.generateTiles();

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(5),
                new Value(20),
                new Value(7)
        );

        Time time = new Time(60);

        LightningLevel lightningLevel = new LightningLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities,
                time
        );

        try {


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH + "/2.level")
            );

            objectOutputStream.writeObject(lightningLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lightningLevel;
    }

    EliminationLevel generateDummyEliminationLevel() {
        boolean unlockState = false;
        Value id = new Value(3);
        Score score = new Score(
                new Value(2000),
                new Value(7000),
                new Value(10000)
        );

        Probabilities probabilities = new Probabilities(
                new Value(20),
                new Value(40),
                new Value(60),
                new Value(80),
                new Value(90),
                new Value(100),
                new Value(60),
                new Value(80),
                new Value(100)
        );


        Grid grid = new Grid(probabilities);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Location location = new Location(new Value(row), new Value(column));
                Square square = new Square(location, null);

                grid.addSquare(square);
            }
        }

        grid.removeSquare(0, 0);
        grid.removeSquare(5, 7);
        grid.removeSquare(8, 4);
        grid.removeSquare(8, 3);

        grid.generateTiles();

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(5),
                new Value(20),
                new Value(7)
        );

        EliminationLevel eliminationLevel = new EliminationLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities
        );

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH + "/3.level")
            );

            objectOutputStream.writeObject(eliminationLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eliminationLevel;
    }

    ReleaseLevel generateDummyReleaseLevel() {
        boolean unlockState = false;
        Value id = new Value(4);
        Score score = new Score(
                new Value(2000),
                new Value(7000),
                new Value(10000)
        );

        Probabilities probabilities = new Probabilities(
                new Value(20),
                new Value(40),
                new Value(60),
                new Value(80),
                new Value(90),
                new Value(100),
                new Value(60),
                new Value(80),
                new Value(100)
        );


        Grid grid = new Grid(probabilities);

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Location location = new Location(new Value(row), new Value(column));
                Square square = new Square(location, null);
                grid.addSquare(square);
            }
        }

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(5),
                new Value(20),
                new Value(7)
        );

        ReleaseLevel releaseLevel = new ReleaseLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities
        );

        grid.removeSquare(0, 0);
        grid.removeSquare(5, 7);
        grid.removeSquare(8, 4);
        grid.removeSquare(8, 3);

        releaseLevel.addContainer(3, 4);
        releaseLevel.addContainer(2, 7);
        releaseLevel.addContainer(1, 4);
        releaseLevel.addContainer(7, 3);
        grid.generateTiles();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH + "/4.level")
            );

            objectOutputStream.writeObject(releaseLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return releaseLevel;
    }
}