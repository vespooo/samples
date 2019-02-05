package datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class MatrixGraph implements Graph<Integer>{
    private int count;
    private int edges[][];

    public MatrixGraph(int vertexCount) {
        this.count = vertexCount;
        this.edges = new int[count][count];
    }

    @Override
    public void addEdge(Integer source, Integer newVertex) {
        if (source>=count){
            if(source>newVertex) {
                count = source+1;
                edges= new int[count][count];
            } else {
                count = newVertex+1;
                edges= new int[count][count];
            }
        }
        edges[source][newVertex] =1;
    }

    @Override
    public void addVertex(Integer source) {
        if (source>=count){
            count = source+1;
            edges= new int[count][count];
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
            handling.accept(vertex);
            visited[vertex] = 1;
            for(int i=0; i<count; i++){
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
                if(visited[vertex]==0 && edges[vertex][i] ==1)
                    children.add(i);
            }

        }
    }



    @Override
    public List<Integer> getChildrenOf(Integer source) {
        return null;
    }
}
