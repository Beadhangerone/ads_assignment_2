import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest{
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

    @Test
    void findMin() throws Exception {
        BinarySearchTree bTree = new BinarySearchTree();
        BinaryTreePrint treePrinter = new BinaryTreePrint();

        bTree.insert(3);
        bTree.insert(10);
        bTree.insert(1);
        bTree.insert(6);
        bTree.insert(8);
        bTree.insert(11);
        bTree.insert(2);
        bTree.insert(4);
        bTree.insert(7);


        assertEquals(1,bTree.findMin().getElement());
    }

    @Test
    void findMax() throws Exception {
        BinarySearchTree bTree = new BinarySearchTree();
        BinaryTreePrint treePrinter = new BinaryTreePrint();

        bTree.insert(3);
        bTree.insert(10);
        bTree.insert(1);
        bTree.insert(6);
        bTree.insert(8);
        bTree.insert(11);
        bTree.insert(2);
        bTree.insert(4);
        bTree.insert(7);


        assertEquals(11,bTree.findMax().getElement());
    }

}