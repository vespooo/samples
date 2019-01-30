package datastracture;

import datastructures.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void emptyQueueTest(){
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(0==q.size());
    }

    @Test
    public void enqueueTest(){
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        Assertions.assertTrue(1==q.size());
    }

    @Test
    public void emptyDequeueTest(){
        Queue<Integer> q = new Queue<>();
        Assertions.assertNull(q.dequeue());
    }

    @Test
    public void dequeueTest(){
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        Assertions.assertEquals(new Integer(1), q.dequeue());
    }
}
