import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest{


    @Test
    void insert(){
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
       assertEquals(binarySearchTree.size(), 5);
    }
    @Test
    void rotateLeft() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinaryTreePrint treePrint = new BinaryTreePrint();
        BinaryTreeNode binaryTreeNode8 = binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(25);
        binarySearchTree.insert(60);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        treePrint.printTree(binarySearchTree.getRoot());
        System.out.println("\n-------------------------");
        binarySearchTree.rotateLeft(binaryTreeNode8);
        treePrint.printTree(binarySearchTree.getRoot());

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

}