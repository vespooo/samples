package datastructures;

public class SampleLinkedList<T> {
    private Node head;
    private int size;

    public void add(T o) {
        Node newNode = new Node(o);
        if (head == null){
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        while (current.next!= null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public T get(int index) throws OutOfBounds {
        Node current = head;
        if (index<0 || index>=size){
            throw new OutOfBounds();
        }
        for(int i=0; i<index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public void remove(T o) {
        Node current = head;
        if(head == null)
            return;
        if(current.data.equals(o)){
            head = current.next;
            size--;
            return;
        }
        while (current.next != null){
            if(current.next.data.equals(o)){
                current.next=current.next.next;
                size--;
                return;
            }
        }
    }

    public boolean contains(T o) {
        Node current = head;
        if(get(o) != null){
            return true;
        }
        return false;
    }

    private Node get(T o) {
        Node current = head;
        while (current!= null){
            if (current.data.equals(o)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private class Node{
        T data;
        Node next;

        public Node(T o) {
            data = o;
        }
    }
}
