import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTree {
    protected BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
       return size(root);
    }
    private int size(BinaryTreeNode node) {
        if(node == null) {
            return  0;
        } return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
    }
    public boolean contains(int element){
        if(root == null)
        {
            return false;
        }
        if(root.getElement() == element)
        {
            return true;
        }
        return contains(root, element);
    }

    private boolean contains(BinaryTreeNode node, int element) {
        if(node == null) {
            return false;
        }
        if(element == node.getElement()) {
            return true;
        }
        if(contains(node.getLeftChild(), element)) {
            return true;
        }
        return contains(node.getRightChild(), element);
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(BinaryTreeNode node, ArrayList<Integer> values) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeftChild(), values);
        values.add(node.getElement());
        inOrder(node.getRightChild(), values);
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(BinaryTreeNode node, ArrayList<Integer> values) {
        if(node == null) {
            return;
        }
        values.add(node.getElement());
        preOrder(node.getLeftChild(), values);
        preOrder(node.getRightChild(), values);
    }


    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(BinaryTreeNode node, ArrayList<Integer> values) {
        if(node == null) {
            return;
        }
        postOrder(node.getLeftChild(), values);
        postOrder(node.getRightChild(), values);
        values.add(node.getElement());
    }

    public ArrayList<Integer> levelOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        levelOrder(root, list);
        return list;
    }

    private void levelOrder(BinaryTreeNode node, ArrayList<Integer> values) {
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        values.add(node.getElement());
        BinaryTreeNode tempNode;

        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            if(tempNode.getLeftChild() != null) {
                queue.add(tempNode.getLeftChild());
                values.add(tempNode.getLeftChild().getElement());
            }
            if(tempNode.getRightChild() != null) {
                queue.add(tempNode.getRightChild());
                values.add(tempNode.getRightChild().getElement());
            }
        }
    }
    public int height() {
        //i added this check here because.. yeah check assignment description
        if(root==null)
        {return -1;}
        return height(root);
    }

    private int height(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeftChild());
            int rightHeight = height(node.getRightChild());

            if(leftHeight > rightHeight)
                return (leftHeight+1);
            else return (rightHeight+1);
        }
    }
}
