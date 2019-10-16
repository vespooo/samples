package samples.tictactoe;

import java.util.Arrays;

public class CellCreator {

    public Cell[][] create() {
        Cell[][] cells = new Cell[3][3];
        Signs signs = new Signs();
        for(Cell[] row: cells){

            Arrays.fill(row, new Cell(signs.getEmpty()));
        }

        return cells;
    }
}
