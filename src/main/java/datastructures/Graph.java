package datastructures;

import java.util.List;
import java.util.function.Consumer;

public interface Graph<T> {
    void addEdge(T source, T newVertex);
    void addVertex(T source);
    void dfsRecursively(Consumer<T> handling, T root);
    void dfsIteratively(Consumer<T> handling, T root);
    void bfs(Consumer<T> handling, T root);

    List<T> getChildrenOf(T source);
}
