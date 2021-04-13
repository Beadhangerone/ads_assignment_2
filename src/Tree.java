public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size(root);
    }
    private int size(Node node)
    {
        if(node==null){
            return 0;
        }
        else{
            return (size(node.getLeft())+1+size(node.getRight()));
        }
    }


}
