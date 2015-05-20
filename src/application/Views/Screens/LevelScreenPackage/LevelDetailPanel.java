package application.Views.Screens.LevelScreenPackage;

import application.Contracts.ImageContract;
import application.Contracts.TextContact;
import application.Contracts.TipContract;
import application.Controllers.ViewLevelScreen.DeleteLevelButtonController;
import application.Controllers.ViewLevelScreen.EditLevelButtonController;
import application.Models.Levels.*;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.DetailPanel;
import application.Views.Components.ImageButton;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class LevelDetailPanel extends DetailPanel {


    //    Level name font size
    final float LEVEL_NAME_FONT_SIZE = 36L;

    //    Level name label bounds
    final Rectangle LEVEL_NAME_BOUNDS = new Rectangle(190, 42, 130, 50);

    //    Level type font size
    final float LEVEL_TYPE_FONT_SIZE = 24L;

    //    Level name label bounds
    final Rectangle LEVEL_TYPE_BOUNDS = new Rectangle(190, 72, 130, 50);

    //    Level introduction font size
    final float LEVEL_INTRO_FONT_SIZE = 18L;

    //    Level introduction label bounds
    final Rectangle LEVEL_INTRO_BOUNDS = new Rectangle(320, 20, 480, 100);

    //    Edit level button size
    final Dimension EDIT_LEVEL_BUTTON_SIZE = new Dimension(60, 60);

    //    Edit level button bounds
    final Rectangle EDIT_LEVEL_BUTTON_BOUNDS = new Rectangle(838, 48, 60, 60);

    //    Delete level button size
    final Dimension DELETE_LEVEL_BUTTON_SIZE = new Dimension(60, 60);

    //    Delete level button bounds
    final Rectangle DELETE_LEVEL_BUTTON_BOUNDS = new Rectangle(918, 48, 60, 60);

    final Color BUTTON_HOVERED_BACK_COLOR = new Color(86, 116, 87);

    final int NO_ROUND = 0;

    final Rectangle PREVIEW_GRID_VIEW_BOUNDS = new Rectangle(6, 6, 142, 142);


    JLabel levelNameLabel;

    JLabel levelTypeLabel;

    JLabel levelIntroLabel;

    ImageButton editLevelButton;

    ImageButton deleteLevelButton;

    Level level;

    PreviewGridView previewGridView;

    Application app;

    public LevelDetailPanel(Application app) {


        setLayout(null);
        setBackground(DETAIL_PANEL_BACK_COLOR);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_NAME_FONT_SIZE);
        //       Setup level name label
        levelNameLabel = new JLabel();
        levelNameLabel.setFont(Utilities.normalFont);
        levelNameLabel.setForeground(Color.WHITE);
        levelNameLabel.setOpaque(false);
        levelNameLabel.setBounds(LEVEL_NAME_BOUNDS);
        add(levelNameLabel);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_TYPE_FONT_SIZE);
        levelTypeLabel = new JLabel();
        levelTypeLabel.setFont(Utilities.normalFont);
        levelTypeLabel.setForeground(Color.WHITE);
        levelTypeLabel.setOpaque(false);
        levelTypeLabel.setBounds(LEVEL_TYPE_BOUNDS);
        add(levelTypeLabel);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_INTRO_FONT_SIZE);
        //        Setup level intro label
        levelIntroLabel = new JLabel();
        levelIntroLabel.setFont(Utilities.normalFont);
        levelIntroLabel.setForeground(Color.WHITE);
        levelIntroLabel.setOpaque(false);
        levelIntroLabel.setBounds(LEVEL_INTRO_BOUNDS);
        add(levelIntroLabel);

        getPreviewGridView().setBounds(PREVIEW_GRID_VIEW_BOUNDS);
        add(getPreviewGridView());

//        Setup delete new level button
        add(getDeleteLevelButton());
        getDeleteLevelButton().setToolTipText(TipContract.DELETE_LEVEL_BUTTON_TIP);

        getDeleteLevelButton().repaint();

        DeleteLevelButtonController deleteLevelButtonController = new DeleteLevelButtonController(getDeleteLevelButton(), this, app);

        getDeleteLevelButton().addMouseListener(deleteLevelButtonController);
        getDeleteLevelButton().addMouseMotionListener(deleteLevelButtonController);

//        Setup edit new level button
        add(getEditLevelButton());
        getEditLevelButton().setToolTipText(TipContract.EDIT_LEVEL_BUTTON_TIP);

        getEditLevelButton().repaint();

        EditLevelButtonController editLevelButtonController = new EditLevelButtonController(getEditLevelButton(), this, app);

        getEditLevelButton().addMouseListener(editLevelButtonController);
        getEditLevelButton().addMouseMotionListener(editLevelButtonController);

    }

    public void setLevel(Level level) {

        this.level = level;
        //        Setup level type label

        levelNameLabel.setText(TextContact.LEVEL + " " + level.getId().toString());

        String levelType = null;
        String levelIntro = null;

        if (level instanceof PuzzleLevel) {

            levelType = TextContact.LEVEL_TYPE_PUZZLE;
            levelIntro = TextContact.LEVEL_INTRO_PUZZLE;

        } else if (level instanceof LightningLevel) {

            levelType = TextContact.LEVEL_TYPE_LIGHTNING;
            levelIntro = TextContact.LEVEL_INTRO_LIGHTNING;

        } else if (level instanceof EliminationLevel) {

            levelType = TextContact.LEVEL_TYPE_ELIMINATION;
            levelIntro = TextContact.LEVEL_INTRO_ELIMINATION;

        } else if (level instanceof ReleaseLevel) {

            levelType = TextContact.LEVEL_TYPE_RELEASE;
            levelIntro = TextContact.LEVEL_INTRO_RELEASE;
        }

        levelTypeLabel.setText(levelType);
        levelIntroLabel.setText(levelIntro);

        getPreviewGridView().initialize(level);
        getPreviewGridView().modelChanged();
    }

    public PreviewGridView getPreviewGridView() {
        if (previewGridView == null) {
            previewGridView = new PreviewGridView(app);
        }

        return previewGridView;
    }

    public Level getLevel() {
        return level;
    }

    public ImageButton getEditLevelButton() {
        if (editLevelButton == null) {
            editLevelButton = new ImageButton(
                    ImageContract.EDIT_LEVEL_BUTTON_IMAGE,
                    ImageContract.EDIT_LEVEL_BUTTON_IMAGE,
                    ImageContract.EDIT_LEVEL_BUTTON_IMAGE,
                    ImageContract.EDIT_LEVEL_BUTTON_IMAGE,
                    DETAIL_PANEL_BACK_COLOR,
                    BUTTON_HOVERED_BACK_COLOR,
                    DETAIL_PANEL_BACK_COLOR,
                    DETAIL_PANEL_BACK_COLOR,
                    NO_ROUND
            );

            editLevelButton.setPreferredSize(EDIT_LEVEL_BUTTON_SIZE);
            editLevelButton.setMinimumSize(EDIT_LEVEL_BUTTON_SIZE);
            editLevelButton.setMaximumSize(EDIT_LEVEL_BUTTON_SIZE);

            editLevelButton.setBounds(EDIT_LEVEL_BUTTON_BOUNDS);
        }
        return editLevelButton;
    }

    public ImageButton getDeleteLevelButton() {

        if (deleteLevelButton == null) {
            deleteLevelButton = new ImageButton(
                    ImageContract.DELETE_LEVEL_BUTTON_IMAGE,
                    ImageContract.DELETE_LEVEL_BUTTON_IMAGE,
                    ImageContract.DELETE_LEVEL_BUTTON_IMAGE,
                    ImageContract.DELETE_LEVEL_BUTTON_IMAGE,
                    DETAIL_PANEL_BACK_COLOR,
                    BUTTON_HOVERED_BACK_COLOR,
                    DETAIL_PANEL_BACK_COLOR,
                    DETAIL_PANEL_BACK_COLOR,
                    NO_ROUND
            );

            deleteLevelButton.setPreferredSize(DELETE_LEVEL_BUTTON_SIZE);
            deleteLevelButton.setMinimumSize(DELETE_LEVEL_BUTTON_SIZE);
            deleteLevelButton.setMaximumSize(DELETE_LEVEL_BUTTON_SIZE);

            deleteLevelButton.setBounds(DELETE_LEVEL_BUTTON_BOUNDS);
        }

        return deleteLevelButton;
    }
}