package application.Views.Components;

import application.Views.Application;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class NavigationBar extends JPanel {

    //    No round
    public static final int NO_ROUND = 0;

    final Color Nav_BAR_COLOR = new Color(112, 147, 113);
    //    Navigation bar title label font size
    final float TITLE_FONT_SIZE = 30L;
    //    Title label bounds
    final Rectangle NAV_LABEL_BOUNDS = new Rectangle(20, 0, 280, 58);
    //    Back button dimension
    final Dimension NAV_LABEL_SIZE = new Dimension(280, 58);
    //    Navigation bar title label alignment
    final boolean NAV_LABEL_LEFT_ALIGN = true;
    //    Back button
    ImageButton backButton;
    //    Application reference
    Application app;

    //    Navigation bar title label
    StyledLabel navTitleLabel;

    public NavigationBar(Application app) {
        this.app = app;
        initialize();
    }

    private void initialize() {
        setBackground(Nav_BAR_COLOR);
        setLayout(null);
    }

    public void setNavTitle(String navTitle) {

        if (navTitleLabel == null) {
            navTitleLabel = new StyledLabel(navTitle, TITLE_FONT_SIZE, Color.WHITE, NAV_LABEL_LEFT_ALIGN);

            navTitleLabel.setPreferredSize(NAV_LABEL_SIZE);
            navTitleLabel.setMaximumSize(NAV_LABEL_SIZE);
            navTitleLabel.setMinimumSize(NAV_LABEL_SIZE);

            navTitleLabel.setBounds(NAV_LABEL_BOUNDS);
            add(navTitleLabel);

            navTitleLabel.repaint();

        } else {
            navTitleLabel.setText(navTitle);
            navTitleLabel.repaint();
        }
    }
}