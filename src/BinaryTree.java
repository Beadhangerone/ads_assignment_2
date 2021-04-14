import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTree {
    private BinaryTreeNode root;

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
        } return (size(node.getLeft()) + 1 + size(node.getRight()));
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
        if(contains(node.getLeft(), element)) {
            return true;
        }
        return contains(node.getRight(), element);
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
        inOrder(node.getLeft(), values);
        values.add(node.getElement());
        inOrder(node.getRight(), values);
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
        preOrder(node.getLeft(), values);
        preOrder(node.getRight(), values);
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
        postOrder(node.getLeft(), values);
        postOrder(node.getRight(), values);
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
            if(tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
                values.add(tempNode.getLeft().getElement());
            }
            if(tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
                values.add(tempNode.getRight().getElement());
            }
        }
    }
    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            if(leftHeight > rightHeight)
                return (leftHeight+1);
            else return (rightHeight+1);
        }
    }






}
