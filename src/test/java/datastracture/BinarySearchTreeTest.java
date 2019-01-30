package datastracture;

import datastructures.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void insertNullToEmpty(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> tree.insert(null),
                BinarySearchTree.NULL_INSERTION_ERROR_MESSAGE);
    }

    @Test
    public void insertRoot(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void insertNullToNotEmpty(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> tree.insert(null),
                BinarySearchTree.NULL_INSERTION_ERROR_MESSAGE);
    }

    @Test
    public void insertDuplicate(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> tree.insert(null),
                BinarySearchTree.DUPLICATES_INSERTION_ERROR_MESSAGE);
    }

    @Test
    public void insertLeftIntoOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void insertRightIntoOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
    }

    @Test
    public void insertLeftAndRight(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
    }

    @Test
    public void insertLeftLeft(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight() == null);
    }

    @Test
    public void insertLeftRight(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(4);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getValue() == 4);
    }

    @Test
    public void insertRightLeft(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(7);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft().getValue() == 7);
        Assertions.assertTrue(tree.getRoot().getRight().getRight() == null);
    }

    @Test
    public void insertRightRight(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getRight().getValue() == 10);
    }

    @Test
    public void deleteNotExistedInOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.delete(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
    }

    @Test
    public void deleteRootInOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.delete(6);
        Assertions.assertTrue(tree.getRoot() == null);
    }

    @Test
    public void deleteLeftIntoOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.delete(3);

        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void deleteRightIntoOneElementTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.delete(8);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void deleteLeftOfFullNode(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.delete(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
    }

    @Test
    public void deleteLeftLeft(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.delete(1);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight() == null);
    }

    @Test
    public void deleteLeftRight(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(4);
        tree.delete(4);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight() == null);
    }

    @Test
    public void deleteRightLeft(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(7);
        tree.delete(7);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getRight() == null);
    }

    @Test
    public void deleteRightRight(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.delete(10);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getRight().getRight() == null);
    }

    @Test
    public void deleteRootInOneLeftChildTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.delete(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 3);
    }

    @Test
    public void deleteRootInOneRightChildTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.delete(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 8);
    }

    @Test
    public void deleteRootInBothChildTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.delete(6);
        Assertions.assertTrue(tree.getRoot().getValue() == 8);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void deleteElementWithOneLeftChild(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.delete(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void deleteElementWithOneRightChild(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(5);
        tree.delete(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
    }

    @Test
    public void deleteElementWithBothChildren(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.insert(5);
        tree.delete(3);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight() == null);
    }

    @Test
    public void deleteElementWithRightSubtreeMinWithoutChild(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.delete(2);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 4);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getRight() == null);
    }

    @Test
    public void deleteElementWithRightSubtreeMinWithChild(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.delete(2);
        Assertions.assertTrue(tree.getRoot().getValue() == 6);
        Assertions.assertTrue(tree.getRoot().getLeft().getValue() == 3);
        Assertions.assertTrue(tree.getRoot().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getValue() == 1);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getLeft() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getLeft().getRight() == null);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getValue() == 5);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getLeft().getValue() == 4);
        Assertions.assertTrue(tree.getRoot().getLeft().getRight().getRight() == null);
    }
}
