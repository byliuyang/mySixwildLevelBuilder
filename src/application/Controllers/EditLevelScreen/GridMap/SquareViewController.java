package application.Controllers.EditLevelScreen.GridMap;

import application.Controllers.ButtonController;
import application.Models.BonusMultiplier;
import application.Models.Square;
import application.Models.Tile;
import application.Models.Value;
import application.Views.Components.StyledButton;
import application.Views.Screens.EditLevelScreenPackage.EditLevelScreen;
import application.Views.Screens.EditLevelScreenPackage.GridView;
import application.Views.Screens.EditLevelScreenPackage.SquareView;
import application.Views.Screens.LevelScreenPackage.SmallSquareView;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/19/15.
 */
public class SquareViewController extends ButtonController {

    EditLevelScreen editLevelScreen;

    public SquareViewController(StyledButton button, EditLevelScreen editLevelScreen) {
        super(button);
        this.editLevelScreen = editLevelScreen;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (editLevelScreen.getActiveView() != null) {
            Square square = ((SquareView) button).getSquare();
            int row = (int) square.getLocation().getRow().getValue();
            int column = (int) square.getLocation().getColumn().getValue();

            if (editLevelScreen.getActiveView().getNormalBackColor().equals(Color.WHITE)) {

                editLevelScreen.getGridView().getGrid().removeSquare(row, column);
                editLevelScreen.getGridView().getSquareViews()[row][column].getSquare().setTile(null);
                editLevelScreen.getGridView().getSquareViews()[row][column].setNormalBackColor(Color.WHITE);
            } else if(editLevelScreen.getActiveView() instanceof SquareView){

                SquareView squareView = ((SquareView) editLevelScreen.getActiveView());
                Tile tile = squareView.getSquare().getTile();

                if (tile != null) {
                    int number = (int) tile.getNumber().getValue();
                    tile = new Tile(new Value(number), null);
                }

                Square activeSquare = squareView.getSquare();

                if (activeSquare != null) {

                    if (squareView.getSquare().isContainer()) {
                        square.container();
                    }

                    if (square != null) {
                        square.setTile(tile);
                    }
                }

                editLevelScreen.getGridView().getSquareViews()[row][column].setNormalBackColor(GridView.SQUARE_NORMAL_BACK_COLOR);
            } else if(editLevelScreen.getActiveView() instanceof SmallSquareView) {

                SmallSquareView smallSquareView = ((SmallSquareView) editLevelScreen.getActiveView());
                Tile tile = square.getTile();
                if (tile != null) {
                    int number = (int) smallSquareView.getSquare().getTile().getNumber().getValue();
                    if(tile.getNumber().getValue()!=6) {
                        BonusMultiplier multiplier = new BonusMultiplier(new Value(number));

                        tile.setMutiplier(multiplier);
                    }
                }
            }

            editLevelScreen.getGridView().getSquareViews()[row][column].repaint();
            editLevelScreen.getActiveView().inactive();
            editLevelScreen.setActiveView(null);
        }
    }
}
