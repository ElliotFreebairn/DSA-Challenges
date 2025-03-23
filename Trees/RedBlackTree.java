class RedBlackTree {
  Node root;

  private static void leftRotate(Node x) {
    Node y = x.right;
    
    x.right = y.left;
    if(y.left != null) {
      y.left.parent = x;
    }
    y.parent = x.parent;

    if(x.parent == null) {
      root = y;
    }else if(x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }

    y.left = x;
    x.parent = y;
  }

  private static void rightRotate(Node y) {
    Node x = n.left;

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


