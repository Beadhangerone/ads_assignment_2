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
    void checkIfSizeIsCorrectAfterInsertion(){
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        assertEquals(9, binarySearchTree.size());
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
    void checkIfDuplicateIsAdded(){
        binarySearchTree.insert(3);
        assertEquals(8, binarySearchTree.size());
    }
    @Test
    void checkIfInOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,1,3,5,66,69,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList,binarySearchTree.inOrder()));

    }

    @Test
    void checkIfPreOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,0,3,69,66,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.preOrder()));
    }

    @Test
    void checkIfPostOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(0,3,1,66,77,69,5));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.postOrder()));
    }

    @Test
    void checkIfLevelOrderIsCorrect(){
        ArrayList<Integer> correctOrderArrayList = new ArrayList<>(Arrays.asList(5,1,69,0,3,66,77));
        assertTrue(checkIfArraysCorrespond(correctOrderArrayList, binarySearchTree.levelOrder()));
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

}