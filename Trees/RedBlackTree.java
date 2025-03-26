import java.util.*;

public class RedBlackTree<T extends Number> extends BinaryTree<T> {

  public RedBlackTree(T key) {
    super(key);
  }

  public void insert(Node<T> z) {
    Node<T> x = root;
    Node<T> y = null;

    while(x != null) {
      y = x;
      if(z.key.doubleValue() < x.key.doubleValue()) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    z.parent = y;
    if(y == null) {
      root = z;
    }else if(z.key.doubleValue() < y.key.doubleValue()) {
      y.left = z;
    } else {
      y.right = z;
    }
    z.left = null;
    z.right = null;
    z.colour = 'R';
    insertFixup(z);
  }

  private void insertFixup(Node<T> z) {
    while (z.parent != null && z.parent.colour == 'R') {
        if (z.parent == z.parent.parent.left) {
            Node<T> y = z.parent.parent.right; // Uncle node
            
            if (y != null && y.colour == 'R') { 
                z.parent.colour = 'B';
                y.colour = 'B';
                z.parent.parent.colour = 'R';
                z = z.parent.parent;
            } else {
                if (z == z.parent.right) {
                    z = z.parent;
                    leftRotate(z);
                }

                z.parent.colour = 'B';
                z.parent.parent.colour = 'R';
                rightRotate(z.parent.parent);
            }
        } else {
            Node<T> y = z.parent.parent.left;

            if (y != null && y.colour == 'R') { 
                z.parent.colour = 'B';
                y.colour = 'B';
                z.parent.parent.colour = 'R';
                z = z.parent.parent;
            } else {
                if (z == z.parent.left) {
                    z = z.parent;
                    rightRotate(z);
                }

                z.parent.colour = 'B';
                z.parent.parent.colour = 'R';
                leftRotate(z.parent.parent);
            }
        }
    }
    root.colour = 'B';
}
  

  public void leftRotate(Node<T> x) {
    Node<T> y = x.right;
    
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

  public void rightRotate(Node<T> y) {
    Node<T> x = y.left;

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

class BinaryTree<T extends Number> {
  Node<T> root;

  public BinaryTree(T data) {
    root = new Node<T>(data);
  }

  private int findHeight(Node<T> root) {
    if(root == null) {
      return -1;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  private void inOrder(Node<T> root, int row, int col, int height,
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

  public List<List<String>> treeToMatrix(Node<T> root) {

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

  public void print2DArray(List<List<String>> arr) {
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

class Node<T extends Number> {
  char colour;
  T key;
  Node<T> left;
  Node<T> right;
  Node<T> parent;

  public Node(T key) {
    this.key = key;
  }
}


