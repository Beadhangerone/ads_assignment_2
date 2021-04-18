import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private static BinarySearchTree binSearch;

    @BeforeEach
    public void init(){
        binSearch = new BinarySearchTree();
        binSearch.setRoot(new BinaryTreeNode(5));
        binSearch.insert(1);
        binSearch.insert(3);
        binSearch.insert(69);
        binSearch.insert(77);
        binSearch.insert(66);
        binSearch.insert(0);
    }
    @Test
    void checkIfRootExists() {
        assertNotNull(binSearch.getRoot());
    }

    @Test
    void checkIfTreeIsEmpty(){
        assertFalse(binSearch.isEmpty());
    }




    @Test
    void checkContainsMethodFindsProperNode(){
        assertTrue(binSearch.contains(3));
    }

    @Test
    void checkIfTreeDoesntContainElement(){
        assertFalse(binSearch.contains(99));
    }

    @Test
    void checkIfInOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,1,3,5,66,69,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binSearch.inOrder()));

        BinaryTreePrint treePrint = new BinaryTreePrint();
        treePrint.printTree(binSearch.getRoot());
    }

    @Test
    void checkIfPreOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,0,3,69,66,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binSearch.preOrder()));
    }

    @Test
    void checkIfPostOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,3,1,66,77,69,5));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binSearch.postOrder()));
    }

    @Test
    void checkIfLevelOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,69,0,3,66,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binSearch.levelOrder()));
    }

    @Test
    void checkIfHeightOfTreeIsCorrect(){
        assertEquals(2, binSearch.height());
    }

    private boolean checkIfArraysCorrespond(ArrayList<Integer> correctOrderArrayList, ArrayList<BinaryTreeNode> actualOrderArrayList){
        if(actualOrderArrayList.size() != correctOrderArrayList.size())
            return false;

        for (int i = 0; i < correctOrderArrayList.size() ; i++) {
            if(actualOrderArrayList.get(i).getElement() != correctOrderArrayList.get(i))
            {
                return false;
            }
        }
        return true;
    }

    @Test
    void checkRemoveIfElementExists(){
        BinarySearchTree binSearch = new BinarySearchTree();
        BinaryTreeNode node5 = binSearch.insert(99);
        BinaryTreeNode node2 = binSearch.insert(2);
        BinaryTreeNode node7 = binSearch.insert(7);
        BinaryTreeNode node1 = binSearch.insert(1);
        binSearch.insert(3);
        binSearch.insert(10);


        binSearch.removeElement(node5);
        assertEquals(5, binSearch.size());
    }

    @Test
    void checkIfFindMinIsCorrect(){
        assertEquals(0, binSearch.findMin().getElement());
    }

    @Test
    void checkIfFindMaxIsCorrect(){
        assertEquals(77, binSearch.findMax().getElement());
    }

    @Test
    void checkGetBalance(){
        assertEquals(0, binSearch.GetBalance());
        binSearch.insert(50);
        assertEquals(1, binSearch.GetBalance());
        binSearch.insert(111);
        assertEquals(1, binSearch.GetBalance());
        binSearch.insert(119);
        assertEquals(2, binSearch.GetBalance());
    }

    @Test
    void checkIfRotationIsCorrect(){
        binSearch.insert(1000);
        binSearch.insert(520);
        binSearch.insert(1100);
        binSearch.rebalance();
    }

    @Test
    void rebalanceLeftTest(){


        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);


        binarySearchTree.rebalance();
        assertEquals(3, binarySearchTree.getRoot().getElement());
    }

    @Test
    void rebalanceRightTest(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(8);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);


        binarySearchTree.rebalance();
        assertEquals(8, binarySearchTree.getRoot().getElement());
    }

}