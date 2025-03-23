class RedBlackTree {
  Node root;

  private static void leftRotate(Node x) {
    Node y = n.right;
    
    n.right = y.left;
    if(y.left != null) {
      y.left.parent = x;
    }
    y.parent = x.parent;

    if(x.parent == null) {
      root = y;
    }else if(x == x.p.left) {
      x.parent.left = y;
    } else {
      x.p.right = y;
    }

    y.left = x;
    x.p = y;
  }

  private static void rightRotate(Node y) {
    Node x = n.left;

    y.left = x.right;
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


