package edaii.gameoflife.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {

    static List<String> filterRowsAndColumns;
    static List<String> filterPopulation;


    public void customFileReader(String path) throws FileNotFoundException {


    FileReader fr = new FileReader(path);

    BufferedReader bufferedReader = new BufferedReader(fr);

    List<String> fileLines = bufferedReader.lines().collect(Collectors.toList());

   filterRowsAndColumns = fileLines.stream().filter(line -> line.contains(";")).collect(Collectors.toList());

   filterPopulation = fileLines.stream().filter(line -> !line.contains(";")).collect(Collectors.toList());



    }

    public static final int columns() {

        String[] rowsAndColumns = filterRowsAndColumns.get(0).split(";");
        final int columns= Integer.parseInt(rowsAndColumns[1]);
        return columns;

    }


    public static final int rows() {

        String[] rowsAndColumns = filterRowsAndColumns.get(0).split(";");
        final int rows= Integer.parseInt(rowsAndColumns[0]);
        return rows;

    }


    public final List<CellState> getPopulation() {

        return Stream.iterate(0, i -> i + 1)
                .limit(filterPopulation.size())
                .flatMap(i -> filterPopulation.get(i).chars()
                        .mapToObj(c -> (char) c)
                        .map(c -> c == '1' ? CellState.create(1) : CellState.create(0)))
                .collect(Collectors.toList());

    }



}
