import java.util.*;

public class App {

  public static void main(String[] args) {
    RedBlackTree rbTree = new RedBlackTree(1);
    rbTree.root.left = new Node(2);
    rbTree.root.right = new Node(3);
    rbTree.root.right.left = new Node(4);
    rbTree.root.right.right = new Node(5);
    List<List<String>> result = rbTree.treeToMatrix(rbTree.root);
    
    rbTree.print2DArray(result);

    System.out.println("Left rotate around 1");
    rbTree.leftRotate(rbTree.root);

    result = rbTree.treeToMatrix(rbTree.root);
    rbTree.print2DArray(result);

    System.out.println("Right rotate around 3");
    rbTree.rightRotate(rbTree.root);

    result = rbTree.treeToMatrix(rbTree.root);
    rbTree.print2DArray(result);
  }
}
