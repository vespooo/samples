package anton.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellRowTest {


    @Test
    public void threeSimilarSignInARow() throws IllegalSignInsertion, GameOver {
        CellCreator creator = new CellCreator();
        Cell[][] cells = creator.create();
        CellRowAggregator cellRows = new CellRowAggregator(cells);

        Signs signs = new Signs();
        cells[0][0].setSign(signs.getX());
        cells[0][1].setSign(signs.getX());
        Assertions.assertThrows(GameOver.class, () -> cells[0][2].setSign(signs.getX()));
    }
}
