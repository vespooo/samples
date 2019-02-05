package datastracture;

import datastructures.Sorts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTests {

    private Sorts<Integer> sorts= new Sorts<>();


    @Test
    public void emptyArraySort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{});

        Assertions.assertArrayEquals(new Integer[]{}, arr);
    }
    @Test
    public void oneElementSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{5});

        Assertions.assertArrayEquals(new Integer[]{5}, arr);
    }

    @Test
    public void twoSortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{5, 6});

        Assertions.assertArrayEquals(new Integer[]{5,6}, arr);
    }

    @Test
    public void twoUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{5,3});

        Assertions.assertArrayEquals(new Integer[]{3,5}, arr);
    }

    @Test
    public void threeUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{3, 5,1});

        Assertions.assertArrayEquals(new Integer[]{1,3,5}, arr);
    }

    @Test
    public void fourUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{10, 1, 5,3});

        Assertions.assertArrayEquals(new Integer[]{1,3,5,10}, arr);
    }

    @Test
    public void oddUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{10, 1, 5,3, 9, 2, 7});

        Assertions.assertArrayEquals(new Integer[]{1,2,3,5,7,9,10}, arr);
    }

    @Test
    public void evenUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{10, 1, 5,3, 9, 2, 7, 4});

        Assertions.assertArrayEquals(new Integer[]{1,2,3,4,5,7,9,10}, arr);
    }

    @Test
    public void sortArrayWithZero(){
        Integer[] arr = sorts.quickSort(new  Integer[]{10, 1, 5,0, 9, 2, 7, 4});

        Assertions.assertArrayEquals(new Integer[]{0,1,2,4,5,7,9,10}, arr);
    }

    @Test
    public void negativeUnsortedElementsSort(){
        Integer[] arr = sorts.quickSort(new  Integer[]{10, -1, 5,3, -9, 2, 7, 4});

        Assertions.assertArrayEquals(new Integer[]{-9,-1,2,3,4,5,7,10}, arr);
    }
}
