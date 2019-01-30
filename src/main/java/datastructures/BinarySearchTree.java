package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {

    public static final String NULL_INSERTION_ERROR_MESSAGE = "Null is not allowed to insert";
    public static final String DUPLICATES_INSERTION_ERROR_MESSAGE = "Duplicates are not allowed";
    private Node<T> root;

    public void insert(T value){
        if (value == null) throw new IllegalArgumentException(NULL_INSERTION_ERROR_MESSAGE);
        root = insert(value, this.root);
     }

    private Node<T> insert(T value, Node<T> root) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        if (value.compareTo(root.value)==0) throw new IllegalArgumentException(DUPLICATES_INSERTION_ERROR_MESSAGE);
        if (value.compareTo(root.value)<0){
            root.left = insert(value, root.left);
        } else {
            root.right = insert(value, root.right);
        }
        return root;
    }

    public void delete(T value){ root = delete(value, root); }
    private Node<T> delete(T value, Node<T> root) {
        if(root == null) return root;
        if(value.compareTo(root.value)<0){
            root.left = delete(value, root.left);
        }else if(value.compareTo(root.value)>0){
            root.right = delete(value, root.right);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            root.value = minRight(root.right);
            root.right = delete(root.value, root.right);
        }
        return root;
    }

    private T minRight(Node<T> tree) {
        while (tree.left !=null){
            tree = tree.left;
        }
        return tree.value;
    }

    public List<T> preOrderDFS(Consumer<T> vertexHandling){
         List<T> list = new ArrayList<>();
         return list;
     }

    public Node<T> getRoot() {
        return root;
    }

    public  class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T key) {
            this.value = key;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }
    }
}
