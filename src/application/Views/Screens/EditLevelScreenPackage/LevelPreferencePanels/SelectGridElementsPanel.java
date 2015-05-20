package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Views.Screens.EditLevelScreenPackage.NoSquareView;
import application.Views.Screens.EditLevelScreenPackage.SquareView;

import javax.swing.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class SelectGridElementsPanel extends JPanel{
    JLabel selectElementsLabel;

    SquareView emptySquareView;
    SquareView sixReceiverView;
    NoSquareView noSquareView;

    SquareView oneSquareView;
    SquareView twoSquareView;
    SquareView threeSquareView;
    SquareView fourSquareView;
    SquareView fiveSquareView;
    SquareView sixSquareView;

    public SelectGridElementsPanel() {
    }

    public JLabel getSelectElementsLabel() {
        return selectElementsLabel;
    }

    public SquareView getEmptySquareView() {
        return emptySquareView;
    }

    public SquareView getSixReceiverView() {
        return sixReceiverView;
    }

    public NoSquareView getNoSquareView() {
        return noSquareView;
    }

    public SquareView getOneSquareView() {
        return oneSquareView;
    }

    public SquareView getTwoSquareView() {
        return twoSquareView;
    }

    public SquareView getThreeSquareView() {
        return threeSquareView;
    }

    public SquareView getFourSquareView() {
        return fourSquareView;
    }

    public SquareView getFiveSquareView() {
        return fiveSquareView;
    }

    public SquareView getSixSquareView() {
        return sixSquareView;
    }
}
