package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelPreferencePanel extends JPanel {

    //    Border color
    final Color BORDER_COLOR = new Color(229, 229, 229);

    //    Panel title font size
    public static float PANEL_TITLE_FONT_SIZE = 18;
    //    Panel foreground color
    public static Color PANEL_FOREGROUND_COLOR = new Color(128, 128, 128);

    LevelBasicsPanel levelBasicsPanel;
    GridElementsPanel gridElementsPanel;
    MultiplierPanel multiplierPanel;

    public LevelPreferencePanel() {

        setBackground(Color.WHITE);

        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COLOR));
    }

    public LevelBasicsPanel getLevelBasicsPanel() {
        return levelBasicsPanel;
    }

    public GridElementsPanel getGridElementsPanel() {
        return gridElementsPanel;
    }

    public MultiplierPanel getMultiplierPanel() {
        return multiplierPanel;
    }
}
