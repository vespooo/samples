package datastracture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTest {


    @Test void testSearchInEmptyList(){
        Integer index = search(Arrays.asList(), 10, 0, -1);
        Assertions.assertTrue(index == null);
    }

    @Test void testSearchWithOneElNotFound(){
        Integer index = search(Arrays.asList(1), 10, 0, -1);
        Assertions.assertTrue(index == null);
    }

    @Test void testSearchWithOneElFound(){
        Integer index = search(Arrays.asList(10), 10, 0, 0);
        Assertions.assertTrue(index == 0);
    }


    @Test void testSearchWithTwoElNotFound(){
        Integer index = search(Arrays.asList(1,2), 10, 0, 1);
        Assertions.assertTrue(index == null);
    }

    @Test void testSearchWithTwoElNotFound2(){
        Integer index = search(Arrays.asList(100,200), 10, 0, 1);
        Assertions.assertTrue(index == null);
    }

    @Test void testSearchWithTwoElFound(){
        Integer index = search(Arrays.asList(10,20), 10, 0, 1);
        Assertions.assertTrue(index == 0);
    }

    @Test void testSearchWithTwoElFound2(){
        Integer index = search(Arrays.asList(5,10), 10, 0, 1);
        Assertions.assertTrue(index == 1);
    }

    public static Integer search(List<Integer> list, int el, int begin, int end){
        if (begin <= end){
            int mid = begin + (end-begin)/2;
            if(list.get(mid).equals(el)){
                return mid;
            }else if (list.get(mid)> el){
                return search(list, el, begin, mid-1);
            } else {
                return search(list, el, mid+1, end);
            }
        }
        return null;
    }

}
