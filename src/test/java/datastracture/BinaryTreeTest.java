package datastracture;

import datastructures.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void insertLeft(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(7);
        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 7);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }
    @Test
    public void insertRight(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(7);
        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 7);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
    }

    @Test
    public void insertLeftLeft(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(7);
        left.insertLeft(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 7);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight() == null);
    }

    @Test
    public void insertOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insert(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 6);
    }

    @Test
    public void insertIntoRightMiddleElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(2);
        BinaryTree<Integer>.Node<Integer> leftNode = tree.insertLeft(3);
        leftNode.insertLeft(1);
        tree.insert(4);
        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 2);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getValue() == 4);
    }

    @Test
    public void preOrderTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==1);
        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void preOrderTraverseWithLeftElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==2);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 3);
    }

    @Test
    public void preOrderTraverseWithRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==2);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 3);
    }

    @Test
    public void preOrderTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==3);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 1);
        Assertions.assertTrue(list.get(2) == 3);
    }

    @Test
    public void preOrderTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==4);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 1);
        Assertions.assertTrue(list.get(2) == 4);
        Assertions.assertTrue(list.get(3) == 3);
    }

    @Test
    public void preOrderTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==4);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 1);
        Assertions.assertTrue(list.get(2) == 4);
        Assertions.assertTrue(list.get(3) == 6);
        Assertions.assertTrue(list.get(4) == 3);
    }


    @Test
    public void preOrderTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==4);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 1);
        Assertions.assertTrue(list.get(2) == 4);
        Assertions.assertTrue(list.get(3) == 6);
        Assertions.assertTrue(list.get(4) == 3);
        Assertions.assertTrue(list.get(5) == 8);
    }

    @Test
    public void preOrderTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.preOrderDFTraverseRecursively((e) -> list.add(e.getValue()));
        Assertions.assertTrue(list.size() ==4);
        Assertions.assertTrue(list.get(0) == 5);
        Assertions.assertTrue(list.get(1) == 1);
        Assertions.assertTrue(list.get(2) == 4);
        Assertions.assertTrue(list.get(3) == 6);
        Assertions.assertTrue(list.get(4) == 3);
        Assertions.assertTrue(list.get(5) == 10);
        Assertions.assertTrue(list.get(6) == 8);
    }
}
