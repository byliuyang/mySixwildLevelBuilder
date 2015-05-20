package application.Views.Screens.EditLevelScreenPackage;

import application.Contracts.LevelTypeContract;
import application.Models.Levels.Level;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.EditLevelToolBar;
import application.Views.Components.StyledButton;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels.LevelPreferencePanel;
import application.Views.Screens.NavigableScreen;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class EditLevelScreen extends NavigableScreen implements IModelUpdated {

    //    Preferences panel size
    public static final Dimension PREFERENCE_PANEL_SIZE = new Dimension(
            325,
            1460
    );

    //    Preference panel bounds
    public static final Rectangle PREFERENCE_PANEL_BOUNDS = new Rectangle(
            0,
            0,
            325,
            1460
    );

    public static final Rectangle PREFERENCE_SCROLL_PANE_BOUNDS = new Rectangle(
            0,
            0,
            345,
            Application.WINDOW_HEIGHT - NAV_BAR_HEIGHT - STATUS_BAR_HEIGHT
    );

    //    Grid view bounds
    public static final Rectangle GRID_VIEW_BOUNDS = new Rectangle(364, 20, 640, 640);

    public static final Rectangle LAYER_PANE_BOUNDS = new Rectangle(
            0,
            NAV_BAR_HEIGHT + STATUS_BAR_HEIGHT,
            Application.WINDOW_WIDTH,
            Application.WINDOW_HEIGHT - NAV_BAR_HEIGHT - STATUS_BAR_HEIGHT
    );


    public static final Color BORDER_COLOR_DARK = new Color(229, 229, 229);


    Level level;
    GridView gridView;

    LevelPreferencePanel levelPreferencePanel;

    StyledButton activeView;

    JLayeredPane layeredPane;

    int levelId;

    public EditLevelScreen(String title, Application app) {

        super(title, app);
    }

    public void initialize() {

        getLevel();

        remove(getNavigationBar());

        if (layeredPane != null) {
            remove(layeredPane);
            levelPreferencePanel = null;
        }

        layeredPane = new JLayeredPane();

        activeView = null;

        add(getEditLevelToolBar());

        getEditLevelToolBar().repaint();

        getLevelPreferencePanel();

        //        Puzzle is default level
        modelChanged();

        getGridView().setBounds(GRID_VIEW_BOUNDS);

        layeredPane.add(getGridView(), Utilities.BOTTOM_LAYER);
        layeredPane.setBounds(LAYER_PANE_BOUNDS);
        add(layeredPane);

        getGridView().initialize(this);
        getGridView().modelChanged();
    }

    public GridView getGridView() {
        if (gridView == null) {
            gridView = new GridView(app, level);
        }

        return gridView;
    }

    public Level getLevel() {

        if (level == null) {
            level = LevelTypeContract.generateDefaultPuzzleLevel(levelId);
        }

        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
        getGridView().setLevel(level);
    }

    public EditLevelToolBar getEditLevelToolBar() {
        if (!(getNavigationBar() instanceof EditLevelToolBar)) {

            EditLevelToolBar editLevelToolBar = new EditLevelToolBar(app);
            editLevelToolBar.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, NAV_BAR_HEIGHT));
            editLevelToolBar.setMinimumSize(new Dimension(Application.WINDOW_WIDTH, NAV_BAR_HEIGHT));
            editLevelToolBar.setMaximumSize(new Dimension(Application.WINDOW_WIDTH, NAV_BAR_HEIGHT));

            editLevelToolBar.setBounds(NAV_BAR_BOUNDS);

            setNavigationBar(editLevelToolBar);
        }

        return (EditLevelToolBar) getNavigationBar();
    }

    public LevelPreferencePanel getLevelPreferencePanel() {

        if (levelPreferencePanel == null) {
            levelPreferencePanel = new LevelPreferencePanel(this);

            levelPreferencePanel.setPreferredSize(PREFERENCE_PANEL_SIZE);
            levelPreferencePanel.setMinimumSize(PREFERENCE_PANEL_SIZE);
            levelPreferencePanel.setMaximumSize(PREFERENCE_PANEL_SIZE);

            levelPreferencePanel.setBounds(PREFERENCE_PANEL_BOUNDS);

            JScrollPane scrollPane = new JScrollPane(levelPreferencePanel);
            scrollPane.setBounds(PREFERENCE_SCROLL_PANE_BOUNDS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COLOR_DARK));

            layeredPane.add(scrollPane, Utilities.BOTTOM_LAYER);
        }

        return levelPreferencePanel;
    }

    @Override
    public void modelChanged() {
        getLevelPreferencePanel().modelChanged();
        getGridView().modelChanged();
    }

    public StyledButton getActiveView() {
        return activeView;
    }

    public void setActiveView(StyledButton activeView) {
        this.activeView = activeView;
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}