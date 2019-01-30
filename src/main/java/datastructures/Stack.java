package datastructures;

public class Stack<T> {
    private Node<T> top;

    public void push(T value){
        Node<T> newTop = new Node<>(value);
        newTop.prev = top;
        top = newTop;
    }

    public T pop(){
        T popValue = top.prev.value;
        top = top.prev;
        return popValue;
    }
    private class Node<T>{
        Node<T> prev;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
