package datastructures;

import java.util.LinkedList;

public class Queue<T> {
    private Node<T> last;
    private Node<T> first;
    private int size;

    public void enqueue(T value){
        Node<T> newNode = new Node<>(value, last);
        if (first == null){
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public T dequeue(){
        if (size > 0){
            Node<T> dequeue = first;
            first = first.previous;
            return dequeue.value;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private class Node<T>{
        private Node<T> previous;
        private T value;
        Node(T value, Node<T> last) {
            this.previous = last;
            this.value = value;
        }
    }
}
