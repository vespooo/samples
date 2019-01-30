package datastracture;

import datastructures.Searches;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchesTest {

    @Test
    public void binarySearchIntoEmptyArrayTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{}, 1)==-1);
    }


    @Test
    public void binarySearchIntoOneElementArrayNotFoundTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{2}, 1)==-1);
    }

    @Test
    public void binarySearchIntoOneElementArrayWithPresentSearchedElementTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{1}, 1)==0);
    }

    @Test
    public void binarySearchIntoTwoElementArrayWithNoPresentSearchedElementTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{0,2}, 1)==-1);
    }
    @Test
    public void binarySearchIntoTwoElementArrayWithPresentSearchedElementInLeftSideTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{1,2}, 1)==0);
    }
    @Test
    public void binarySearchIntoTwoElementArrayWithPresentSearchedElementInRightSideTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{0,1}, 1)==1);
    }


    @Test
    public void binarySearchIntoThreeElementArrayWithNoPresentSearchedElementTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{0,2,3}, 1)==-1);
    }
    @Test
    public void binarySearchIntoThreeElementArrayWithPresentSearchedElementInLeftSideTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{1,2,3}, 1)==0);
    }
    @Test
    public void binarySearchIntoThreeElementArrayWithPresentSearchedElementInRightSideTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{0,1, 2}, 2)==2);
    }
    @Test
    public void binarySearchIntoThreeElementArrayWithPresentSearchedElementInTheMiddleTest(){
        Searches<Integer> searches = new Searches<>();
        Assertions.assertTrue(searches.binarySearch(new Integer[]{0,1, 2}, 1)==1);
    }
}
