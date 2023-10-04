
package edaii.gameoflife.app;

import edaii.gameoflife.game.CellState;
import edaii.gameoflife.game.GameLogic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
Los tests unitarios se estan hechos para una matriz de 3x3 asi que para que funcionen corectamente se necesita cambiar
la variable ROWS y COLUMNS a 3 en la clase GameOfLifeMainClass.java
*/

public class GamelogicTest {



    @BeforeAll
    public static void setUp() {
        GameOfLifeMainClass.isfile = true;

        GameOfLifeMainClass.newROWS = 3;
        GameOfLifeMainClass.newCOLUMNS = 3;
    }




    @Test
    public void testOscillatorsBlinker() {



        GameLogic gameLogic = new GameLogic();

        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(1), CellState.create(0),
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0),      //| 0 | 1 | 0 |
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(0), CellState.create(0),
                                                                                    //| 0 | 0 | 0 |
                CellState.create(1), CellState.create(1), CellState.create(1),      //| 1 | 1 | 1 |
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);
    }

    @Test
    public void testStilllifesTub() {

        GameLogic gameLogic = new GameLogic();


        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(1), CellState.create(0),
                                                                                    //| 0 | 1 | 0 |
                CellState.create(1), CellState.create(0), CellState.create(1),      //| 1 | 0 | 1 |
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(1), CellState.create(0),
                                                                                    //| 0 | 1 | 0 |
                CellState.create(1), CellState.create(0), CellState.create(1),      //| 1 | 0 | 1 |
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);

    }

    @Test
    public void testStilllifesBoat() {
        GameLogic gameLogic = new GameLogic();

        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(1), CellState.create(0),
                                                                                    //| 1 | 1 | 0 |
                CellState.create(1), CellState.create(0), CellState.create(1),      //| 1 | 0 | 1 |
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(1), CellState.create(0),
                                                                                    //| 1 | 1 | 0 |
                CellState.create(1), CellState.create(0), CellState.create(1),      //| 1 | 0 | 1 |
                                                                                    //| 0 | 1 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);
    }



    @Test
    public void testBorn() {
        GameLogic gameLogic = new GameLogic();

        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(1), CellState.create(0),
                                                                                    //| 1 | 1 | 0 |
                CellState.create(1), CellState.create(0), CellState.create(0),      //| 1 | 0 | 0 |
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(1), CellState.create(0),
                                                                                    //| 1 | 1 | 0 |
                CellState.create(1), CellState.create(1), CellState.create(0),      //| 1 | 1 | 0 |
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);
    }


    @Test
    public void testSolitude() {
        GameLogic gameLogic = new GameLogic();

        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(0), CellState.create(0),
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(1), CellState.create(0),      //| 0 | 1 | 0 |
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(0), CellState.create(0), CellState.create(0),
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0),      //| 0 | 0 | 0 |
                                                                                    //| 0 | 0 | 0 |
                CellState.create(0), CellState.create(0), CellState.create(0)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);
    }


    @Test
    public void testOverPopulation() {
        GameLogic gameLogic = new GameLogic();

        // Crear una población inicial de ejemplo
        List<CellState> initGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(1), CellState.create(1),
                                                                                    //| 1 | 1 | 1 |
                CellState.create(1), CellState.create(1), CellState.create(1),      //| 1 | 1 | 1 |
                                                                                    //| 1 | 1 | 1 |
                CellState.create(1), CellState.create(1), CellState.create(1)
        }).toList();

        // Calcular la siguiente generación
        List<CellState> nextGeneration = gameLogic.nextGeneration(initGeneration);

        // Comprobar el resultado esperado
        List<CellState> expectedGeneration = Arrays.stream(new CellState[]{
                CellState.create(1), CellState.create(0), CellState.create(1),
                                                                                    //| 1 | 0 | 1 |
                CellState.create(0), CellState.create(0), CellState.create(0),      //| 0 | 0 | 0 |
                                                                                    //| 1 | 0 | 1 |
                CellState.create(1), CellState.create(0), CellState.create(1)
        }).toList();

        assertEquals(expectedGeneration, nextGeneration);
    }
}
