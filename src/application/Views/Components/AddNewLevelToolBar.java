package application.Views.Components;

import application.Contracts.ImageContract;
import application.Contracts.TextContact;
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
    final Color ADD_NEW_LEVEL_BUTTON_HOVERED_BACK_COLOR = new Color(86, 116, 87);

    //    Add new level button size
    final Dimension ADD_NEW_LEVEL_BUTTON_SIZE = new Dimension(42, 42);

    //    Add new level
    final Rectangle ADD_NEW_LEVEL_BUTTON_BOUNDS = new Rectangle(850, 8, 42, 42);

    //    Add new level button label font size
    final float ADD_NEW_LEVEL_LABEL_FONT_SIZE = 22L;

    //    Add new level button label bounds
    final Rectangle ADD_NEW_LEVEL_LABEL_BOUNDS = new Rectangle(900, 0, 120, 58);

    //    Add new level button label size
    final Dimension ADD_NEW_LEVEL_LABEL_SIZE = new Dimension(120, 58);

    final static boolean LEFT_ALIGN = true;

    private ImageButton addNewLevelButton;

    private StyledLabel addNewLevelButtonLabel;

    public AddNewLevelToolBar(Application app) {
        super(app);

        add(getAddNewLevelButton());

        AddNewLevelButtonController addNewLevelButtonController = new AddNewLevelButtonController(getAddNewLevelButton());
        getAddNewLevelButton().addMouseMotionListener(addNewLevelButtonController);
        getAddNewLevelButton().addMouseListener(addNewLevelButtonController);

        getAddNewLevelButton().setToolTipText(TipContract.ADD_NEW_LEVEL_BUTTON_TIP);

        getAddNewLevelButton().repaint();

        add(getAddNewLevelButtonLabel());
        getAddNewLevelButtonLabel().repaint();
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
                    NO_ROUND
            );

            addNewLevelButton.setPreferredSize(ADD_NEW_LEVEL_BUTTON_SIZE);
            addNewLevelButton.setMaximumSize(ADD_NEW_LEVEL_BUTTON_SIZE);
            addNewLevelButton.setMinimumSize(ADD_NEW_LEVEL_BUTTON_SIZE);

            addNewLevelButton.setBounds(ADD_NEW_LEVEL_BUTTON_BOUNDS);
        }
        return addNewLevelButton;
    }

    public StyledLabel getAddNewLevelButtonLabel() {

        if (addNewLevelButtonLabel == null) {
            addNewLevelButtonLabel = new StyledLabel(
                    TextContact.ADD_NEW_LEVEL_TEXT,
                    ADD_NEW_LEVEL_LABEL_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN
            );
            addNewLevelButtonLabel.setPreferredSize(ADD_NEW_LEVEL_LABEL_SIZE);
            addNewLevelButtonLabel.setMaximumSize(ADD_NEW_LEVEL_LABEL_SIZE);
            addNewLevelButtonLabel.setMinimumSize(ADD_NEW_LEVEL_LABEL_SIZE);

            addNewLevelButtonLabel.setBounds(ADD_NEW_LEVEL_LABEL_BOUNDS);
        }

        return addNewLevelButtonLabel;
    }
}
