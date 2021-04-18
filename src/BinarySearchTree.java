import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree extends BinaryTree {

    public void rotateRight(BinaryTreeNode node) {
        BinaryTreeNode oldLeft = node.getLeftChild();

        if (oldLeft == null) {
            System.out.println("Can't Rotate");
            return; // can't rotate
        }

        BinaryTreeNode orphanTree = oldLeft.getRightChild();
        BinaryTreeNode nodeParent = node.getParent();

        // rotate
        oldLeft.setRightChild(node);
        oldLeft.setParent(nodeParent);
        node.setParent(oldLeft);

        // connect the orphan tree
        node.setLeftChild(orphanTree);
        if (orphanTree != null) {
            orphanTree.setParent(node);
        }

        // update the parent or the root
        if (nodeParent == null) { // the parent was the root
            setRoot(oldLeft);
        } else {
            if (nodeParent.getLeftChild() == node) {
                nodeParent.setLeftChild(oldLeft);
            } else {
                nodeParent.setRightChild(oldLeft);
            }
        }
    }

    public void rotateLeft(BinaryTreeNode node) {
        BinaryTreeNode oldRight = node.getRightChild();

        if (oldRight == null) {
            System.out.println("Can't Rotate");
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
        if (orphanTree != null) {
            orphanTree.setParent(node);
        }

        // update the parent or the root
        if (nodeParent == null) { // the parent was the root
            setRoot(oldRight);
        } else {
            if (nodeParent.getLeftChild() == node) {
                nodeParent.setLeftChild(oldRight);
            } else {
                nodeParent.setRightChild(oldRight);
            }
        }
    }

    private BinaryTreeNode insertElementRight(BinaryTreeNode node, int element) {
        if (node.getRightChild() == null) {
            return node.addRightChild(new BinaryTreeNode(element));
        } else {
            return insert(node.getRightChild(), element);
        }
    }

    private BinaryTreeNode insertElementLeft(BinaryTreeNode node, int element) {
        if (node.getLeftChild() == null) {
            return node.addLeftChild(new BinaryTreeNode(element));
        } else {
            return insert(node.getLeftChild(), element);
        }
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int element) {
        if (element > node.getElement()) {
            return insertElementRight(node, element);
        } else if (element < node.getElement()) {
            return insertElementLeft(node, element);
        } else { // element already present
            return node;
        }
    }

    public BinaryTreeNode insert(int element) {
        BinaryTreeNode node;
        if (root == null) {
            node = new BinaryTreeNode(element);
            setRoot(node);
            return node;
        } else {
            node = insert(root, element);
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

    public int GetBalance() {
        if (root == null) {
            return 0;
        }
        int leftPart = height(root.getLeftChild());
        int rightPart = height(root.getRightChild());
        return rightPart - leftPart;
    }

    //julias

    public void rebalance() {
        if (GetBalance() <= 1 && GetBalance() >= -1) {
            System.out.println("tree is already balanced");
        }
        ArrayList<BinaryTreeNode> postOrder = postOrder();

        for (BinaryTreeNode parent : postOrder) {
            rebalanceNode(parent);
        }
    }

    //julias
    private int getNodeBalance(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPart = height(node.getLeftChild());
        int rightPart = height(node.getRightChild());
        return rightPart - leftPart;
    }

    //julias
    private void rebalanceNode(BinaryTreeNode parent) {
        int balance = getNodeBalance(parent);
        System.out.println(parent.getElement() + " balance = "+balance+"\n");
        if (balance <= -2) {
            BinaryTreeNode leftChild = parent.getLeftChild();
            if (leftChild != null) {
                int leftChildBalance = getNodeBalance(leftChild);
                if (leftChildBalance == 1) {
                    rotateLeft(leftChild);
                }
                rotateRight(parent);
                rebalanceNode(parent);
            }
        } else if (balance >= 2) {
            BinaryTreeNode rightChild = parent.getRightChild();
            if (rightChild != null) {
                int rightChildBalance = getNodeBalance(rightChild);
                if (rightChildBalance == -1) {
                    rotateRight(rightChild);
                }
                rotateLeft(parent);
                rebalanceNode(parent);
            }
        }
    }


}
