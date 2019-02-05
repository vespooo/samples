package datastracture;

import datastructures.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTreeTests {

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
    public void insertLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertLeft(10);
        right.insertRight(8);

        Assertions.assertTrue(tree.getRoot().getValue() == 5);

        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 4);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getRight() == null);

        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft().getValue() == 10);
        Assertions.assertTrue(tree.getRoot().getRight().getRight().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getRight().getRight() == null);
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

 //////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void preOrderRecursiveTraverseWithOneElement(){
         BinaryTree<Integer> tree = new BinaryTree<>(5);
         List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void preOrderRecursiveTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void preOrderRecursiveTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void preOrderRecursiveTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 3);


        Assertions.assertArrayEquals(new Integer[]{5,1,3}, list.toArray());
    }

    @Test
    public void preOrderRecursiveTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,1,4,3}, list.toArray());
    }

    @Test
    public void preOrderRecursiveTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3}, list.toArray());

    }


    @Test
    public void preOrderRecursiveTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3,8}, list.toArray());
    }

    @Test
    public void preOrderRecursiveTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3,10,8}, list.toArray());

    }

    @Test
    public void preOrderRecursiveTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.preOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,3,1,2,8,10,4,7,6,9,11}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void inOrderRecursiveTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void inOrderRecursiveTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void inOrderRecursiveTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void inOrderRecursiveTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));


        Assertions.assertArrayEquals(new Integer[]{1,5,3}, list.toArray());
    }

    @Test
    public void inOrderRecursiveTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,1,5,3}, list.toArray());
    }

    @Test
    public void inOrderRecursiveTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,3}, list.toArray());

    }

    @Test
    public void inOrderRecursiveTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,3,8}, list.toArray());
    }

    @Test
    public void inOrderRecursiveTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,10,3,8}, list.toArray());

    }

    @Test
    public void inOrderRecursiveTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.inOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{1,8,2,10,3,4,5,6,7,11,9}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void postOrderRecursiveTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void postOrderRecursiveTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void postOrderRecursiveTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void postOrderRecursiveTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));


        Assertions.assertArrayEquals(new Integer[]{1,3,5}, list.toArray());
    }

    @Test
    public void postOrderRecursiveTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,1,3,5}, list.toArray());
    }

    @Test
    public void postOrderRecursiveTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,6,1,3,5}, list.toArray());

    }

    @Test
    public void postOrderRecursiveTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,6,1,8,3,5}, list.toArray());
    }

    @Test
    public void postOrderRecursiveTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{4,6,1,10,8,3,5}, list.toArray());
    }


    @Test
    public void postOrderRecursiveTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.postOrderRecursiveDFS((e) -> list.add(e.getValue()));

        Assertions.assertArrayEquals(new Integer[]{8,10,2,1,4,3,6,11,9,7,5}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void preOrderIterativeTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void preOrderIterativeTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void preOrderIterativeTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void preOrderIterativeTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertTrue(tree.getRoot().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 3);


        Assertions.assertArrayEquals(new Integer[]{5,1,3}, list.toArray());
    }

    @Test
    public void preOrderIterativeTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,1,4,3}, list.toArray());
    }

    @Test
    public void preOrderIterativeTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3}, list.toArray());

    }


    @Test
    public void preOrderIterativeTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3,8}, list.toArray());
    }

    @Test
    public void preOrderIterativeTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,1,4,6,3,10,8}, list.toArray());

    }

    @Test
    public void preOrderIterativeTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.PREORDER);

        Assertions.assertArrayEquals(new Integer[]{5,3,1,2,8,10,4,7,6,9,11}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void inOrderIterativeTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertTrue(list.size() ==1);
        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void inOrderIterativeTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        Consumer<BinaryTree<Integer>.Node<Integer>> handling = (e) -> {
            list.add(e.getValue());
        };
        tree.iterativeDFS(handling, BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void inOrderIterativeTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{5,3}, list.toArray());
    }

    @Test
    public void inOrderIterativeTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{1,5,3}, list.toArray());
    }

    @Test
    public void inOrderIterativeTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{4,1,5,3}, list.toArray());
    }

    @Test
    public void inOrderIterativeTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,3}, list.toArray());

    }

    @Test
    public void inOrderIterativeTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,3,8}, list.toArray());
    }

    @Test
    public void inOrderIterativeTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{4,1,6,5,10,3,8}, list.toArray());

    }

    @Test
    public void inOrderIterativeTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.INORDER);

        Assertions.assertArrayEquals(new Integer[]{1,8,2,10,3,4,5,6,7,11,9}, list.toArray());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void postOrderIterativeTraverseWithOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertTrue(list.get(0) == 5);
    }

    @Test
    public void postOrderIterativeTraverseWithLeftElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(3);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void postOrderIterativeTraverseWithRightElement(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{3,5}, list.toArray());
    }

    @Test
    public void postOrderIterativeTraverseWithLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        tree.insertLeft(1);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);


        Assertions.assertArrayEquals(new Integer[]{1,3,5}, list.toArray());
    }

    @Test
    public void postOrderIterativeTraverseWithLeftLeftAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{4,1,3,5}, list.toArray());
    }

    @Test
    public void postOrderIterativeTraverseWithLeftFullAndRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(3);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{4,6,1,3,5}, list.toArray());

    }

    @Test
    public void postOrderIterativeTraverseWithLeftFullAndRightRightElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{4,6,1,8,3,5}, list.toArray());
    }

    @Test
    public void postOrderIterativeTraverseWithLeftFullAndRightFullElements(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(1);
        left.insertLeft(4);
        left.insertRight(6);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(3);
        right.insertRight(8);
        right.insertLeft(10);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{4,6,1,10,8,3,5}, list.toArray());
    }


    @Test
    public void postOrderIterativeTraverseWithFullAndNotFullVertexes(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer>.Node<Integer> left = tree.insertLeft(3);
        BinaryTree<Integer>.Node<Integer> leftLeft = left.insertLeft(1);
        left.insertRight(4);
        BinaryTree<Integer>.Node<Integer> leftLeftRight = leftLeft.insertRight(2);
        leftLeftRight.insertLeft(8);
        leftLeftRight.insertRight(10);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(7);
        right.insertLeft(6);
        BinaryTree<Integer>.Node<Integer> rightRight = right.insertRight(9);
        rightRight.insertLeft(11);
        List<Integer> list = new ArrayList<>();
        tree.iterativeDFS((e) -> list.add(e.getValue()), BinaryTree.ORDER.POSTORDER);

        Assertions.assertArrayEquals(new Integer[]{8,10,2,1,4,3,6,11,9,7,5}, list.toArray());
    }
///////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void deleteRootInOneElementTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.delete(5);
        Assertions.assertNull(tree.getRoot());
    }

    @Test
    public void deleteNotExistedElementInOneElementTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.delete(6);
        Assertions.assertEquals(5, tree.getRoot().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
        Assertions.assertNull(tree.getRoot().getLeft());
    }

    @Test
    public void deleteRootInRootWithLeftTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(4);
        tree.delete(5);
        Assertions.assertEquals(4, tree.getRoot().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
        Assertions.assertNull(tree.getRoot().getLeft());
    }

    @Test
    public void deleteRootInRootWithRightTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertRight(8);
        tree.delete(5);
        Assertions.assertEquals(8, tree.getRoot().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
        Assertions.assertNull(tree.getRoot().getLeft());
    }

    @Test
    public void deleteRootInRootWithLeftAndRightTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(4);
        tree.insertRight(8);
        tree.delete(5);
        Assertions.assertEquals(8, tree.getRoot().getValue().intValue());
        Assertions.assertEquals(4, tree.getRoot().getLeft().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
    }

    @Test
    public void deleteLeftLeafInRootWithLeftAndRightTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(4);
        tree.insertRight(8);
        tree.delete(4);
        Assertions.assertEquals(5, tree.getRoot().getValue().intValue());
        Assertions.assertEquals(8, tree.getRoot().getLeft().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
    }

    @Test
    public void deleteRightestLeafInRootWithLeftAndRightTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(4);
        tree.insertRight(8);
        tree.delete(8);
        Assertions.assertEquals(5, tree.getRoot().getValue().intValue());
        Assertions.assertEquals(4, tree.getRoot().getLeft().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight());
    }

    @Test
    public void deleteMiddleElementInRootWithLeftAndRightTree(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.insertLeft(4);
        BinaryTree<Integer>.Node<Integer> right = tree.insertRight(8);
        right.insertLeft(3);
        right.insertRight(1);
        tree.delete(8);
        Assertions.assertEquals(5, tree.getRoot().getValue().intValue());
        Assertions.assertEquals(4, tree.getRoot().getLeft().getValue().intValue());
        Assertions.assertEquals(1, tree.getRoot().getRight().getValue().intValue());
        Assertions.assertEquals(3, tree.getRoot().getRight().getLeft().getValue().intValue());
        Assertions.assertNull(tree.getRoot().getRight().getRight());
    }
}
