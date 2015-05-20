package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Views.Screens.LevelScreenPackage.SmallSquareView;

import javax.swing.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class TileProbabilityPanel extends JPanel {

    JLabel tileProbabilitiesLabel;

    SmallSquareView oneTileView;
    SmallSquareView twoTileView;
    SmallSquareView threeTileView;
    SmallSquareView fourTileView;
    SmallSquareView fiveTileView;
    SmallSquareView sixTileView;

    JTextField oneText;
    JTextField twoText;
    JTextField threeText;
    JTextField fourText;
    JTextField fiveText;
    JTextField sixText;

    public TileProbabilityPanel() {
    }

    public JLabel getTileProbabilitiesLabel() {
        return tileProbabilitiesLabel;
    }

    public SmallSquareView getOneTileView() {
        return oneTileView;
    }

    public SmallSquareView getTwoTileView() {
        return twoTileView;
    }

    public SmallSquareView getThreeTileView() {
        return threeTileView;
    }

    public SmallSquareView getFourTileView() {
        return fourTileView;
    }

    public SmallSquareView getFiveTileView() {
        return fiveTileView;
    }

    public SmallSquareView getSixTileView() {
        return sixTileView;
    }

    public JTextField getOneText() {
        return oneText;
    }

    public JTextField getTwoText() {
        return twoText;
    }

    public JTextField getThreeText() {
        return threeText;
    }

    public JTextField getFourText() {
        return fourText;
    }

    public JTextField getFiveText() {
        return fiveText;
    }

    public JTextField getSixText() {
        return sixText;
    }
}
