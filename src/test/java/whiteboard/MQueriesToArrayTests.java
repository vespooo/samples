package whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MQueriesToArrayTests {

    @Test
    public void resolveOpsWithWrongFormatTest(){
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[][] ops = {{1,1}};
        Assertions.assertThrows(MQueriesToArray.WrongOperationFormatException.class, () ->arr.resolveQueries(ops));
    }

    @Test
    public void resolveOpsWithWrongElementNumberTest(){
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[] op = {1,10, 3};
        Assertions.assertThrows(MQueriesToArray.WrongElementNumberException.class, () ->arr.executeOP(op));
    }

    @Test
    public void resolveOpsWithWrongTypeTest(){
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[] op = {3,1, 3};
        Assertions.assertThrows(MQueriesToArray.WrongOperationTypeException.class, () ->arr.executeOP(op));
    }

    @Test
    public void resolveOpType1iLessThenjTest() throws MQueriesToArray.WrongOperationTypeException, MQueriesToArray.WrongElementNumberException, MQueriesToArray.WrongOperationFormatException {
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[][] ops = {{1,3, 5}};

        int[] result = {3, 5, 0, 1, 2, 4, 6};
        Assertions.assertArrayEquals(result, arr.resolveQueries(ops));
    }

    @Test
    public void resolveOpType1iMoreThenjTest() throws MQueriesToArray.WrongOperationTypeException, MQueriesToArray.WrongElementNumberException, MQueriesToArray.WrongOperationFormatException {
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[][] ops = {{1,5, 3}};

        int[] result = {5, 3, 0, 1, 2, 4, 6};
        Assertions.assertArrayEquals(result, arr.resolveQueries(ops));
    }

    @Test
    public void resolveOpType1iEqualTojTest() throws MQueriesToArray.WrongOperationTypeException, MQueriesToArray.WrongElementNumberException, MQueriesToArray.WrongOperationFormatException {
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[][] ops = {{1,5, 5}};

        int[] result = {5, 0, 1, 2, 3, 4, 6};
        Assertions.assertArrayEquals(result, arr.resolveQueries(ops));
    }

    @Test
    public void resolveOpType1TwoOperationsTest() throws MQueriesToArray.WrongOperationTypeException, MQueriesToArray.WrongElementNumberException, MQueriesToArray.WrongOperationFormatException {
        int[] startArr = {0,1,2,3,4,5,6};
        MQueriesToArray arr = new MQueriesToArray(startArr);
        int[][] ops = {{1,3, 5}, {1, 3, 5}};

        int[] result = {1, 4, 3, 5, 0, 2, 6};
        Assertions.assertArrayEquals(result, arr.resolveQueries(ops));
    }
}
