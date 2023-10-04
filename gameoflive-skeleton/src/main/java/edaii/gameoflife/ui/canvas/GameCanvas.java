package edaii.gameoflife.ui.canvas;

import edaii.gameoflife.game.Factory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

public class GameCanvas extends Canvas {
    private static final long serialVersionUID = 8400687764137588555L;

    Image buffer;
    List<Integer> states;
    int columnsState;

    public GameCanvas(int width, int height, int columnsState) {
        super();
        this.columnsState = columnsState;
        setBackground(Color.black);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        states = null;
    }

    @Override
    public synchronized void paint(Graphics g) {
        super.paint(g);
        if (states != null && states.size() > 0) {
            paintGrid(buffer.getGraphics(), buffer.getWidth(this), buffer.getHeight(this));
            final Dimension size = getSize();
            g.drawImage(buffer, 0, 0, (int)size.getWidth(), (int)size.getHeight(), this);
        }
    }

    private void paintGrid(Graphics g, int width, int height) {
        final int numColumns = this.columnsState;
        final int numRows = states.size() / numColumns;

        final int tileMargin = 2;
        final int tileWidth = (width - tileMargin * numColumns) / numColumns;
        final int tileHeight = (height - tileMargin * numRows) / numRows;

        Iterator<Integer> iter = states.iterator();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                final int x = col * (tileWidth + tileMargin);
                final int y = row * (tileHeight + tileMargin);
                final int cellState = iter.next();
                Image img = Factory.getCellStatesSprites().get(cellState);
                g.drawImage(img, x, y, tileWidth, tileHeight, this);
            }
        }
    }

    public synchronized void setCellStates(List<Integer> states) {
        this.states = states;
    }
}
