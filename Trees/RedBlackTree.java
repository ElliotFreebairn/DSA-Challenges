import java.util.*;

public class RedBlackTree<T extends Number> extends BinaryTree<T> {

  public RedBlackTree(T key) {
    super(key);
  }

  public void insert(RBNode<T> z) {
    RBNode<T> x = root;
    RBNode<T> y = null;

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

  public void delete(RBNode<T> z) {
    RBNode<T> y = z;
    RBNode<T> x = null;
    char oriColour = y.colour;

    if(z.left == null) {
      x = z.right;
      RBTransplant(z, z.right);
    }else if(z.right == null) {
      x = z.left;
      RBTransplant(z, z.left);
    } else {
      y = getSuccesor(z);
      oriColour = y.colour;
      x = y.right;

      if(y.parent != z) {
        RBTransplant(y, y.right);
        y.right = z.right;
        y.right.parent = y;
      }

      RBTransplant(z, y);
      y.left = z.left;
      y.left.parent = y;
      y.colour = z.colour;
    }
  }

   
  private void insertFixup(RBNode<T> z) {
    while (z.parent != null && z.parent.colour == 'R') {
      if (z.parent == z.parent.parent.left) {
        RBNode<T> y = z.parent.parent.right; // Uncle node
        
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
        RBNode<T> y = z.parent.parent.left;

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

  private void RBTransplant(RBNode<T> u, RBNode<T> v) {
    if(u.parent == null) {
      root = v;
    }else if(u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }

  public RBNode<T> getSuccesor(RBNode<T> y) {
    if(root == null) {
      return null;
    }
    if(y.parent == null && root.right != null) {
      return leftMost(root.right);
    }

    RBNode<T> succ = null;
    RBNode<T> curr = root;
    while(curr != null) {

      if(y.key.doubleValue() < curr.key.doubleValue()) {
        succ = curr;
        curr = curr.left;
      }else if(y.key.doubleValue() >= curr.key.doubleValue()) {
        curr = curr.right;
      }
    }
    return succ;
  }

  private RBNode<T> leftMost(RBNode<T> n) {
    RBNode<T> curr = n;
    while(curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }
  
    
  

  public void leftRotate(RBNode<T> x) {
    RBNode<T> y = x.right;
    
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

  public void rightRotate(RBNode<T> y) {
    RBNode<T> x = y.left;

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
  RBNode<T> root;

  public BinaryTree(T data) {
    root = new RBNode<T>(data);
  }

  private int findHeight(RBNode<T> root) {
    if(root == null) {
      return -1;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  private void inOrder(RBNode<T> root, int row, int col, int height,
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

  public List<List<String>> treeToMatrix(RBNode<T> root) {

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

class RBNode<T extends Number> extends Node<T> {
  char colour;
  RBNode<T> left;
  RBNode<T> right;
  RBNode<T> parent; // could put this into the node class and then cast to RBNode when i need colour 

  public RBNode(T key) {
    super(key);
    colour = 'B';
  }
}

class Node<T extends Number> {
  T key;

  public Node(T key) {
    this.key = key;
  }
}


