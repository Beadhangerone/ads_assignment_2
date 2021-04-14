public class BinarySearchTree extends BinaryTree {
    private BinaryTreeNode root;

    private void insertElementRight(BinaryTreeNode node, int element) {
        if(node.getRightChild() == null) {
            node.addRightChild(new BinaryTreeNode(element));
        } else {
            insert(node.getRightChild(), element);
        }
    }

    private void insertElementLeft(BinaryTreeNode node, int element) {
        if(node.getLeftChild() == null) {
            node.addLeftChild(new BinaryTreeNode(element));
        } else {
            insert(node.getLeftChild(), element);
        }
    }
    private void insert(BinaryTreeNode node, int element)
    {
        if(element>node.getElement())
        {
            insertElementRight(node, element);
        }
        else if(element<node.getElement())
        {
            insertElementLeft(node,element);
        }
    }
    public void insert(int element){
        if(root==null)
        {
            root = new BinaryTreeNode(element);
            setRoot(root);
        }
        else{
            insert(root,element);
        }
    }
}
