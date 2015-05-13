package application.Views.Screens.GameScreenPackage;

import application.Contracts.ImageContract;
import application.Contracts.SoundsContract;
import application.Models.Levels.*;
import application.Models.Value;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.*;
import application.Views.IModelUpdated;
import application.Views.Screens.NavigableScreen;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.util.Timer;

/**
 *
 */
public class GameScreen extends NavigableScreen implements IModelUpdated {
    //    Grid view bounds
    public static final Rectangle GRID_VIEW_BOUNDS = new Rectangle(192, NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT + 20, 640, 640);
    //    Score progress view bounds
    public static final Rectangle SCORE_PROGRESS_VIEW_BOUNDS = new Rectangle(50, NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT + 20, 126, 562);
    //    Score progress view size
    public static final Dimension SCORE_PROGRESS_VIEW_SIZE = new Dimension(126, 562);
    //    Refresh button round
    final int RESET_BUTTON_ROUND = 10;
    //    Reset button size
    final Dimension RESET_BUTTON_SIZE = new Dimension(78, 78);
    //    Reset button bounds
    final Rectangle RESET_BUTTON_BOUNDS = new Rectangle(98, Application.WINDOW_HEIGHT - 21 - 78, 78, 78);

    //    Background color of reset button
    final Color RESET_BUTTON_BACK_COLOR = new Color(112, 147, 113);
    //    Reset button actived background color
    final Color RESET_BUTTON__ACTIVE_COLOR = new Color(86, 116, 87);

    Level level;
    ScoreProgressView scoreProgressView;
    PopupBox popupBox;
    ImageButton refreshButton;
    GridView gridView;
    Timer timer;

    AudioClip winLevelSound;
    AudioClip tileDisappearSound;
    AudioClip removeTileSpecialMoveSound;
    AudioClip swapSquaresSpecialMoveSound;
    AudioClip resetBoardSpecialMoveSound;
    AudioClip restartLevelSpecialMoveSound;

    public GameScreen(String title, Application app) {

        super(title, app);
    }

    public void initialize() {

        setLayout(null);

        remove(getNavigationBar());

//        Setup score progress view
        add(getScoreProgressView());
        getScoreProgressView().setScore(level.getScore());
        getScoreProgressView().initialize();


//        Setup grid view
        getGridView().setBounds(GRID_VIEW_BOUNDS);
        add(getGridView());
        getGridView().initialize();

        getRefreshButton().setBounds(RESET_BUTTON_BOUNDS);

        add(getRefreshButton());

        getRefreshButton().repaint();

//        Sounds
        try {

            winLevelSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.WIN_LEVEL_SOUND).toURI().toURL()
            );

            tileDisappearSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.DROP_TILE_SOUND).toURI().toURL()
            );
            removeTileSpecialMoveSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.REMOVE_TILE_SPECIAL_MOVE_SOUND).toURI().toURL()
            );

            resetBoardSpecialMoveSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.RESET_BOARD_SPECIAL_MOVE_SOUND).toURI().toURL()
            );

            restartLevelSpecialMoveSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.RESTART_LEVEL_SOUND).toURI().toURL()
            );

            swapSquaresSpecialMoveSound = Applet.newAudioClip(
                    new File(System.getProperty(Application.ROOT_PATH)
                            + SoundsContract.SWAP_SQUARE_SPECIAL_MOVE_SOUND).toURI().toURL()
            );

            winLevelSound.play();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public GridView getGridView() {
        if (gridView == null) {
            gridView = new GridView(app, level);
        }

        return gridView;
    }

    public ImageButton getRefreshButton() {
        if (refreshButton == null) {
            refreshButton = new ImageButton(
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    ImageContract.RESET_BUTTON_IMAGE,
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON__ACTIVE_COLOR,
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON_BACK_COLOR,
                    RESET_BUTTON_ROUND

            );

            refreshButton.setPreferredSize(RESET_BUTTON_SIZE);
            refreshButton.setMaximumSize(RESET_BUTTON_SIZE);
            refreshButton.setMinimumSize(RESET_BUTTON_SIZE);
        }
        return refreshButton;
    }

    public ScoreProgressView getScoreProgressView() {
        if (scoreProgressView == null) {
            scoreProgressView = new ScoreProgressView();
            scoreProgressView.setBounds(SCORE_PROGRESS_VIEW_BOUNDS);
        }
        return scoreProgressView;
    }

    public Level getLevel() {
        return level;
    }

    public void updateScore(Value amount) {
        level.updateScore(amount);
        getScoreProgressView().modelChanged();
    }

    @Override
    public void modelChanged() {
        getScoreProgressView().modelChanged();
        getGridView().modelChanged();
    }

    public void levelCompleted() {


        if (level.hasWon()) {
            if (level instanceof LightningLevel) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
            }
            app.getGameScreen().getWinLevelSound().play();
            JOptionPane.showMessageDialog(app, "Level complete!");

            long levelID = level.getId().getValue();

            Utilities.updateLevelState(level);

//            Unlock next level
            if (levelID < app.getLevelsScreen().getNumberLevels()) {
                if (level.getScore().getStarNumber() >= 1) {
                    app.getLevelsScreen().getLevelFlipPagePanel().getLevelListPanel().unlockLevel(levelID + 1);
                }
            }

            //                Go to level screen
            app.switchTo(app.getLevelsScreen());
        }
    }

    public AudioClip getWinLevelSound() {
        return winLevelSound;
    }

    public AudioClip getRemoveTileSpecialMoveSound() {
        return removeTileSpecialMoveSound;
    }

    public AudioClip getTileDisappearSound() {
        return tileDisappearSound;
    }

    public AudioClip getResetBoardSpecialMoveSound() {
        return resetBoardSpecialMoveSound;
    }

    public AudioClip getRestartLevelSpecialMoveSound() {
        return restartLevelSpecialMoveSound;
    }

    public AudioClip getSwapSquaresSpecialMoveSound() {
        return swapSquaresSpecialMoveSound;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setLevel(Level level) {
        this.level = level;
        getGridView().setLevel(level);
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void suspend() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void resume() {
    }
}