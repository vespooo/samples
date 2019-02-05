package datastracture;

import datastructures.Graph;
import datastructures.MapGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


public class MapGraphTests {

    private Graph<Integer> graph;

    @BeforeEach
    private void before(){
        graph = new MapGraph<>();
    }

    @Test
    public void addEdgeWithNotExistedSource(){
        graph.addEdge(5,3);

        Assertions.assertArrayEquals(new Integer[]{3}, graph.getChildrenOf(5).toArray());
    }

    @Test
    public void addEdgeWithExistedSource(){
        graph.addEdge(5,3);
        graph.addEdge(5,4);

        Assertions.assertArrayEquals(new Integer[]{3, 4}, graph.getChildrenOf(5).toArray());
    }
/////////////////////////////////////////////////////////////////////////////
    @Test
    public void bfsOneElGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addVertex(5);
        graph.bfs((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5}, list.toArray());
    }

    @Test
    public void bfsOneEdgeGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 3);
        graph.bfs((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 3}, list.toArray());
    }

    @Test
    public void bfs2LevelGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(4, 6);

        graph.bfs((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,3,6,7,8}, list.toArray());
    }

    @Test
    public void bfs2LevelWithLoopsGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(7, 7);
        graph.addEdge(7, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);

        graph.bfs((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,3,6,7,8}, list.toArray());
    }

    ///////////////////////////////////////////////////////////////////

    @Test
    public void dfsRecursivelyOneElGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addVertex(5);
        graph.dfsRecursively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5}, list.toArray());
    }

    @Test
    public void dfsRecursivelyOneEdgeGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 3);
        graph.dfsRecursively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 3}, list.toArray());
    }

    @Test
    public void dfsRecursively2LevelGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(4, 6);

        graph.dfsRecursively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,6,3,7,8}, list.toArray());
    }

    @Test
    public void dfsRecursively2LevelWithLoopsGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(7, 7);
        graph.addEdge(7, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);

        graph.dfsRecursively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,6,3,7,8}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void dfsIterativelyOneElGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addVertex(5);
        graph.dfsIteratively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5}, list.toArray());
    }

    @Test
    public void dfsIterativelyOneEdgeGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 3);
        graph.dfsIteratively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 3}, list.toArray());
    }

    @Test
    public void dfsIteratively2LevelGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(4, 6);

        graph.dfsIteratively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,6,3,7,8}, list.toArray());
    }

    @ParameterizedTest
    @MethodSource("oddElArr")
    public void dfsIteratively2LevelWithLoopsGraph(){
        List<Integer> list = new ArrayList<>();
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(7, 7);
        graph.addEdge(7, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);

        graph.dfsIteratively((v) -> list.add(v), 5);

        Assertions.assertArrayEquals(new Integer[]{5, 4,6,3,7,8}, list.toArray());
    }

    private static Stream<Arguments> oddElArr(){
        return Stream.of(Arguments.of(new int[]{0,1, 25, 49, 64 }, new int[]{-5,-1,0,7, 8}));
    }

    public static Collection<Graph> instancesToTest() {
        return Arrays.asList(
                new MapGraph<>()
        );
    }
}
