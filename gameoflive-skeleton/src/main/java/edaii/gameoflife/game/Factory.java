package edaii.gameoflife.game;

import edaii.gameoflife.ui.SpriteSheet;
import edaii.gameoflife.utils.ImageHelper;

import java.awt.*;
import java.util.HashMap;

public final class Factory {

    private static SpriteSheet<Integer> cellStates;
    private static HashMap<Integer, Color> cellColors;

    public static SpriteSheet<Integer> getCellStatesSprites(){
        ensureCellStates();
        return cellStates;
    }

    private static void ensureCellStates() {
        if(cellStates != null) return;

        cellStates = new SpriteSheet(
                ImageHelper.fromResource("cell_states_32_32_1c_2r.png"),
                2, 1,
                new Dimension(32, 32) );

        cellStates.setAlias(GameConstants.CELL_DEAD, 1, 0);
        cellStates.setAlias(GameConstants.CELL_ALIVE, 0, 0);
    }

    public static HashMap<Integer, Color> getCellColors(){
        ensureCellColorsMap();
        return cellColors;
    }

    private static void ensureCellColorsMap() {
        if(cellColors != null) return;

        cellColors = new HashMap<>();
        cellColors.put(GameConstants.CELL_DEAD, Color.gray);
        cellColors.put(GameConstants.CELL_ALIVE, Color.getColor("#66a55b"));
    }

}
