package application.Views.Screens.LevelScreenPackage;

import application.Models.Square;
import application.Models.Value;
import application.Utilities;
import application.Views.Components.StyledButton;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

/**
 * Created by harryliu on 5/11/15.
 */
public class SmallSquareView extends StyledButton {

    //    Tile view size
    public static final Dimension TILE_VIEW_SIZE = new Dimension(20, 20);
    //    Square size
    public static final Dimension SQUARE_VIEW_SIZE = new Dimension(26, 26);
    //    Tile font size
    final float FONT_SIZE = 15L;
    //    Tile background color
    final Color[] TILE_BACK_COLOR = {
            new Color(236, 113, 113),
            new Color(248, 160, 15),
            new Color(208, 87, 166),
            new Color(114, 174, 114),
            new Color(62, 152, 199),
            new Color(124, 62, 182)
    };
    //    Rounded arc x
    final int ROUNDED_ARC_X = 8;
    //    Rounded arc y
    final int ROUNDED_ARC_Y = 8;


    Square square;

    public SmallSquareView(Color normalBackColor, Color hoveredBackColor, Color activedBackColor, Color disabledBackColor, Square square, int roundRadius) {
        super(normalBackColor, hoveredBackColor, activedBackColor, disabledBackColor, roundRadius);
        this.square = square;
    }

    public void redrawState() {
        super.redrawState();

        if (square.getTile() != null) {

            Value tileNumber = square.getTile().getNumber();

            graphics2D.setColor(TILE_BACK_COLOR[(int) tileNumber.getValue() - 1]);

            graphics2D.fillRoundRect(
                    (int) ((SQUARE_VIEW_SIZE.getWidth() - TILE_VIEW_SIZE.getWidth()) / 2),
                    (int) ((SQUARE_VIEW_SIZE.getHeight() - TILE_VIEW_SIZE.getHeight()) / 2),
                    (int) TILE_VIEW_SIZE.getWidth(),
                    (int) TILE_VIEW_SIZE.getHeight(),
                    ROUNDED_ARC_X,
                    ROUNDED_ARC_Y);

//        Setup font
            Utilities.normalFont = Utilities.normalFont.deriveFont(FONT_SIZE);

            int containerWidth = (int) getMinimumSize().getWidth();
            int containerHeight = (int) getMinimumSize().getHeight();
            String text = tileNumber.toString();

            FontMetrics metrics = graphics2D.getFontMetrics(Utilities.normalFont);
            int fontWidth = metrics.stringWidth(text);

            FontRenderContext renderContext = graphics2D.getFontRenderContext();

            GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
            Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

            int textPaddingTop = (containerHeight - visualBounds.y) / 2;
            int textPaddingLeft = (containerWidth - fontWidth) / 2;

            graphics2D.setColor(Color.WHITE);
            graphics2D.setFont(Utilities.normalFont);
            graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
        }
    }

    @Override
    public void normal() {
        if (square.isContainer() || square.isMarked()) {
            currentBackColor = disabledBackColor;
            super.repaint();
        } else {
            super.normal();
        }
    }


    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
