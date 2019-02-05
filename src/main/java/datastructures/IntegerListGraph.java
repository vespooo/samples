package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class IntegerListGraph implements Graph<Integer> {
    private int count;
    private List<Integer> edges[];

    public IntegerListGraph(int vertexCount) {
        this.count = vertexCount;
        this.edges = new ArrayList[vertexCount];
        initLists();
    }

    private void initLists() {
        for(int i=0; i<count; i++){
            List<Integer> list = edges[i];
            if(list == null){
                edges[i] = new ArrayList<>();
            }
        }
    }

    @Override
    public void addEdge(Integer source, Integer newVertex) {
        if(source>=count || newVertex >= count){
            if (source>newVertex){
                count = source+1;
            }else{
                count = newVertex+1;
            }
            extendArray();
        }
        List<Integer> vertexAdjacency = edges[source];
        if (vertexAdjacency == null) {
            vertexAdjacency = new ArrayList<>();
        }
        vertexAdjacency.add(newVertex);
        edges[source] = vertexAdjacency;
    }

    private void extendArray() {
        edges = Arrays.copyOf(edges, count);
        initLists();
    }

    @Override
    public void addVertex(Integer source) {
        if(source >= count) count = source+1;
        extendArray();
    }

    @Override
    public void dfsRecursively(Consumer<Integer> handling, Integer root) {
        int[] visited = new int[count];
        dfs(handling, root, visited);
    }

    private void dfs(Consumer<Integer> handling, Integer root, int[] visited) {
        if(visited[root] == 0) {
            handling.accept(root);
            visited[root] = 1;
        }
        for (int vertex : edges[root]){
            if(visited[vertex] == 0)dfs(handling, vertex, visited);
        }
    }

    @Override
    public void dfsIteratively(Consumer<Integer> handling, Integer root) {
        int[] visited = new int[count];
        Stack<Integer> path = new Stack<>();
        path.push(root);
        while (!path.isEmpty()){
            int vertex = path.pop();
            if(visited[vertex] == 0){
                handling.accept(vertex);
                visited[vertex] = 1;
            }
            List<Integer> children = edges[vertex];
            for(int i=children.size()-1; i>=0; i--){
                Integer child = children.get(i);
                if(child!=null && visited[child] == 0) path.push(child);
            }
        }
    }

    @Override
    public void bfs(Consumer<Integer> handling, Integer root) {
        java.util.Queue<Integer> path = new java.util.LinkedList<>();
        int[] visited = new int[count];
        path.add(root);
        while (!path.isEmpty()){
            int vertex = path.remove();
            if(visited[vertex] == 0) handling.accept(vertex);
            visited[vertex] =1;
            path.addAll(edges[vertex].stream().filter(e -> visited[e] == 0).collect(Collectors.toList()));
        }

    }

    @Override
    public List<Integer> getChildrenOf(Integer source) {
        if (source< count)
            return edges[source];
        return null;
    }
}
