package edaii.gameoflife.game;

import edaii.gameoflife.app.GameOfLifeMainClass;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class GameLogic {


    static final int rows= GameConstants.RowsValue();
    static final int columns= GameConstants.ColumnsValue();
    static final int SIZE= rows * columns;
    public List<CellState> nextGeneration(final List<CellState> population) {


        return Stream.iterate(0, j -> j+1)
                .limit(SIZE)
                .map(j -> {

                    final int liveNeighbors = countLiveNeighbors(population, j);

                    // Aplicar las reglas del juego
                    if (liveNeighbors < 2 || liveNeighbors > 3) {

                        return  CellState.create(0);// Muere por soledad o sobrepoblación

                    } else if (liveNeighbors == 3) {

                        return CellState.create(1); // Nace por reproducción

                    } else {

                        return population.get(j); // Sigue viva
                    }

                }).toList();

    }
    private static int countLiveNeighbors(List<CellState> population, int index) {


        return (int)  IntStream.range(0, SIZE)
                .filter(i -> {
                    final int row = i / columns;
                    final int col = i % columns;

                    boolean isNeighbor = Math.abs(row - index / columns) <= 1 &&
                            Math.abs(col - index % columns) <= 1;

                    return isNeighbor && i != index;
                })
                .mapToObj(population::get)
                .filter(CellState::isAlive)
                .count();
    }
}