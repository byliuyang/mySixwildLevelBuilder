package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Views.Components.ImageButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelSpecialMovePanel {

    JLabel numSpecialMoveLabel;

    ImageIcon swapSquareSpecialMoveIcon;
    ImageIcon resetBoardSpecialMoveIcon;
    ImageIcon clearTileSpecialMoveIcon;

    JTextField swapSquareSpecialMoveText;
    JTextField resetBoardSpecialMoveText;
    JTextField clearTileSpecialMoveText;

    public JLabel getNumSpecialMoveLabel() {
        return numSpecialMoveLabel;
    }

    public ImageIcon getSwapSquareSpecialMoveIcon() {
        return swapSquareSpecialMoveIcon;
    }

    public ImageIcon getResetBoardSpecialMoveIcon() {
        return resetBoardSpecialMoveIcon;
    }

    public ImageIcon getClearTileSpecialMoveIcon() {
        return clearTileSpecialMoveIcon;
    }

    public JTextField getSwapSquareSpecialMoveText() {
        return swapSquareSpecialMoveText;
    }

    public JTextField getResetBoardSpecialMoveText() {
        return resetBoardSpecialMoveText;
    }

    public JTextField getClearTileSpecialMoveText() {
        return clearTileSpecialMoveText;
    }
}
