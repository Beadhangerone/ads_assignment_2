import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree extends BinaryTree {

    public void rotateLeft(BinaryTreeNode node){
        BinaryTreeNode oldRight = node.getRightChild();

        if(oldRight == null) {
            return; // can't rotate
        }

        BinaryTreeNode orphanTree = oldRight.getLeftChild();
        BinaryTreeNode nodeParent = node.getParent();

        // rotate
        oldRight.setLeftChild(node);
        oldRight.setParent(nodeParent);
        node.setParent(oldRight);

        // connect the orphan tree
        node.setRightChild(orphanTree);
        orphanTree.setParent(node);

        // update the root attribute
        BinaryTreeNode root = this.getRoot();
        if(root == node){
            this.setRoot(oldRight);
        }

    }

    private void insertElementRight(BinaryTreeNode node, int element) {
        if (node.getRightChild() == null) {
            node.addRightChild(new BinaryTreeNode(element));
        } else {
            insert(node.getRightChild(), element);
        }
    }

    private void insertElementLeft(BinaryTreeNode node, int element) {
        if (node.getLeftChild() == null) {
            node.addLeftChild(new BinaryTreeNode(element));
        } else {
            insert(node.getLeftChild(), element);
        }
    }

    private void insert(BinaryTreeNode node, int element) {
        if (element > node.getElement()) {
            insertElementRight(node, element);
        } else if (element < node.getElement()) {
            insertElementLeft(node, element);
        }
    }

    public BinaryTreeNode insert(int element) {
        BinaryTreeNode node = new BinaryTreeNode(element);
        if (root == null) {
            root = node;
            setRoot(root);
        } else {
            insert(root, element);
        }
        return node;
    }

    public void removeElement(BinaryTreeNode element) {
        root = removeElement_recursive(root, element);
    }

    private BinaryTreeNode removeElement_recursive(BinaryTreeNode root, BinaryTreeNode element) {
        if (root == null) {
            return root;
        }

        int rootV = root.getElement();
        int elementV = element.getElement();

        if (elementV < rootV) {
            root.setLeftChild(removeElement_recursive(root.getLeftChild(), element));
        } else if (elementV > rootV) {
            root.setRightChild(removeElement_recursive(root.getRightChild(), element));
        } else { // we found the element to delete
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }

            BinaryTreeNode minNode = findMin(root.getRightChild());
            root.setElement(minNode.getElement());
            root.setRightChild(removeElement_recursive(root.getRightChild(), minNode));
        }
        return root;
    }

    public BinaryTreeNode findMin() throws Exception {
        BinaryTreeNode node = root;
        return findMin(node);
    }

    public BinaryTreeNode findMin(BinaryTreeNode node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    public BinaryTreeNode findMax() throws Exception {
        BinaryTreeNode node = root;
        return findMax(node);
    }

    public BinaryTreeNode findMax(BinaryTreeNode node) {
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

}
