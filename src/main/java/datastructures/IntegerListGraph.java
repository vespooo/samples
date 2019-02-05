package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IntegerListGraph implements Graph<Integer> {
    private int count;
    private List<Integer> edges[];

    public IntegerListGraph(int vertexCount) {
        this.count = vertexCount;
        this.edges = new ArrayList[vertexCount];
    }

    @Override
    public void addEdge(Integer source, Integer newVertex) {
        List<Integer> vertexAdjacency = edges[source];
        if (vertexAdjacency == null) {
            vertexAdjacency = new ArrayList<>();
        }
        vertexAdjacency.add(newVertex);
        edges[source] = vertexAdjacency;
    }

    @Override
    public void addVertex(Integer source) {

    }

    @Override
    public void dfsRecursively(Consumer<Integer> handling, Integer root) {

    }

    @Override
    public void dfsIteratively(Consumer<Integer> handling, Integer root) {

    }

    @Override
    public void bfs(Consumer<Integer> handling, Integer root) {

    }

    @Override
    public List<Integer> getChildrenOf(Integer source) {
        return null;
    }
}
