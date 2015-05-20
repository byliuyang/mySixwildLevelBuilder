package application.Views.Components;

import application.Contracts.ImageContract;
import application.Contracts.TipContract;
import application.Controllers.ViewLevelScreen.AddNewLevelButtonController;
import application.Views.Application;

import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class AddNewLevelToolBar extends NavigableBackToolBar {

    //    Add new level button background color
    final Color ADD_NEW_LEVEL_BUTTON_BACK_COLOR = new Color(112, 147, 113);
    final Color ADD_NEW_LEVEL_BUTTON_HOVERED_BACK_COLOR = new Color(103, 137, 104);

    //    Add new level button size
    final Dimension ADD_NEW_LEVEL_BUTTON_SIZE = new Dimension(42, 42);

    //    Add new level
    final Rectangle ADD_NEW_LEVEL_BUTTON_BOUNDS = new Rectangle(970, 8, 42, 42);

    final int HALF_ROUND = 42;

    private ImageButton addNewLevelButton;

    public AddNewLevelToolBar(Application app) {
        super(app);

        add(getAddNewLevelButton());

        AddNewLevelButtonController addNewLevelButtonController = new AddNewLevelButtonController(getAddNewLevelButton(),app);
        getAddNewLevelButton().addMouseMotionListener(addNewLevelButtonController);
        getAddNewLevelButton().addMouseListener(addNewLevelButtonController);

        getAddNewLevelButton().setToolTipText(TipContract.ADD_NEW_LEVEL_BUTTON_TIP);

        getAddNewLevelButton().repaint();
    }

    public ImageButton getAddNewLevelButton() {
        if (addNewLevelButton == null) {
            addNewLevelButton = new ImageButton(
                    ImageContract.ADD_NEW_LEVEL_BUTTON_IMAGE,
                    ImageContract.ADD_NEW_LEVEL_BUTTON_IMAGE,
                    ImageContract.ADD_NEW_LEVEL_BUTTON_IMAGE,
                    ImageContract.ADD_NEW_LEVEL_BUTTON_IMAGE,
                    ADD_NEW_LEVEL_BUTTON_BACK_COLOR,
                    ADD_NEW_LEVEL_BUTTON_HOVERED_BACK_COLOR,
                    ADD_NEW_LEVEL_BUTTON_BACK_COLOR,
                    ADD_NEW_LEVEL_BUTTON_BACK_COLOR,
                    HALF_ROUND
            );

            addNewLevelButton.setPreferredSize(ADD_NEW_LEVEL_BUTTON_SIZE);
            addNewLevelButton.setMaximumSize(ADD_NEW_LEVEL_BUTTON_SIZE);
            addNewLevelButton.setMinimumSize(ADD_NEW_LEVEL_BUTTON_SIZE);

            addNewLevelButton.setBounds(ADD_NEW_LEVEL_BUTTON_BOUNDS);
        }
        return addNewLevelButton;
    }
}
