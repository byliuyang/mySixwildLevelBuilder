package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.TextContact;
import application.Controllers.EditLevelScreen.StarMilestonePreference.ChangeOneStarMilestoneController;
import application.Controllers.EditLevelScreen.StarMilestonePreference.ChangeThreeStarMilestoneController;
import application.Controllers.EditLevelScreen.StarMilestonePreference.ChangeTwoStarMilestoneController;
import application.Utilities;
import application.Views.Components.SmallStarsView;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class StarMilestonePanel extends JPanel implements IModelUpdated{

    //    Star milestone label size and bounds
    final Dimension STAR_MILESTONE_LABEL_SIZE = new Dimension(200, 26);
    final Rectangle STAR_MILESTONE_LABEL_BOUNDS = new Rectangle(20, 20, 200, 26);

    //    One star view size and bounds
    final Dimension ONE_STAR_VIEW_SIZE = new Dimension(50, 20);
    final Rectangle ONE_STAR_VIEW_BOUNDS = new Rectangle(20, 60, 50, 26);

    //    Two star view size and bounds
    final Dimension TWO_STAR_VIEW_SIZE = new Dimension(50, 20);
    final Rectangle TWO_STAR_VIEW__BOUNDS = new Rectangle(20, 96, 50, 26);

    //    Three star view size and bounds
    final Dimension THREE_STAR_VIEW_SIZE = new Dimension(50, 20);
    final Rectangle THREE_STAR_VIEW_BOUNDS = new Rectangle(20, 132, 50, 26);

    //     One star text size and bounds
    final Dimension ONE_STAR_TEXT_SIZE = new Dimension(224, 26);
    final Rectangle ONE_STAR_TEXT_BOUNDS = new Rectangle(80, 56, 224, 26);

    //    Two star text size and bounds
    final Dimension TWO_STAR_TEXT_SIZE = new Dimension(224, 26);
    final Rectangle TWO_STAR_TEXT_BOUNDS = new Rectangle(80, 92, 224, 26);

    //    Three star text size and bounds
    final Dimension THREE_STAR_TEXT_SIZE = new Dimension(224, 26);
    final Rectangle THREE_STAR_TEXT_BOUNDS = new Rectangle(80, 128, 224, 26);

    EditLevelScreen editLevelScreen;

    JLabel starMilestoneLabel;

    SmallStarsView oneStarView;
    SmallStarsView twoStarView;
    SmallStarsView threeStarView;

    JTextField oneStarText;
    JTextField twoStarText;
    JTextField threeStarText;

    public StarMilestonePanel(EditLevelScreen editLevelScreen) {

        this.editLevelScreen = editLevelScreen;

        setLayout(null);

        setBackground(Color.WHITE);

        setBorder(BorderFactory.createMatteBorder(
                Utilities.ZERO,
                Utilities.ZERO,
                Utilities.ONE,
                Utilities.ZERO,
                LevelPreferencePanel.BORDER_COLOR_BRIGHT
        ));

//        Add components
        add(getStarMilestoneLabel());

        add(getOneStarView());
        getOneStarView().repaint();

        add(getTwoStarView());
        getTwoStarView().repaint();

        add(getThreeStarView());
        getThreeStarView().repaint();

        add(getOneStarText());

        add(getTwoStarText());

        add(getThreeStarText());
    }

    public JLabel getStarMilestoneLabel() {

        if (starMilestoneLabel == null) {
            starMilestoneLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            starMilestoneLabel.setFont(font);

            starMilestoneLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            starMilestoneLabel.setPreferredSize(STAR_MILESTONE_LABEL_SIZE);
            starMilestoneLabel.setMinimumSize(STAR_MILESTONE_LABEL_SIZE);
            starMilestoneLabel.setMaximumSize(STAR_MILESTONE_LABEL_SIZE);

            starMilestoneLabel.setBounds(STAR_MILESTONE_LABEL_BOUNDS);

            starMilestoneLabel.setText(TextContact.STAR_MILE_STONES_TEXT);

        }

        return starMilestoneLabel;
    }

    public SmallStarsView getOneStarView() {

        if (oneStarView == null) {
            oneStarView = new SmallStarsView(Utilities.ONE);

            oneStarView.setPreferredSize(ONE_STAR_VIEW_SIZE);
            oneStarView.setMinimumSize(ONE_STAR_VIEW_SIZE);
            oneStarView.setMaximumSize(ONE_STAR_VIEW_SIZE);

            oneStarView.setBounds(ONE_STAR_VIEW_BOUNDS);

        }

        return oneStarView;
    }

    public SmallStarsView getTwoStarView() {

        if (twoStarView == null) {
            twoStarView = new SmallStarsView(Utilities.TWO);

            twoStarView.setPreferredSize(TWO_STAR_VIEW_SIZE);
            twoStarView.setMinimumSize(TWO_STAR_VIEW_SIZE);
            twoStarView.setMaximumSize(TWO_STAR_VIEW_SIZE);

            twoStarView.setBounds(TWO_STAR_VIEW__BOUNDS);

        }

        return twoStarView;
    }

    public SmallStarsView getThreeStarView() {

        if (threeStarView == null) {
            threeStarView = new SmallStarsView(Utilities.THREE);

            threeStarView.setPreferredSize(THREE_STAR_VIEW_SIZE);
            threeStarView.setMinimumSize(THREE_STAR_VIEW_SIZE);
            threeStarView.setMaximumSize(THREE_STAR_VIEW_SIZE);

            threeStarView.setBounds(THREE_STAR_VIEW_BOUNDS);

        }

        return threeStarView;
    }

    public JTextField getOneStarText() {

        if (oneStarText == null) {

            oneStarText = new JTextField();

            oneStarText.setPreferredSize(ONE_STAR_TEXT_SIZE);
            oneStarText.setMinimumSize(ONE_STAR_TEXT_SIZE);
            oneStarText.setMaximumSize(ONE_STAR_TEXT_SIZE);

            oneStarText.setBounds(ONE_STAR_TEXT_BOUNDS);

            ChangeOneStarMilestoneController changeOneStarMilestoneController =
                    new ChangeOneStarMilestoneController(editLevelScreen, oneStarText);

            oneStarText.addActionListener(changeOneStarMilestoneController);
            oneStarText.addFocusListener(changeOneStarMilestoneController);
        }

        return oneStarText;
    }

    public JTextField getTwoStarText() {

        if (twoStarText == null) {

            twoStarText = new JTextField();

            twoStarText.setPreferredSize(TWO_STAR_TEXT_SIZE);
            twoStarText.setMinimumSize(TWO_STAR_TEXT_SIZE);
            twoStarText.setMaximumSize(TWO_STAR_TEXT_SIZE);

            twoStarText.setBounds(TWO_STAR_TEXT_BOUNDS);

            ChangeTwoStarMilestoneController changeTwoStarMilestoneController =
                    new ChangeTwoStarMilestoneController(editLevelScreen, twoStarText);

            twoStarText.addActionListener(changeTwoStarMilestoneController);
            twoStarText.addFocusListener(changeTwoStarMilestoneController);
        }

        return twoStarText;
    }

    public JTextField getThreeStarText() {

        if (threeStarText == null) {

            threeStarText = new JTextField();

            threeStarText.setPreferredSize(THREE_STAR_TEXT_SIZE);
            threeStarText.setMinimumSize(THREE_STAR_TEXT_SIZE);
            threeStarText.setMaximumSize(THREE_STAR_TEXT_SIZE);

            threeStarText.setBounds(THREE_STAR_TEXT_BOUNDS);

            ChangeThreeStarMilestoneController changeThreeStarMilestoneController =
                    new ChangeThreeStarMilestoneController(editLevelScreen, threeStarText);

            threeStarText.addActionListener(changeThreeStarMilestoneController);
            threeStarText.addFocusListener(changeThreeStarMilestoneController);
        }

        return threeStarText;
    }

    @Override
    public void modelChanged() {
        getOneStarText().setText((editLevelScreen.getLevel()).getScore().getOneStarScore().toString());
        getTwoStarText().setText((editLevelScreen.getLevel()).getScore().getTwoStarScore().toString());
        getThreeStarText().setText((editLevelScreen.getLevel()).getScore().getThreeStarScore().toString());
    }
}
