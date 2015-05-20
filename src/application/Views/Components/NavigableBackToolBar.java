package application.Views.Components;

import application.Contracts.ImageContract;
import application.Contracts.TipContract;
import application.Controllers.NavigationBar.GoBackButtonController;
import application.Views.Application;

import java.awt.*;

/**
 *
 */
public class NavigableBackToolBar extends NavigationBar {

    //    Button background color
    final Color BUTTON_BACK_COLOR = new Color(112, 147, 113);
    //    Button active background back color
    final Color BUTTON_ACTIVE_COLOR = new Color(103, 137, 104);
    //    Back button dimension
    final Dimension BACK_BUTTON_SIZE = new Dimension(58, 58);
    //    Back button bounds
    final Rectangle BACK_BUTTON_BOUNDS = new Rectangle(0, 0, 58, 58);

    public NavigableBackToolBar(Application app) {
        super(app);
    }

    public void setBackButton(){
        backButton = new ImageButton(
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                BUTTON_BACK_COLOR,
                BUTTON_ACTIVE_COLOR,
                BUTTON_BACK_COLOR,
                BUTTON_BACK_COLOR,
                NO_ROUND);

        backButton.setPreferredSize(BACK_BUTTON_SIZE);
        backButton.setMaximumSize(BACK_BUTTON_SIZE);
        backButton.setMinimumSize(BACK_BUTTON_SIZE);

        backButton.setBounds(BACK_BUTTON_BOUNDS);
        backButton.setToolTipText(TipContract.BACK_TO_LEVELS_BUTTON_TIP);
        backButton.addMouseListener(new GoBackButtonController(backButton, app));


        add(backButton);

        backButton.repaint();
    }

}