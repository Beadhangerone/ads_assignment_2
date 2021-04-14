public class BinarySearchTree extends BinaryTree {

    private BinaryTreeNode root;
    public void insert(int element){
        if(root==null)
        {
            root = new BinaryTreeNode(element);
        }

        if(element<root.getElement())
        {
            root.addLeftChild(element);
        }
        else if(element>root.getElement()){
            root.addRightChild(element);
        }
    }
}
