import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

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

        print.printTree(binarySearchTree.getRoot());

    }
}