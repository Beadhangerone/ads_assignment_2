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

    public BinaryTreeNode addLeftChild(BinaryTreeNode left) {
        left.setParent(this);
        this.left = left;
        return this.left;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public BinaryTreeNode addRightChild(BinaryTreeNode right) {
        right.setParent(this);
        this.right = right;
        return this.right;
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

    public void setLeftChild(BinaryTreeNode element) {
        this.left = element;
    }

    public void setRightChild(BinaryTreeNode element) {
        this.right = element;
    }

    public BinaryTreeNode getRoot(){
        BinaryTreeNode node = this;
        while(node.getParent() != null){
            node = node.getParent();
        }

        return node;
    }
}
