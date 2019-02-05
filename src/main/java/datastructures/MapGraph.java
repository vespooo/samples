package datastructures;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class MapGraph<T> implements Graph<T>{

    private int count;
    private Map<T, List<T>> edges;

    public MapGraph() {
        this.edges = new HashMap();
    }

    @Override
    public void addEdge(T source, T newVertex) {
        List<T> vertexAdjacency = edges.get(source);
        if (vertexAdjacency == null){
            vertexAdjacency = new ArrayList<>();
        }
        vertexAdjacency.add(newVertex);
        edges.put(source, vertexAdjacency);
        count++;
    }

    @Override
    public void addVertex(T source) {
        edges.put(source, new ArrayList<>());
    }

    @Override
    public void dfsRecursively(Consumer<T> handling, T root) {
        Set<T> visited = new HashSet<>();
        dfsRecursion(handling, root, visited);
    }

    private void dfsRecursion(Consumer<T> handling, T root, Set<T> visited) {
        if(visited.contains(root)) return;
        handling.accept(root);
        visited.add(root);
        List<T> children = edges.get(root);
        if(children != null){
            for(T child : children){
                dfsRecursion(handling,child, visited);
            }
        }
    }

    @Override
    public void dfsIteratively(Consumer<T> handling, T root) {
        Set<T> visited = new HashSet<>();
        Stack<T> path = new Stack<>();
        path.push(root);
        while (!path.isEmpty()){
            T vertex = path.pop();
            if(visited.contains(vertex)) continue;;
            handling.accept(vertex);
            visited.add(vertex);
            List<T> children = edges.get(vertex);
            if(children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    path.push(children.get(i));
                }
            }
        }
    }

    @Override
    public void bfs(Consumer<T> handling, T root) {
        Set<T> visited = new HashSet<>();
        Queue<T> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            T vertex = q.remove();
            if(visited.contains(vertex)) continue;
            handling.accept(vertex);
            List<T> children = edges.get(vertex);
            if(children != null) q.addAll(children);
            visited.add(vertex);
        }
    }

    @Override
    public List<T> getChildrenOf(T source) {
        return edges.get(source);
    }
}
