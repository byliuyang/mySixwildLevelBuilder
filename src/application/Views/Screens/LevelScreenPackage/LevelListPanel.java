package application.Views.Screens.LevelScreenPackage;

import application.Models.Levels.Level;
import application.Views.Components.ListPanel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class LevelListPanel extends ListPanel {

    ArrayList<Level> levels;

    public LevelListPanel(ArrayList<Level> levels, LevelDetailPanel levelDetailPanel) {
        super(levelDetailPanel);
        this.levels = levels;

        setPreferredSize(LIST_PANEL_SIZE);
        setUpViews();
        showViews();

        activeFirstLevel();
    }

    public void activeFirstLevel() {
        setActiveView(getViews().get(0));
        getViews().get(0).getButton().actived();
        ((LevelDetailPanel) getDetailPanel()).setLevel(levels.get(0));
    }

    @Override
    public void setUpViews() {

        getViews().clear();

        for (Iterator<Level> levelIterator = levels.iterator(); levelIterator.hasNext(); ) {

            Level level = levelIterator.next();

            try {

                LevelView levelView = new LevelView(level, this, (LevelDetailPanel) getDetailPanel());

                levelView.setPreferredSize(ListPanel.VIEW_SIZE);
                levelView.setMinimumSize(ListPanel.VIEW_SIZE);
                levelView.setMaximumSize(ListPanel.VIEW_SIZE);

                levelView.getLevelButton().unlock();

                levelView.getLevelButton().repaint();

                getViews().add(levelView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }
}