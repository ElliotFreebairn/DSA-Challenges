import java.util.*;

public class App {

  public static void main(String[] args) {
    RedBlackTree<Integer> rbTree = new RedBlackTree<Integer>(1);
    rbTree.root.left = new RBNode<Integer>(2); 
    rbTree.root.right = new RBNode<Integer>(3);
    rbTree.root.right.left = new RBNode<Integer>(4);
    rbTree.root.right.right = new RBNode<Integer>(5);
    rbTree.insert(new RBNode<Integer>(6));
    List<List<String>> result = rbTree.treeToMatrix(rbTree.root);
    rbTree.print2DArray(result);
    

    //rbTree.print2DArray(result); 
    //System.out.println("Left rotate around 1"); 
    //rbTree.leftRotate(rbTree.root);

    //result = rbTree.treeToMatrix(rbTree.root);
    //rbTree.print2DArray(result);

    //System.out.println("Right rotate around 3");
    //rbTree.rightRotate(rbTree.root);

    //result = rbTree.treeToMatrix(rbTree.root);
    //rbTree.print2DArray(result);
  }
}
