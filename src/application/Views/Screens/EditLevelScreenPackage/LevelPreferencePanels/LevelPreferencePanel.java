package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelPreferencePanel extends JPanel implements IModelUpdated{

    //    Border color
    public static final Color BORDER_COLOR_BRIGHT = new Color(235, 235, 235);

    //    Panel title font size
    public static float PANEL_TITLE_FONT_SIZE = 18;
    //    Panel foreground color
    public static Color PANEL_FOREGROUND_COLOR = new Color(92, 92, 92);

    //    Level basics panel size and bounds
    final Dimension LEVEL_BASICS_PANEL_SIZE = new Dimension(328, 186);
    final Rectangle LEVEL_BASICS_PANEL_BOUNDS = new Rectangle(0, 0, 328, 186);

    //    Level special moves panel size and bounds
    final Dimension LEVEL_SPECIAL_MOVES_PANEL_SIZE = new Dimension(328, 218);
    final Rectangle LEVEL_SPECIAL_MOVES_PANEL_BOUNDS = new Rectangle(0, 186, 328, 218);

    //    Level star milestones panel size and bounds
    final Dimension LEVEL_STAR_MILESTONE_PANEL_SIZE = new Dimension(328, 174);
    final Rectangle LEVEL_STAR_MILESTONE_PANEL_BOUNDS = new Rectangle(0, 404, 328, 174);

    //    Level tile probabilities panel size and bounds
    final Dimension LEVEL_TILE_PROBABILITIES_PANEL_SIZE = new Dimension(328, 286);
    final Rectangle LEVEL_TILE_PROBABILITIES_PANEL_BOUNDS = new Rectangle(0, 578, 328, 286);

    //    Level multiplier probabilities panel size and bounds
    final Dimension LEVEL_MULTIPLIER_PROBABILITIES_PANEL_SIZE = new Dimension(328, 180);
    final Rectangle LEVEL_MULTIPLIER_PROBABILITIES_PANEL_BOUNDS = new Rectangle(0, 864, 328, 180);

    //    Level select grid elements panel size and bounds
    final Dimension LEVEL_SELECT_GRID_ELEMENTS_PANEL_SIZE = new Dimension(328, 310);
    final Rectangle LEVEL_SELECT_GRID_ELEMENTS_PANEL_BOUNDS = new Rectangle(0, 1044, 328, 310);

    //    Level select multiplier panel size and bounds
    final Dimension LEVEL_SELECT_MULTIPLIER_PANEL_SIZE = new Dimension(328, 180);
    final Rectangle LEVEL_SELECT_MULTIPLIER_PANEL_BOUNDS = new Rectangle(0, 1354,328 , 180);

    EditLevelScreen editLevelScreen;

    LevelBasicsPanel levelBasicsPanel;
    LevelSpecialMovePanel levelSpecialMovePanel;
    StarMilestonePanel starMilestonePanel;
    MultiplierProbabilityPanel multiplierProbabilityPanel;
    TileProbabilityPanel tileProbabilityPanel;

    SelectGridElementsPanel selectSelectGridElementsPanel;
    SelectMultiplierPanel selectSelectMultiplierPanel;

    public LevelPreferencePanel(EditLevelScreen editLevelScreen) {

        this.editLevelScreen = editLevelScreen;

        setLayout(null);

        setBackground(Color.WHITE);

//        Add control panels into preferences panel
        add(getLevelBasicsPanel());
        add(getLevelSpecialMovePanel());
        add(getStarMilestonePanel());
        add(getTileProbabilityPanel());
        add(getMultiplierProbabilityPanel());
        add(getSelectSelectGridElementsPanel());
        add(getSelectSelectMultiplierPanel());

    }

    public LevelBasicsPanel getLevelBasicsPanel() {

        if (levelBasicsPanel == null) {
            levelBasicsPanel = new LevelBasicsPanel(editLevelScreen);

            levelBasicsPanel.setPreferredSize(LEVEL_BASICS_PANEL_SIZE);
            levelBasicsPanel.setMaximumSize(LEVEL_BASICS_PANEL_SIZE);
            levelBasicsPanel.setMinimumSize(LEVEL_BASICS_PANEL_SIZE);

            levelBasicsPanel.setBounds(LEVEL_BASICS_PANEL_BOUNDS);
        }

        return levelBasicsPanel;
    }

    public LevelSpecialMovePanel getLevelSpecialMovePanel() {
        if (levelSpecialMovePanel == null) {
            levelSpecialMovePanel = new LevelSpecialMovePanel(editLevelScreen);

            levelSpecialMovePanel.setPreferredSize(LEVEL_SPECIAL_MOVES_PANEL_SIZE);
            levelSpecialMovePanel.setMaximumSize(LEVEL_SPECIAL_MOVES_PANEL_SIZE);
            levelSpecialMovePanel.setMinimumSize(LEVEL_SPECIAL_MOVES_PANEL_SIZE);

            levelSpecialMovePanel.setBounds(LEVEL_SPECIAL_MOVES_PANEL_BOUNDS);
        }

        return levelSpecialMovePanel;
    }

    public StarMilestonePanel getStarMilestonePanel() {

        if (starMilestonePanel == null) {
            starMilestonePanel = new StarMilestonePanel(editLevelScreen);

            starMilestonePanel.setPreferredSize(LEVEL_STAR_MILESTONE_PANEL_SIZE);
            starMilestonePanel.setMaximumSize(LEVEL_STAR_MILESTONE_PANEL_SIZE);
            starMilestonePanel.setMinimumSize(LEVEL_STAR_MILESTONE_PANEL_SIZE);

            starMilestonePanel.setBounds(LEVEL_STAR_MILESTONE_PANEL_BOUNDS);
        }

        return starMilestonePanel;
    }

    public TileProbabilityPanel getTileProbabilityPanel() {

        if (tileProbabilityPanel == null) {
            tileProbabilityPanel = new TileProbabilityPanel(editLevelScreen);

            tileProbabilityPanel.setPreferredSize(LEVEL_TILE_PROBABILITIES_PANEL_SIZE);
            tileProbabilityPanel.setMaximumSize(LEVEL_TILE_PROBABILITIES_PANEL_SIZE);
            tileProbabilityPanel.setMinimumSize(LEVEL_TILE_PROBABILITIES_PANEL_SIZE);

            tileProbabilityPanel.setBounds(LEVEL_TILE_PROBABILITIES_PANEL_BOUNDS);
        }

        return tileProbabilityPanel;
    }

    public MultiplierProbabilityPanel getMultiplierProbabilityPanel() {

        if (multiplierProbabilityPanel == null) {
            multiplierProbabilityPanel = new MultiplierProbabilityPanel(editLevelScreen);

            multiplierProbabilityPanel.setPreferredSize(LEVEL_MULTIPLIER_PROBABILITIES_PANEL_SIZE);
            multiplierProbabilityPanel.setMaximumSize(LEVEL_MULTIPLIER_PROBABILITIES_PANEL_SIZE);
            multiplierProbabilityPanel.setMinimumSize(LEVEL_MULTIPLIER_PROBABILITIES_PANEL_SIZE);

            multiplierProbabilityPanel.setBounds(LEVEL_MULTIPLIER_PROBABILITIES_PANEL_BOUNDS);
        }

        return multiplierProbabilityPanel;
    }

    public SelectGridElementsPanel getSelectSelectGridElementsPanel() {

        if (selectSelectGridElementsPanel == null) {
            selectSelectGridElementsPanel = new SelectGridElementsPanel(editLevelScreen);

            selectSelectGridElementsPanel.setPreferredSize(LEVEL_SELECT_GRID_ELEMENTS_PANEL_SIZE);
            selectSelectGridElementsPanel.setMaximumSize(LEVEL_SELECT_GRID_ELEMENTS_PANEL_SIZE);
            selectSelectGridElementsPanel.setMinimumSize(LEVEL_SELECT_GRID_ELEMENTS_PANEL_SIZE);

            selectSelectGridElementsPanel.setBounds(LEVEL_SELECT_GRID_ELEMENTS_PANEL_BOUNDS);
        }

        return selectSelectGridElementsPanel;
    }

    public SelectMultiplierPanel getSelectSelectMultiplierPanel() {

        if (selectSelectMultiplierPanel == null) {
            selectSelectMultiplierPanel = new SelectMultiplierPanel(editLevelScreen);

            selectSelectMultiplierPanel.setPreferredSize(LEVEL_SELECT_MULTIPLIER_PANEL_SIZE);
            selectSelectMultiplierPanel.setMaximumSize(LEVEL_SELECT_MULTIPLIER_PANEL_SIZE);
            selectSelectMultiplierPanel.setMinimumSize(LEVEL_SELECT_MULTIPLIER_PANEL_SIZE);

            selectSelectMultiplierPanel.setBounds(LEVEL_SELECT_MULTIPLIER_PANEL_BOUNDS);
        }

        return selectSelectMultiplierPanel;
    }

    @Override
    public void modelChanged() {
        getLevelBasicsPanel().modelChanged();
        getLevelSpecialMovePanel().modelChanged();
        getStarMilestonePanel().modelChanged();
        getTileProbabilityPanel().modelChanged();
        getMultiplierProbabilityPanel().modelChanged();
        getSelectSelectGridElementsPanel().modelChanged();
    }
}
