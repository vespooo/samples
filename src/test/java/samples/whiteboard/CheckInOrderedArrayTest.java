package samples.whiteboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckInOrderedArrayTest {

    private CheckInOrderedArray checker;
    @BeforeEach
    public void before(){
        checker = new CheckInOrderedArray();
    }

    @Test
    public void checkElementNotInOneElementArray(){
       Assertions.assertFalse(checker.checkElementInArray(2, new int[]{1}));
    }

    @Test
    public void checkElementNotInOneElementArrayRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(2, new int[]{1}));
    }

    @Test
    public void checkElementInOneElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(2, new int[]{2}));
    }

    @Test
    public void checkElementInOneElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(2, new int[]{2}));
    }


    @Test
    public void checkBiggerElementNotInTwoElementArray(){
        Assertions.assertFalse(checker.checkElementInArray(4, new int[]{1, 3}));
    }

    @Test
    public void checkBiggerElementNotInTwoElementArrayRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(4, new int[]{1, 3}));
    }


    @Test
    public void checkSmallerElementNotInTwoElementArray(){
        Assertions.assertFalse(checker.checkElementInArray(1, new int[]{2, 3}));
    }

    @Test
    public void checkSmallerElementNotInTwoElementArrayRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(1, new int[]{2, 3}));
    }


    @Test
    public void checkElementBetweenTwoArrayElements(){
        Assertions.assertFalse(checker.checkElementInArray(2, new int[]{1, 3}));
    }

    @Test
    public void checkElementBetweenTwoArrayElementsRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(2, new int[]{1, 3}));
    }

    @Test
    public void checkBiggerElementInTwoElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(3, new int[]{1, 3}));
    }

    @Test
    public void checkBiggerElementInTwoElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(3, new int[]{1, 3}));
    }


    @Test
    public void checkSmallerElementInTwoElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(2, new int[]{2, 3}));
    }

    @Test
    public void checkSmallerElementInTwoElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(2, new int[]{2, 3}));
    }

    @Test
    public void checkBiggerElementNotInThreeElementArray(){
        Assertions.assertFalse(checker.checkElementInArray(5, new int[]{1, 3, 4}));
    }

    @Test
    public void checkBiggerElementNotInThreeElementArrayRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(5, new int[]{1, 3, 4}));
    }


    @Test
    public void checkSmallerElementNotInThreeElementArray(){
        Assertions.assertFalse(checker.checkElementInArray(1, new int[]{2, 3, 4}));
    }

    @Test
    public void checkSmallerElementNotInThreeElementArrayRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(1, new int[]{2, 3, 4}));
    }

    @Test
    public void checkElementBetweenThreeArrayElements(){
        Assertions.assertFalse(checker.checkElementInArray(2, new int[]{1, 3, 4}));
    }

    @Test
    public void checkElementBetweenThreeArrayElementsRecursive(){
        Assertions.assertFalse(checker.checkElementInArrayRecursive(2, new int[]{1, 3, 4}));
    }

    @Test
    public void checkBiggerElementInThreeElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(4, new int[]{1, 3, 4}));
    }

    @Test
    public void checkBiggerElementInThreeElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(4, new int[]{1, 3, 4}));
    }


    @Test
    public void checkSmallerElementInThreeElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(2, new int[]{2, 3, 4}));
    }

    @Test
    public void checkSmallerElementInThreeElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(2, new int[]{2, 3, 4}));
    }

    @Test
    public void checkElementInTheMiddleThreeArrayElements(){
        Assertions.assertTrue(checker.checkElementInArray(3, new int[]{1, 3, 4}));
    }

    @Test
    public void checkElementInTheMiddleThreeArrayElementsRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(3, new int[]{1, 3, 4}));
    }

    @Test
    public void checkBiggerElementInFourElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(4, new int[]{1, 3, 4, 6}));
    }

    @Test
    public void checkBiggerElementInFourElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(4, new int[]{1, 3, 4, 6}));
    }


    @Test
    public void checkSmallerElementInFourElementArray(){
        Assertions.assertTrue(checker.checkElementInArray(3, new int[]{2, 3, 4, 6}));
    }

    @Test
    public void checkSmallerElementInFourElementArrayRecursive(){
        Assertions.assertTrue(checker.checkElementInArrayRecursive(3, new int[]{2, 3, 4, 6}));
    }
}
