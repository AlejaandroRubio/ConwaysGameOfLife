package edaii.gameoflife.app;

import edaii.gameoflife.game.CellState;
import edaii.gameoflife.game.GameLogic;
import edaii.gameoflife.game.TextReader;
import edaii.gameoflife.ui.GameWindow;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLifeMainClass {

    //Para los Test
    //public static final int ROWS = 3;
    //public static final int COLUMNS = 3;

    //Para el juego Normal
    public static final int ROWS = 32;
    public static final int COLUMNS = 32;


    public static int newROWS;
    public static int newCOLUMNS;



    public static final int MSECONDS_PER_DAY = 500;

    public static boolean isfile = false;
    static final TextReader textReader = new TextReader();

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        final GameWindow game = new GameWindow();

        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Seleccionar archivo", FileDialog.LOAD);
        fileDialog.setVisible(true);


        if (fileDialog.getFile()!=null){

            textReader.customFileReader(fileDialog.getDirectory() + fileDialog.getFile());

            newROWS= textReader.rows();
            newCOLUMNS= textReader.columns();

            game.setRowsAndColumns(newROWS, newCOLUMNS);
            isfile=true;




        }else {

            game.setRowsAndColumns(ROWS, COLUMNS);

        }

        final GameLogic gameLogic = new GameLogic();

        // Inicializa la población
        List<CellState> population = initializePopulation(ROWS, COLUMNS);

        while (true) {
            // Siguiente generación
           population = gameLogic.nextGeneration(population);

            // Convierte la población en una lista de enteros
            // representando estados validos
            final List<Integer> cellStates = population
                    .stream()
                    .map(CellState::toInt)
                    .collect(Collectors.toUnmodifiableList());

            // Repesenta el estado
            game.setCellStates(cellStates);

            // Pasa el día
            Thread.sleep(MSECONDS_PER_DAY);
        }

    }

    private static List<CellState> initializePopulation(int rows, int columns) throws FileNotFoundException {


    if (isfile == true){


        return textReader.getPopulation();

    }else{

        final Random rnd = new Random(System.currentTimeMillis());
        return Stream.iterate(0, i -> i + 1)
                .limit(rows * columns)
                .map(i -> CellState.create(rnd.nextBoolean()))
                .collect(Collectors.toUnmodifiableList());

    }




    }

}
