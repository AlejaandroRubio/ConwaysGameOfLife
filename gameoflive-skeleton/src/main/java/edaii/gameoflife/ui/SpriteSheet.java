package edaii.gameoflife.ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpriteSheet<A> {

    private final Image sheetImage;
    private final Dimension size;
    private final int rows, columns;
    private final HashMap<A, AliasValue> cachedAlias = new HashMap<>();

    class Position
    {
        public Position(int r, int c){ row = r; column = c;}
        int row;
        int column;
    }

    class AliasValue
    {
        AliasValue(Position p){ position = p; };
        Position position;
        Image cached;
    }

    public SpriteSheet(Image img, int rows, int columns, Dimension spriteSize){
        sheetImage = img;
        this.rows = rows;
        this.columns = columns;
        this.size = spriteSize;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public void setAlias(A alias, int row, int column){
        cachedAlias.put(alias, new AliasValue(new Position(row, column)) );
    }

    public Image get(A alias){
        if(!cachedAlias.containsKey(alias)){
            throw new RuntimeException("Alias is not set:" + alias);
        }

        AliasValue value = cachedAlias.get(alias);
        if(value.cached == null){
            value.cached = get(value.position);
        }

        return value.cached;
    }

    private Image get(Position position){
        BufferedImage image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

        var g = image.createGraphics();
        int x = position.column * size.width ;
        int y = position.row * size.height;
        g.drawImage(sheetImage,
                0, 0, size.width, size.height,
                x, y, x+size.width, y+size.height,
                null,
                null);

        g.dispose();

        return image;
    }
}
