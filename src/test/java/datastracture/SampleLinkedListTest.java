package datastracture;

import datastructures.OutOfBounds;
import datastructures.SampleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SampleLinkedListTest {
    @Test
    public void testAdd(){
        SampleLinkedList<Integer> list = new SampleLinkedList<>();
        Integer o = 1;
        list.add(o);
        Assertions.assertEquals(o, list.get(0));
    }

    @Test
    public void testAddNull(){
        SampleLinkedList<Integer> list = new SampleLinkedList<>();
        list.add(null);
        Assertions.assertNull(list.get(0));
    }

    @Test
    public void testGetOutOfBounds(){
        SampleLinkedList<String> list = new SampleLinkedList<>();
        Assertions.assertThrows(OutOfBounds.class, ()->list.get(0));
        list.add("hhh");
        Assertions.assertThrows(OutOfBounds.class, ()->list.get(1));
        Assertions.assertThrows(OutOfBounds.class, ()->list.get(-1));
    }

    @Test
    public void testSize(){
        SampleLinkedList<Integer> list = new SampleLinkedList<>();
        Assertions.assertEquals(0, list.size());
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }
    @Test
    public void testRemoveFromNullList(){
        SampleLinkedList<String> list = new SampleLinkedList<>();
        String o = "hgjh";
        list.remove(o);
        Assertions.assertEquals(0, list.size());
     }

    @Test
    public void testRemove(){
        SampleLinkedList<Integer> list = new SampleLinkedList<>();
        Integer o = 1;
        list.add(o);
        list.remove(o);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveNotContains(){
        SampleLinkedList<Integer> list = new SampleLinkedList<>();
        Integer o1 = 1;
        Integer o2 = 2;
        list.add(o1);
        list.remove(o2);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(o1, list.get(0));
    }

    @Test
    public void testListContains(){
        List<Integer> list = new ArrayList<>();
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        list.add(i1);
        list.stream().filter(e -> e.equals("")).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        map.entrySet().stream().map(Map.Entry :: getKey).collect(Collectors.toMap(e -> e, e -> e));
        Assertions.assertTrue(list.contains(i2));
    }


    @Test
    public void testListRemove(){
        List<Integer> list = new ArrayList<>();
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        list.add(i1);
        Assertions.assertTrue(list.remove(i2));
    }

    @Test
    public void testContainsInNullList(){
        SampleLinkedList list = new SampleLinkedList();
        Object o = new Object();
        Assertions.assertFalse(list.contains(o));
    }

    @Test
    public void testContainsInListWithOnlyOne(){
        SampleLinkedList list = new SampleLinkedList();
        Object o = new Object();
        list.add(o);
        Assertions.assertTrue(list.contains(o));
    }

    @Test
    public void testContainsInListWithMoreThenOne(){
        SampleLinkedList list = new SampleLinkedList();
        Object o1 = new Object();
        Object o2 = new Object();
        list.add(o1);
        list.add(o2);
        Assertions.assertTrue(list.contains(o2));
    }

    @Test
    public void testContainsInListWithNullElement(){
        SampleLinkedList list = new SampleLinkedList();
        Object o1 = new Object();
        list.add(o1);
        list.add(null);
        Assertions.assertTrue(list.contains(o1));
    }

    @Test
    public void testNotContains(){
        SampleLinkedList list = new SampleLinkedList();
        Object o1 = new Object();
        Object o2 = new Object();
        list.add(o1);
        Assertions.assertFalse(list.contains(o2));
    }
}
