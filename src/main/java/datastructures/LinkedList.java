package datastructures;

import java.util.function.Consumer;

public class LinkedList<T> {
    private Node<T> head;

    public T get(int index){
        Node<T> node = getNode(index);
        if (node != null)
            return node.value;
        throw new IndexOutOfBoundsException();
    }

    private Node<T> getNode(int index) {
        Node<T> node = head;
        if (node != null){
            for(int i=0; i<=index; i++){
                if (node.hasNext()){
                    node = node.next;
                } else{
                    throw new IndexOutOfBoundsException();
                }
            }
        }
        return node;
    }

    public void update(int index, T newValue){
        Node node = getNode(index);
        node.value = newValue;
    }

     public void insert(int index, T value){
        Node<T> node = getNode(index-1);
        Node<T> nextNode = node.next;
        node.next = new Node<>(value);
        node.next.next = nextNode;
     }

     public void delete(int index){
         Node<T> node = getNode(index);
         node.next = node.next.next;
     }

    public T search(T value){
        Node<T> node = head;
        if (node != null){
            while (node.hasNext()){
                node = node.next;
                if(value.equals(node.value))
                    return node.value;
            }
        }
        return null;
    }
    public void traverse(Consumer<Node<T>> runnable){
        Node<T> node = head;
        if (node != null){
            while (node.hasNext()){
                node = node.next;
                runnable.accept(node);
            }
        }
    }
    public void reverse(){
        Node lastReversed = head;
        Node firstUnreversed = lastReversed.next;
        while (lastReversed.hasNext()){
            Node secondUnreversed = firstUnreversed.next;
            firstUnreversed.next = lastReversed;
            lastReversed = firstUnreversed;
            firstUnreversed = secondUnreversed;
        }
    }
    private class Node<T>{
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }

        boolean hasNext() {
            if(next != null)
                return true;
            return false;
        }
    }

}


