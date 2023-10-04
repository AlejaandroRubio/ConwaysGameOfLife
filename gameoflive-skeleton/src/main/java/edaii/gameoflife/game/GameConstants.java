package edaii.gameoflife.game;

import edaii.gameoflife.app.GameOfLifeMainClass;

public class GameConstants {
    public static final int CELL_ALIVE = 1;
    public static final int CELL_DEAD = 0;

    public static boolean isValidState(int state){
        return state == CELL_ALIVE
                || state == CELL_DEAD;
    }


    public static final int RowsValue(){

        if (GameOfLifeMainClass.isfile==true){
            return GameOfLifeMainClass.newROWS;
        }else {
            return GameOfLifeMainClass.ROWS;
        }

    };


    public static int ColumnsValue(){

            if (GameOfLifeMainClass.isfile==true){
                return GameOfLifeMainClass.newCOLUMNS;
            }else {
                return GameOfLifeMainClass.COLUMNS;
            }
    };


    public static int DEFAULT_SOLITUDE_LIMIT = 1;

    public static  int DEFAULT_OVERPOPULATION_LIMIT = 4;

    public static int DEFAULT_GENERATION_NUMBER = 3;
}
