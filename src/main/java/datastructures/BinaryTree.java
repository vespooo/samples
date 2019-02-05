package datastructures;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
        Node<T> node = findNodeByCondition((e) -> e.left == null || e.right == null);

        if(node.left == null){
            node.left = new Node<>(value);
        } else {
            node.right = new Node<>(value);
        }
    }

    public void delete(T value){
        Node<T> deletingParentNode = findParent(value);
        Node<T> rightestNode = new Node<>(null);
        inOrderRecursiveDFS((node)->rightestNode.value = node.value);
        if (rightestNode.value != null)  {
            Node<T> rightestParentNode = findParent(rightestNode.value);
            if(deletingParentNode == null){
                if (value.equals(root.value)){
                    if (rightestParentNode != null) {
                        Node<T> newNode = extractRightestNode(rightestNode, rightestParentNode);
                        newNode.left = root.left;
                        newNode.right = root.right;
                        root = newNode;
                    } else {
                        if(root.left != null) root = root.left;
                        else root = null;
                    }
                }
            }
            if(deletingParentNode != null && rightestParentNode != null){
                Node<T> newNode = extractRightestNode(rightestNode, rightestParentNode);
                if(!rightestNode.value.equals(value)){
                    replaceDeletingNodeWithRightest(value, deletingParentNode, newNode);
                }
            }
        }
    }

    private void replaceDeletingNodeWithRightest(T value, Node<T> deletingParentNode, Node<T> newNode) {
        if(deletingParentNode.left != null && value.equals(deletingParentNode.left.value)){
            newNode.left = deletingParentNode.left.left;
            newNode.right = deletingParentNode.left.right;
            deletingParentNode.left = newNode;
        } else {
            newNode.left = deletingParentNode.right.left;
            newNode.right = deletingParentNode.right.right;
            deletingParentNode.right = newNode;
        }
    }

    private Node<T> extractRightestNode(Node<T> rightestNode, Node<T> rightestParentNode) {
        Node<T> newNode = null;
        if (rightestParentNode.left != null && rightestNode.value.equals(rightestParentNode.left.value)){
            newNode = rightestParentNode.left;
            rightestParentNode.left = null;
        } else {
            newNode = rightestParentNode.right;
            rightestParentNode.right = null;
        }
        return newNode;
    }

    private Node<T> findParent(T value) {
        List<Node<T>> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Node<T>> nextLevelNodes = new ArrayList<>();
            for(Node<T> node : nodes){
                if((node.left != null && value.equals(node.left.value))
                        || (node.right != null && value.equals(node.right.value))) return node;
                else{
                    if (node.left != null) nextLevelNodes.add(node.left);
                    if (node.right != null) nextLevelNodes.add(node.right);
                }
            }
            nodes = nextLevelNodes;
        }
        return null;
    }

    private Node<T> findNodeByCondition(Predicate<Node<T>> exitCondition){
        Stack<Node<T>> path = new Stack<>();
        path.push(root);
        while (!path.empty()){
            Node<T> node = path.peek();
            if(exitCondition.test(node)) return node;
            preOrderIterativeDFS(path, node, e->{});
        }
        return null;
    }


    public void iterativeDFS(Consumer<Node<T>> handling, ORDER order) {
        Stack<Node<T>> path = new Stack<>();
        path.push(root);
        Set<Node<T>> visited = new HashSet<>();
        while (!path.empty()){
            Node<T> node = path.peek();

            if (ORDER.PREORDER == order) {
                preOrderIterativeDFS(path, node, handling);
            }
            if (ORDER.INORDER == order){
                inOrderIterativeDFS(path, visited, node, handling);
            }
            if (ORDER.POSTORDER == order){
                postOrderIterativeDFS(path, visited, node, handling);
            }
            visited.add(node);
        }
    }

    private void preOrderIterativeDFS(Stack<Node<T>> path, Node<T> node, Consumer<Node<T>> handling){
        handling.accept(node);
        path.pop();
        if (node.right != null) path.push(node.right);
        if (node.left != null) path.push(node.left);
    }

    private void inOrderIterativeDFS(Stack<Node<T>> path, Set<Node<T>> visited, Node<T> node, Consumer<Node<T>> handling) {
        if (visited.contains(node)){
            handling.accept(node);
            path.pop();
            if(node.right != null) path.push(node.right);
        } else if(node.left != null) path.push(node.left);
    }

    private void postOrderIterativeDFS(Stack<Node<T>> path, Set<Node<T>> visited, Node<T> node, Consumer<Node<T>> handling) {
        if (visited.contains(node)){
            if(node.right != null && !visited.contains(node.right)) path.push(node.right);
            else {
                handling.accept(node);
                path.pop();
            }
        } else if(node.left != null) path.push(node.left);
    }

    public void dfsRecursively(Node<T> node, Consumer<Node<T>> searchedNode, Consumer<Node<T>> handling, ORDER order){
        searchedNode.accept(node);

        if (ORDER.PREORDER == order) handling.accept(node);
        if (node.left != null) dfsRecursively(node.left, searchedNode, handling, order);
        if (ORDER.INORDER == order) handling.accept(node);
        if (node.right != null) dfsRecursively(node.right, searchedNode, handling, order);
        if (ORDER.POSTORDER == order) handling.accept(node);
    }

    public void preOrderRecursiveDFS(Consumer<Node<T>> handling){
        dfsRecursively(root, (e) -> {}, handling, ORDER.PREORDER);
    }

    public void inOrderRecursiveDFS(Consumer<Node<T>> handling){
        dfsRecursively(root, (e) -> {}, handling, ORDER.INORDER);
    }

    public void postOrderRecursiveDFS(Consumer<Node<T>> handling){
        dfsRecursively(root, (e) -> {}, handling, ORDER.POSTORDER);
    }

    public void bfs( Consumer<T> handling){

        List<Node<T>> nodes = new ArrayList<>();
        nodes.add(root);
        bfsRecursively(handling, nodes);
    }

    public void iterativeBFS( Consumer<T> handling){
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node<T> node = nodes.remove();
            handling.accept(node.value);
            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }
    }

    private void bfsRecursively(Consumer<T> handling, List<Node<T>> nodes) {
        if (nodes.isEmpty()) return;
        List<Node<T>> nextLevelNodes = new ArrayList<>();
        for(Node<T> node : nodes){
            handling.accept(node.value);
            if (node.left != null) nextLevelNodes.add(node.left);
            if (node.right != null) nextLevelNodes.add(node.right);
        }
        bfsRecursively(handling, nextLevelNodes);
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
                return right.insertRight(value);
            }
            return right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public enum ORDER {
        PREORDER, POSTORDER, INORDER
    }
}
