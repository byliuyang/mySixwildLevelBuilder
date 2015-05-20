package application.Views.Screens.EditLevelScreenPackage.LevelPreferencePanels;

import application.Contracts.ImageContract;
import application.Contracts.TextContact;
import application.Contracts.TipContract;
import application.Controllers.EditLevelScreen.SpecialMovePreference.ChangeClearTileSpecialMoveLimitController;
import application.Controllers.EditLevelScreen.SpecialMovePreference.ChangeResetBoardSpecialMoveLimitController;
import application.Controllers.EditLevelScreen.SpecialMovePreference.ChangeSwapSquareSpecialMoveLimitController;
import application.Utilities;
import application.Views.Components.ImageButton;
import application.Views.IModelUpdated;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/14/15.
 */
public class LevelSpecialMovePanel extends JPanel implements IModelUpdated {

    //    Special move label size and bounds
    final Dimension SPECIAL_MOVE_LABEL_SIZE = new Dimension(200, 26);
    final Rectangle SPECIAL_MOVE_LABEL_BOUNDS = new Rectangle(20, 20, 200, 26);

    //    Swap square special move icon size and bounds
    final Dimension SWAP_SQUARE_SPECIAL_MOVE_ICON_SIZE = new Dimension(40, 40);
    final Rectangle SWAP_SQUARE_SPECIAL_MOVE_ICON_BOUNDS = new Rectangle(20, 56, 40, 40);

    //    Reset board special move icon size and bounds
    final Dimension RESET_BOARD_SPECIAL_MOVE_ICON_SIZE = new Dimension(40, 40);
    final Rectangle RESET_BOARD_SPECIAL_MOVE_ICON_BOUNDS = new Rectangle(20, 106, 40, 40);

    //    Clear tile special move icon size and bounds
    final Dimension CLEAR_TILE_SPECIAL_MOVE_ICON_SIZE = new Dimension(40, 40);
    final Rectangle CLEAR_TILE_SPECIAL_MOVE_ICON_BOUNDS = new Rectangle(20, 156, 40, 40);

    //    Swap square special move text size and bounds
    final Dimension SWAP_SQUARE_SPECIAL_MOVE_TEXT_SIZE = new Dimension(234, 26);
    final Rectangle SWAP_SQUARE_SPECIAL_MOVE_TEXT_BOUNDS = new Rectangle(70, 63, 234, 26);

    //    Reset board special move text size and bounds
    final Dimension RESET_BOARD_SPECIAL_MOVE_TEXT_SIZE = new Dimension(234, 26);
    final Rectangle RESET_BOARD_SPECIAL_MOVE_TEXT_BOUNDS = new Rectangle(70, 113, 234, 26);

    //    Clear tile special move text size and bounds
    final Dimension CLEAR_TILE_SPECIAL_MOVE_TEXT_SIZE = new Dimension(234, 26);
    final Rectangle CLEAR_TILE_SPECIAL_MOVE_TEXT_BOUNDS = new Rectangle(70, 163, 234, 26);

    //    Special move icon colors
    final Color RESET_BOARD_SPECIAL_MOVE_ICON_BACK_COLOR = new Color(236, 64, 122);

    final Color SWAP_SQUARE_SPECIAL_MOVE_ICON_BACK_COLOR = new Color(141, 110, 99);

    final Color REMOVE_TILE_SPECIAL_MOVE_ICON_BACK_COLOR = new Color(255, 87, 34);

    //    Special move icon round
    final int ICON_ROUND = 10;

    EditLevelScreen editLevelScreen;

    JLabel numSpecialMoveLabel;

    ImageButton swapSquareSpecialMoveIcon;
    ImageButton resetBoardSpecialMoveIcon;
    ImageButton clearTileSpecialMoveIcon;

    JTextField swapSquareSpecialMoveText;
    JTextField resetBoardSpecialMoveText;
    JTextField clearTileSpecialMoveText;

    public LevelSpecialMovePanel(EditLevelScreen editLevelScreen) {

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

        add(getNumSpecialMoveLabel());

        add(getSwapSquareSpecialMoveIcon());
        getSwapSquareSpecialMoveIcon().repaint();
        add(getSwapSquareSpecialMoveText());

        add(getResetBoardSpecialMoveIcon());
        getResetBoardSpecialMoveIcon().repaint();
        add(getResetBoardSpecialMoveText());

        add(getClearTileSpecialMoveIcon());
        getClearTileSpecialMoveIcon().repaint();
        add(getClearTileSpecialMoveText());
    }

    public JLabel getNumSpecialMoveLabel() {

        if (numSpecialMoveLabel == null) {
            numSpecialMoveLabel = new JLabel();

            Font font = Utilities.normalFont.deriveFont(Font.BOLD, LevelPreferencePanel.PANEL_TITLE_FONT_SIZE);
            numSpecialMoveLabel.setFont(font);

            numSpecialMoveLabel.setForeground(LevelPreferencePanel.PANEL_FOREGROUND_COLOR);

            numSpecialMoveLabel.setPreferredSize(SPECIAL_MOVE_LABEL_SIZE);
            numSpecialMoveLabel.setMinimumSize(SPECIAL_MOVE_LABEL_SIZE);
            numSpecialMoveLabel.setMaximumSize(SPECIAL_MOVE_LABEL_SIZE);

            numSpecialMoveLabel.setBounds(SPECIAL_MOVE_LABEL_BOUNDS);

            numSpecialMoveLabel.setText(TextContact.NUMBER_SPECIAL_MOVE_TEXT);

        }

        return numSpecialMoveLabel;
    }

    public ImageButton getSwapSquareSpecialMoveIcon() {

        if (swapSquareSpecialMoveIcon == null) {
            swapSquareSpecialMoveIcon = new ImageButton(
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    SWAP_SQUARE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    SWAP_SQUARE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    SWAP_SQUARE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    SWAP_SQUARE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    ICON_ROUND
            );

            swapSquareSpecialMoveIcon.setPreferredSize(SWAP_SQUARE_SPECIAL_MOVE_ICON_SIZE);
            swapSquareSpecialMoveIcon.setMinimumSize(SWAP_SQUARE_SPECIAL_MOVE_ICON_SIZE);
            swapSquareSpecialMoveIcon.setMaximumSize(SWAP_SQUARE_SPECIAL_MOVE_ICON_SIZE);

            swapSquareSpecialMoveIcon.setBounds(SWAP_SQUARE_SPECIAL_MOVE_ICON_BOUNDS);

            swapSquareSpecialMoveIcon.setToolTipText(TipContract.SWAP_SQUARE_SPECIAL_MOVE_TIP);

        }

        return swapSquareSpecialMoveIcon;
    }

    public ImageButton getResetBoardSpecialMoveIcon() {

        if (resetBoardSpecialMoveIcon == null) {
            resetBoardSpecialMoveIcon = new ImageButton(
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    RESET_BOARD_SPECIAL_MOVE_ICON_BACK_COLOR,
                    RESET_BOARD_SPECIAL_MOVE_ICON_BACK_COLOR,
                    RESET_BOARD_SPECIAL_MOVE_ICON_BACK_COLOR,
                    RESET_BOARD_SPECIAL_MOVE_ICON_BACK_COLOR,
                    ICON_ROUND
            );

            resetBoardSpecialMoveIcon.setPreferredSize(RESET_BOARD_SPECIAL_MOVE_ICON_SIZE);
            resetBoardSpecialMoveIcon.setMinimumSize(RESET_BOARD_SPECIAL_MOVE_ICON_SIZE);
            resetBoardSpecialMoveIcon.setMaximumSize(RESET_BOARD_SPECIAL_MOVE_ICON_SIZE);

            resetBoardSpecialMoveIcon.setBounds(RESET_BOARD_SPECIAL_MOVE_ICON_BOUNDS);

            resetBoardSpecialMoveIcon.setToolTipText(TipContract.RESET_BOARD_SPECIAL_MOVE_TIP);

        }

        return resetBoardSpecialMoveIcon;
    }

    public ImageButton getClearTileSpecialMoveIcon() {

        if (clearTileSpecialMoveIcon == null) {
            clearTileSpecialMoveIcon = new ImageButton(
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    REMOVE_TILE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    REMOVE_TILE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    REMOVE_TILE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    REMOVE_TILE_SPECIAL_MOVE_ICON_BACK_COLOR,
                    ICON_ROUND
            );

            clearTileSpecialMoveIcon.setPreferredSize(CLEAR_TILE_SPECIAL_MOVE_ICON_SIZE);
            clearTileSpecialMoveIcon.setMinimumSize(CLEAR_TILE_SPECIAL_MOVE_ICON_SIZE);
            clearTileSpecialMoveIcon.setMaximumSize(CLEAR_TILE_SPECIAL_MOVE_ICON_SIZE);

            clearTileSpecialMoveIcon.setBounds(CLEAR_TILE_SPECIAL_MOVE_ICON_BOUNDS);

            clearTileSpecialMoveIcon.setToolTipText(TipContract.CLEAR_TILE_SPECIAL_MOVE_TIP);

        }

        return clearTileSpecialMoveIcon;
    }

    public JTextField getSwapSquareSpecialMoveText() {

        if (swapSquareSpecialMoveText == null) {

            swapSquareSpecialMoveText = new JTextField();

            swapSquareSpecialMoveText.setPreferredSize(SWAP_SQUARE_SPECIAL_MOVE_TEXT_SIZE);
            swapSquareSpecialMoveText.setMinimumSize(SWAP_SQUARE_SPECIAL_MOVE_TEXT_SIZE);
            swapSquareSpecialMoveText.setMaximumSize(SWAP_SQUARE_SPECIAL_MOVE_TEXT_SIZE);

            swapSquareSpecialMoveText.setBounds(SWAP_SQUARE_SPECIAL_MOVE_TEXT_BOUNDS);

            ChangeSwapSquareSpecialMoveLimitController changeSwapSquareSpecialMoveLimitController =
                    new ChangeSwapSquareSpecialMoveLimitController(editLevelScreen, swapSquareSpecialMoveText);

            swapSquareSpecialMoveText.addActionListener(changeSwapSquareSpecialMoveLimitController);
            swapSquareSpecialMoveText.addFocusListener(changeSwapSquareSpecialMoveLimitController);
        }

        return swapSquareSpecialMoveText;
    }

    public JTextField getResetBoardSpecialMoveText() {

        if (resetBoardSpecialMoveText == null) {

            resetBoardSpecialMoveText = new JTextField();

            resetBoardSpecialMoveText.setPreferredSize(RESET_BOARD_SPECIAL_MOVE_TEXT_SIZE);
            resetBoardSpecialMoveText.setMinimumSize(RESET_BOARD_SPECIAL_MOVE_TEXT_SIZE);
            resetBoardSpecialMoveText.setMaximumSize(RESET_BOARD_SPECIAL_MOVE_TEXT_SIZE);

            resetBoardSpecialMoveText.setBounds(RESET_BOARD_SPECIAL_MOVE_TEXT_BOUNDS);

            ChangeResetBoardSpecialMoveLimitController changeResetBoardSpecialMoveLimitController =
                    new ChangeResetBoardSpecialMoveLimitController(editLevelScreen, resetBoardSpecialMoveText);

            resetBoardSpecialMoveText.addActionListener(changeResetBoardSpecialMoveLimitController);
            resetBoardSpecialMoveText.addFocusListener(changeResetBoardSpecialMoveLimitController);

        }

        return resetBoardSpecialMoveText;
    }

    public JTextField getClearTileSpecialMoveText() {
        if (clearTileSpecialMoveText == null) {

            clearTileSpecialMoveText = new JTextField();

            clearTileSpecialMoveText.setPreferredSize(CLEAR_TILE_SPECIAL_MOVE_TEXT_SIZE);
            clearTileSpecialMoveText.setMinimumSize(CLEAR_TILE_SPECIAL_MOVE_TEXT_SIZE);
            clearTileSpecialMoveText.setMaximumSize(CLEAR_TILE_SPECIAL_MOVE_TEXT_SIZE);

            clearTileSpecialMoveText.setBounds(CLEAR_TILE_SPECIAL_MOVE_TEXT_BOUNDS);

            ChangeClearTileSpecialMoveLimitController changeClearTileSpecialMoveLimitController =
                    new ChangeClearTileSpecialMoveLimitController(editLevelScreen, clearTileSpecialMoveText);

            clearTileSpecialMoveText.addActionListener(changeClearTileSpecialMoveLimitController);
            clearTileSpecialMoveText.addFocusListener(changeClearTileSpecialMoveLimitController);
        }

        return clearTileSpecialMoveText;
    }

    @Override
    public void modelChanged() {
        getSwapSquareSpecialMoveText().setText((editLevelScreen.getLevel()).getSpecialMoveLeft().getSwapTileSpecialMove().toString());
        getResetBoardSpecialMoveText().setText((editLevelScreen.getLevel()).getSpecialMoveLeft().getResetBoardSpecialMove().toString());
        getClearTileSpecialMoveText().setText((editLevelScreen.getLevel()).getSpecialMoveLeft().getRemoveTileSpecialMove().toString());
    }
}
