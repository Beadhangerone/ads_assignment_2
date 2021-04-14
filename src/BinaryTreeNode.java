public class BinaryTreeNode {
    private int element;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private BinaryTreeNode parent;

    public BinaryTreeNode(int element) {
        this.element = element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public void addLeftChild(int left) {
        this.left = new BinaryTreeNode(left);
        this.left.setParent(this);
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public void addRightChild(int right) {
        this.right = new BinaryTreeNode(right);
        this.right.setParent(this);
    }

    public int getElement() {
        return element;
    }

    public BinaryTreeNode getLeftChild() {
        return left;
    }

    public BinaryTreeNode getRightChild() {
        return right;
    }
}
