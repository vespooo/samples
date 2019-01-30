package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Tree<T> {
    private Node<T> root;

    public Tree(T value) {
        this.root = new Node<>(value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void DFTraverse(DFType dfType, Consumer<T> vertexHandling){
        DFS(dfType,root, vertexHandling);
    }

    private void DFS(DFType dfType, Node<T> node, Consumer<T> vertexHandling) {

        if(dfType == DFType.PREORDER) vertexHandling.accept(node.value);
        
        for (Node<T> t: node.children){
            DFS(dfType, t, vertexHandling);
        }

        if(dfType == DFType.POSTORDER) vertexHandling.accept(node.value);
    }

    public void BFTraverse(Consumer<T> vertexHandling){
        vertexHandling.accept(this.root.value);
        BFS(this.root.children, vertexHandling);
    }

    private void BFS(List<Node<T>> children, Consumer<T> vertexHandling) {

        if (!children.isEmpty()){
            for(Node<T> t: children){
                vertexHandling.accept(t.value);
            }
            List<Node<T>> childrenOfChildren = new ArrayList<>();
            for(Node<T> node : children){
                childrenOfChildren.addAll(node.children);
            }
            BFS(childrenOfChildren, vertexHandling);
        }
    }

    public enum DFType{
        PREORDER, POSTORDER;
    }

    public class Node<T> {
        private T value;
        private List<Node<T>> children;

        public Node(T value) {
            this.value = value;
            children = new ArrayList<>();
        }

        public Node<T> addChild(T value){
            Node<T> child = new Node<>(value);
            children.add(child);
            return child;
        }
    }
}
