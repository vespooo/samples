package datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MatrixGraph implements Graph<Integer>{
    private int count;
    private int edges[][];

    public MatrixGraph(int vertexCount) {
        this.count = vertexCount;
        this.edges = new int[count][count];
    }

    @Override
    public void addEdge(Integer source, Integer newVertex) {
        if (source>=count || newVertex>=count){
            if(source>newVertex) {
                count = source+1;
            } else {
                count = newVertex+1;
            }
            extendArray();
        }
        edges[source][newVertex] =1;
    }

    private void extendArray() {
        int[][] temp = edges;
        edges = new int[count][count];
        for(int i=0; i<temp.length; i++){
            edges[i]= Arrays.copyOf(temp[i], count);
        }
    }

    @Override
    public void addVertex(Integer source) {
        if (source>=count){
            count = source+1;
            extendArray();
        }
    }

    @Override
    public void dfsRecursively(Consumer<Integer> handling, Integer root) {
        int[] visited = new int[count];
        dfs(handling, root, visited);
    }

    private void dfs(Consumer<Integer> handling, Integer root, int[] visited) {
        handling.accept(root);
        visited[root] = 1;
        int[] children = edges[root];
        for(int i=0; i<count; i++){
            if (children[i] == 1 && visited[i]==0){
                dfs(handling, i,visited);
            }
        }
    }

    @Override
    public void dfsIteratively(Consumer<Integer> handling, Integer root) {
        int[] visited = new int[count];
        java.util.Stack<Integer> path = new java.util.Stack<>();
        path.push(root);
        while (!path.isEmpty()){
            Integer vertex = path.pop();
            if (visited[vertex] ==0) handling.accept(vertex);
            visited[vertex] = 1;
            for(int i=count-1; i>=0; i--){
                if(edges[vertex][i] == 1 && visited[i] == 0){
                    path.push(i);
                }
            }
        }
    }

    public void bfs(Consumer<Integer> handling, Integer root) {
        int[] visited = new int[count];
        Queue<Integer> children = new LinkedList<>();
        children.add(root);
        while (!children.isEmpty()){
            int vertex = children.remove();
            handling.accept(vertex);
            visited[vertex] = 1;
            for(int i=0; i<count; i++){
                if(visited[i]==0 && edges[vertex][i] ==1)
                    children.add(i);
            }

        }
    }



    @Override
    public List<Integer> getChildrenOf(Integer source) {
        if (source<count)
            return Arrays.stream(edges[source]).boxed().collect(Collectors.toList());
        return null;
    }
}
