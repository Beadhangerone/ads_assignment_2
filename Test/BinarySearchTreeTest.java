import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class BinarySearchTreeTest{


    @Test
    void checkCorrectOrderAfterInsertion(){
        BinaryTreePrint print = new BinaryTreePrint();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);

        System.out.println(binarySearchTree.size());

        System.out.println(binarySearchTree.inOrder().toString());
        print.printTree(binarySearchTree.getRoot());

        ArrayList<Integer> correctOrderArrayListAfterInsertion = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        assertTrue(checkIfArraysCorrespond(correctOrderArrayListAfterInsertion,binarySearchTree.inOrder()));
        assertEquals(binarySearchTree.size(), 5);
    }

    @Test
    void rebalanceTest(){
        BinaryTreePrint print = new BinaryTreePrint();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);

        print.printTree(binarySearchTree.getRoot());
        System.out.println("\nRebalancing...\n");

        binarySearchTree.rebalance();

        print.printTree(binarySearchTree.getRoot());
    }

    @Test
    void checkIfSizeIsCorrectAfterInsertion(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        assertEquals(2, binarySearchTree.size());
    }
    @Test
    void checkCorrectOrderAfterLeftRotation() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinaryTreePrint treePrint = new BinaryTreePrint();
        System.out.println("Before rotation:");
        BinaryTreeNode binaryTreeNode8 = binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        BinaryTreeNode binaryTreeNode25 = binarySearchTree.insert(25);
        binarySearchTree.insert(60);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(0);
        treePrint.printTree(binarySearchTree.getRoot());
        System.out.println("\n-------------------------");
        System.out.println("After rotation:");
        binarySearchTree.rotateLeft(binaryTreeNode25);
        treePrint.printTree(binarySearchTree.getRoot());
        ArrayList<Integer> correctOrderArrayListAfterRotation = new ArrayList<>(Arrays.asList(0,4,7,8,9,25,60));
//        assertTrue(checkIfArraysCorrespond(correctOrderArrayListAfterRotation,binarySearchTree.inOrder()));

    }
    @Test
    void rotateRight()
    {
        BinarySearchTree bTree = new BinarySearchTree();
        BinaryTreePrint treePrinter = new BinaryTreePrint();

        BinaryTreeNode root = bTree.insert(3);
        BinaryTreeNode node1 =  bTree.insert(10);
        bTree.insert(1);
        BinaryTreeNode node = bTree.insert(6);
        bTree.insert(8);
        bTree.insert(11);
        bTree.insert(2);
        bTree.insert(4);
        bTree.insert(7);
        treePrinter.printTree(bTree.getRoot());
        System.out.println("\n-----------------------------------------\n");
        bTree.rotateRight(node);


        treePrinter.printTree(bTree.getRoot());
    }
    @Test
    void removeElement(){
        BinarySearchTree bTree = new BinarySearchTree();
        BinaryTreePrint treePrinter = new BinaryTreePrint();

        BinaryTreeNode node5 = bTree.insert(5);
        BinaryTreeNode node2 = bTree.insert(2);
        BinaryTreeNode node7 = bTree.insert(7);
        BinaryTreeNode node1 = bTree.insert(1);
        bTree.insert(3);
        bTree.insert(10);


        bTree.removeElement(node5);

        treePrinter.printTree(bTree.getRoot());
    }

    private boolean checkIfArraysCorrespond(ArrayList<Integer> correctOrderArrayList, ArrayList<Integer> actualOrderArrayList){
        if(actualOrderArrayList.size() != correctOrderArrayList.size())
            return false;

        for (int i = 0; i < correctOrderArrayList.size() ; i++) {
            if(actualOrderArrayList.get(i) != correctOrderArrayList.get(i))
            {
                return false;
            }
        }
        return true;
    }
}