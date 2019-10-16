package samples.tictactoe;

public class CellRow {
    private Cell[] row;

    public CellRow(Cell cell1, Cell cell2, Cell cell3) {
        this.row = new Cell[3];
        this.row[0] = cell1;
        this.row[1] = cell2;
        this.row[2] = cell3;
    }

    public boolean check() {
        boolean isSame = true;
        for (int i=1 ; i<3; i++){
            if (row[0].getSign().getValue() != row[i].getSign().getValue())
                return false;
        }
        return true;
    }
}
