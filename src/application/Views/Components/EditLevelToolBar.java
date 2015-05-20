package application.Views.Components;

import application.Contracts.ImageContract;
import application.Contracts.TextContact;
import application.Contracts.TipContract;
import application.Controllers.NavigationBar.GoBackButtonController;
import application.Controllers.ViewLevelScreen.FinishEditingLevelController;
import application.Utilities;
import application.Views.Application;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class EditLevelToolBar extends NavigableBackToolBar {

    //    Level label dimension
    final Dimension LEVEL_LABEL_SIZE = new Dimension(300, 58);
    //    Level label bounds
    final Rectangle LEVEL_LABEL_BOUNDS = new Rectangle(704, 0, 300, 58);

    //    Reset level button dimension
    final Dimension RESET_LEVEL_BUTTON_SIZE = new Dimension(42, 42);
    //    Reset level button bounds
    final Rectangle RESET_LEVEL_BUTTON_BOUNDS = new Rectangle(2 * 58 + 6, 8, 58, 58);

    final int HALF_ROUND = 42;

    //    Finish editing button dimension
    final Dimension FINISH_EDITING_BUTTON_SIZE = new Dimension(42, 42);
    //    Finish editing button bounds
    final Rectangle FINISH_EDITING_BUTTON_BOUNDS = new Rectangle(66, 8, 58, 58);
    //    Current level label font size
    final float CURRENT_LEVEL_LABEL_FONT_SIZE = 22L;

    ImageButton finishEditingButton;
    ImageButton resetLevelButton;
    JLabel currentLevelLabel;

    public EditLevelToolBar(Application app) {
        super(app);
        setBackButton();

        setFinishEditingButton();
        setResetLevelButton();

        getCurrentLevelLabel();
    }

    public void setFinishEditingButton() {
        finishEditingButton = new ImageButton(
                ImageContract.FINISH_EDITING_BUTTON_IMAGE,
                ImageContract.FINISH_EDITING_BUTTON_IMAGE,
                ImageContract.FINISH_EDITING_BUTTON_IMAGE,
                ImageContract.FINISH_EDITING_BUTTON_IMAGE,
                BUTTON_BACK_COLOR,
                BUTTON_ACTIVE_COLOR,
                BUTTON_BACK_COLOR,
                BUTTON_BACK_COLOR,
                HALF_ROUND
        );

        finishEditingButton.setPreferredSize(FINISH_EDITING_BUTTON_SIZE);
        finishEditingButton.setMaximumSize(FINISH_EDITING_BUTTON_SIZE);
        finishEditingButton.setMinimumSize(FINISH_EDITING_BUTTON_SIZE);

        finishEditingButton.setBounds(FINISH_EDITING_BUTTON_BOUNDS);
        finishEditingButton.setToolTipText(TipContract.FINISH_EDITING_BUTTON_TIP);
        finishEditingButton.addMouseListener(new FinishEditingLevelController(finishEditingButton, app));


        add(finishEditingButton);

        finishEditingButton.repaint();
    }

    public void setResetLevelButton() {
        resetLevelButton = new ImageButton(
                ImageContract.RESET_LEVEL_BUTTON_IMAGE,
                ImageContract.RESET_LEVEL_BUTTON_IMAGE,
                ImageContract.RESET_LEVEL_BUTTON_IMAGE,
                ImageContract.RESET_LEVEL_BUTTON_IMAGE,
                BUTTON_BACK_COLOR,
                BUTTON_ACTIVE_COLOR,
                BUTTON_BACK_COLOR,
                BUTTON_BACK_COLOR,
                HALF_ROUND
        );

        resetLevelButton.setPreferredSize(RESET_LEVEL_BUTTON_SIZE);
        resetLevelButton.setMaximumSize(RESET_LEVEL_BUTTON_SIZE);
        resetLevelButton.setMinimumSize(RESET_LEVEL_BUTTON_SIZE);

        resetLevelButton.setBounds(RESET_LEVEL_BUTTON_BOUNDS);
        resetLevelButton.setToolTipText(TipContract.RESET_LEVEL_BUTTON_TIP);
        resetLevelButton.addMouseListener(new GoBackButtonController(resetLevelButton, app));


        add(resetLevelButton);

        resetLevelButton.repaint();
    }

    public JLabel getCurrentLevelLabel() {
        if (currentLevelLabel == null) {

            currentLevelLabel = new JLabel(TextContact.LEVEL + " " + app.getEditLevelScreen().getLevel().getId().toString());

            Utilities.normalFont = Utilities.normalFont.deriveFont(CURRENT_LEVEL_LABEL_FONT_SIZE);

            currentLevelLabel.setForeground(Color.WHITE);

            currentLevelLabel.setFont(Utilities.normalFont);

            currentLevelLabel.setPreferredSize(LEVEL_LABEL_SIZE);
            currentLevelLabel.setMaximumSize(LEVEL_LABEL_SIZE);
            currentLevelLabel.setMinimumSize(LEVEL_LABEL_SIZE);

            currentLevelLabel.setVerticalAlignment(SwingConstants.CENTER);

            currentLevelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            currentLevelLabel.setBounds(LEVEL_LABEL_BOUNDS);

            add(currentLevelLabel);
        }

        return currentLevelLabel;
    }
}
