import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree extends BinaryTree {


  public int findMin() throws Exception
  {
    ArrayList<Integer> elements = super.inOrder();
    if(!elements.isEmpty())
      return Collections.min(elements);

    throw new Exception("Tree is empty");
  }

  public int findMax() throws Exception
  {
    ArrayList<Integer> elements = super.inOrder();
    if(!elements.isEmpty())
      return Collections.max(elements);

    throw new Exception("Tree is empty");
  }

}
