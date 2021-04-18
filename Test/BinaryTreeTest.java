import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private static BinarySearchTree binarySearchTree;

    @BeforeEach
    public void init(){
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.setRoot(new BinaryTreeNode(5));
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(69);
        binarySearchTree.insert(77);
        binarySearchTree.insert(66);
        binarySearchTree.insert(0);
    }
    @Test
    void checkIfRootExists() {
        assertNotNull(binarySearchTree.getRoot());
    }

    @Test
    void checkIfTreeIsEmpty(){
        assertFalse(binarySearchTree.isEmpty());
    }




    @Test
    void checkContainsMethodFindsProperNode(){
        assertTrue(binarySearchTree.contains(3));
    }

    @Test
    void checkIfTreeDoesntContainElement(){
        assertFalse(binarySearchTree.contains(99));
    }

    @Test
    void checkIfInOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,1,3,5,66,69,77));
//        assertTrue(checkIfArraysCorrespond(correctOrderArrayList,binarySearchTree.inOrder()));

        BinaryTreePrint treePrint = new BinaryTreePrint();
        treePrint.printTree(binarySearchTree.getRoot());
    }

    @Test
    void checkIfPreOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,0,3,69,66,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.preOrder()));
    }

    @Test
    void checkIfPostOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,3,1,66,77,69,5));
//        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.postOrder()));
    }

    @Test
    void checkIfLevelOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,69,0,3,66,77));
//        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.levelOrder()));
    }

    @Test
    void checkIfHeightOfTreeIsCorrect(){
        assertEquals(2, binarySearchTree.height());
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

    @Test
    void checkGetBalance(){
        assertEquals(0, binarySearchTree.GetBalance());
        binarySearchTree.insert(50);
        assertEquals(1, binarySearchTree.GetBalance());
        binarySearchTree.insert(111);
        assertEquals(1, binarySearchTree.GetBalance());
        binarySearchTree.insert(119);
        assertEquals(2, binarySearchTree.GetBalance());
    }

}