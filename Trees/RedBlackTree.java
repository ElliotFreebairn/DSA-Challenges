import java.util.*;

public class RedBlackTree extends BinaryTree {

  public RedBlackTree(int key) {
    super(key);
  }

  public void leftRotate(Node x) {
    Node y = x.right;
    
    x.right = y.left;
    if(y.left != null) {
      y.left.parent = x;
    }
    y.parent = x.parent;

    if(x.parent == null) {
      this.root = y;
    }else if(x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }

    y.left = x;
    x.parent = y;
  }

  public void rightRotate(Node y) {
    Node x = y.left;

    y.left = x.right;
    if(x.right != null) {
      x.right.parent = y;
    }
    x.parent = y.parent;
    if(y.parent == null) {
      root = x;
    }else if(y == y.parent.left) {
      y.parent.left = x;
    } else {
      y.parent.right = x;
    }

    x.right = y;
    y.parent = x;
  }

}

class BinaryTree {
  Node root;

  public BinaryTree(int data) {
    root = new Node(data);
  }

  private static int findHeight(Node root) {
    if(root == null) {
      return -1;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  private static void inOrder(Node root, int row, int col, int height,
                              List<List<String>> ans) {
    if(root == null) {
      return;
    }

    // Calculate offset for child positions
    int offset = (int) Math.pow(2, height - row - 1);

    // Traverse the left subtree
    if(root.left != null) {
      inOrder(root.left, row + 1, col - offset, height, ans);
    }

    // Place the current node's value in the matrix
    ans.get(row).set(col, String.valueOf(root.key));

    // Traverse the right subtree
    if(root.right != null) {
      inOrder(root.right, row + 1, col + offset, height, ans);
    }
  }

  public static List<List<String>> treeToMatrix(Node root) {

    int height = findHeight(root);

    // Rows are height + 1; columns are 2^(height+1) - 1
    int rows = height + 1;
    int cols = (int) Math.pow(2, height + 1) - 1;

    List<List<String>> ans = new ArrayList<>();
    for(int i = 0; i < rows; i++) {
      List<String> row = new ArrayList<>(Collections.nCopies(cols, ""));
      ans.add(row);
    }

    inOrder(root, 0, (cols - 1) / 2, height, ans);
    return ans;
  }

  public static void print2DArray(List<List<String>> arr) {
    for(List<String> row : arr) {
      for(String cell : row) {
        if(cell.isEmpty()) {
          System.out.print(" ");
        } else {
          System.out.print(cell);
        }
      }
      System.out.println();
    }
  }

}

class Node {
  char colour;
  int key;
  Node left;
  Node right;
  Node parent;

  public Node(int key) {
    this.key = key;
  }
}


