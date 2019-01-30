package anton.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class CellRowAggregator {
    private List<CellRow> cellRows;

    public CellRowAggregator(Cell[][] cells) {
        this.cellRows = new ArrayList<>();
        cellRows.add(new CellRow(cells[0][0], cells[0][1], cells[0][2]));
        cellRows.add(new CellRow(cells[1][0], cells[1][1], cells[1][2]));
        cellRows.add(new CellRow(cells[2][0], cells[2][1], cells[2][2]));

        cellRows.add(new CellRow(cells[0][0], cells[1][0], cells[2][0]));
        cellRows.add(new CellRow(cells[0][1], cells[1][1], cells[2][1]));
        cellRows.add(new CellRow(cells[0][2], cells[1][2], cells[2][2]));

        cellRows.add(new CellRow(cells[0][0], cells[1][1], cells[2][2]));
        cellRows.add(new CellRow(cells[0][2], cells[1][1], cells[2][0]));
        for(Cell[] row : cells){
            for (Cell cell : row){
                cell.addEndOfGameHandler(() -> check());
            }
        }
    }

    private void add(CellRow cellRow) {
        cellRows.add(cellRow);
    }

    private boolean check(){
        return cellRows.stream().anyMatch(cellRow -> cellRow.check());
    }
}
