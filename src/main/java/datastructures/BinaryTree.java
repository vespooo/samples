package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BinaryTree<T> {
    private  Node<T> root;

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }

    public Node<T> insertLeft(T value){
        return this.root.insertLeft(value);
    }

    public Node<T>  insertRight(T value){
        return this.root.insertRight(value);
    }

    public void insert(T value){

        Node<T> node = dfsRecursively(root, (e) -> e.left == null || e.right == null, (e) -> {});

        if(node.left == null){
            node.left = new Node<>(value);
        } else {
            node.right = new Node<>(value);
        }
    }

    public Node<T> dfsRecursively(Node<T> node, Predicate<Node<T>> exitCondition, Consumer<Node<T>> handling){
        if (exitCondition.test(node)) return node;
        if (node.left != null) return dfsRecursively(node.left, exitCondition, handling);
        handling.accept(node);
        if(node.right != null) return dfsRecursively(node.right, exitCondition, handling);
        return node;
    }

    public void preOrderDFTraverseRecursively(Consumer<Node<T>> handling){
        dfsRecursively(root, (e) -> false, handling);
    }

    public Node<T> bfs(List<Node<T>> nodes, Predicate<Node<T>> exitCondition, Consumer<T> handling){
        if (nodes.isEmpty()) return null;
        List<Node<T>> nextLevelNodes = new ArrayList<>();
        for(Node<T> node : nodes){
            if(exitCondition.test(node)) return node;
            handling.accept(node.value);
            if (node.left != null) nextLevelNodes.add(node.left);
            if (node.right != null) nextLevelNodes.add(node.right);
        }
        return bfs(nextLevelNodes, exitCondition, handling);
    }

    public Node<T> getRoot() {
        return root;
    }

    public class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
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

        public Node<T> insertLeft(T value) {
            if (left == null){
                left = new Node<>(value);
            } else {
               return left.insertLeft(value);
            }
            return left;
        }

        public Node<T> insertRight(T value) {
            if (right == null){
                right = new Node<>(value);
            }else {
                return insertRight(value);
            }
            return right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
