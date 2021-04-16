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

}