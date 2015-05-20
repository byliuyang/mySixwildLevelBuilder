package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Views.Components.SmallStarsView;

import javax.swing.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class StarMilestonePanel extends JPanel{

    JLabel starMilestoneLabel;

    SmallStarsView oneStarView;
    SmallStarsView twoStarView;
    SmallStarsView threeStarView;

    JTextField oneStarText;
    JTextField twoStarText;
    JTextField threeStarText;

    public StarMilestonePanel() {
    }

    public JLabel getStarMilestoneLabel() {
        return starMilestoneLabel;
    }

    public SmallStarsView getOneStarView() {
        return oneStarView;
    }

    public SmallStarsView getTwoStarView() {
        return twoStarView;
    }

    public SmallStarsView getThreeStarView() {
        return threeStarView;
    }

    public JTextField getOneStarText() {
        return oneStarText;
    }

    public JTextField getTwoStarText() {
        return twoStarText;
    }

    public JTextField getThreeStarText() {
        return threeStarText;
    }
}
