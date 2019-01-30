package datastracture;

import datastructures.BinaryTree;
import datastructures.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraversalTest {

    @Test
    public void PreOrderDFSTest(){
        Tree<Integer> tree = new Tree<>(5);

        Tree<Integer>.Node<Integer> child11 = tree.getRoot().addChild(4);
        Tree<Integer>.Node<Integer> child12 = tree.getRoot().addChild(3);
        Tree<Integer>.Node<Integer> child13 = tree.getRoot().addChild(2);

        child11.addChild(1);
        child11.addChild(9);
        child11.addChild(8);

        child12.addChild(6);
        child12.addChild(7);

        List<Integer> list = new ArrayList<>();
        tree.DFTraverse(Tree.DFType.PREORDER, (el) -> {
            System.out.println(el);
            list.add(el);
        });
        Integer[] expected = {5,4,1,9,8,3,6,7,2};
        Integer[] actual = list.toArray(new Integer[9]);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void PostOrderDFSTest(){
        Tree<Integer> tree = new Tree<>(5);

        Tree<Integer>.Node<Integer> child11 = tree.getRoot().addChild(4);
        Tree<Integer>.Node<Integer> child12 = tree.getRoot().addChild(3);
        Tree<Integer>.Node<Integer> child13 = tree.getRoot().addChild(2);

        child11.addChild(1);
        child11.addChild(9);
        child11.addChild(8);

        child12.addChild(6);
        child12.addChild(7);

        List<Integer> list = new ArrayList<>();
        tree.DFTraverse(Tree.DFType.POSTORDER, (el) -> {
            System.out.println(el);
            list.add(el);
        });

        Integer[] expected = {1,9,8,4,6,7,3,2,5};
        Integer[] actual = list.toArray(new Integer[9]);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void BFSTest(){
        Tree<Integer> tree = new Tree<>(5);

        Tree<Integer>.Node<Integer> child11 = tree.getRoot().addChild(4);
        Tree<Integer>.Node<Integer> child12 = tree.getRoot().addChild(3);
        Tree<Integer>.Node<Integer> child13 = tree.getRoot().addChild(2);

        child11.addChild(1);
        child11.addChild(9);
        child11.addChild(8);

        child12.addChild(6);
        child12.addChild(7);

        List<Integer> list = new ArrayList<>();
        tree.BFTraverse( (el) -> {
            System.out.println(el);
            list.add(el);
        });

        Integer[] expected = {5,4,3,2,1,9,8,6,7};
        Integer[] actual = list.toArray(new Integer[9]);
        Assertions.assertArrayEquals(expected, actual);
    }
}
