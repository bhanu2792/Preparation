package Interview;

//Java program to see if two trees are identical 

//A binary tree node 
class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

class BinaryTree {
  Node root1, root2;

  /*
   * Given two trees, return true if they are structurally identical
   */
  boolean identicalTrees(Node a, Node b) {
    /* 1. both empty */
    if (a == null && b == null)
      return true;
    
    if (a.data != b.data) {
       return false;
    }

   
    /* 3. one empty, one not -> false */
    return identicalTrees(a.left, b.left) &&identicalTrees(a.right, b.right) ;
  }

  /* Driver program to test identicalTrees() function */
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.root1 = new Node(1);
    tree.root1.left = new Node(2);
    tree.root1.right = new Node(3);
    tree.root1.left.left = new Node(4);
    tree.root1.left.right = new Node(5);

    tree.root2 = new Node(1);
    tree.root2.left = new Node(2);
    tree.root2.right = new Node(3);
    tree.root2.left.left = new Node(4);
    tree.root2.left.right = new Node(5);

    if (tree.identicalTrees(tree.root1, tree.root2))
      System.out.println("Both trees are identical");
    else
      System.out.println("Trees are not identical");

  }
}
