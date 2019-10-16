package tree;

public class BinaryTreeExample {
  /**
   * Creates a binary tree and shows various traversal methods.
   * @param args no arguments needed
   */
  public static void main(String[] args) {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(3);
    root.setLeft(childNode);
    root.setRight(new BinaryTreeNode<Integer>(5));
    childNode.setLeft(new BinaryTreeNode<Integer>(2));
    childNode.setRight(new BinaryTreeNode<Integer>(0));
    System.out.print("In order traversal: ");
    inOrderTraversal(root);
    System.out.print("\nPre order traversal: ");
    preOrderTraversal(root);
    System.out.print("\nPost order traversal: ");
    postOrderTraversal(root);
    System.out.println("\nNode Level Traversal, Level 0:");
    nodeLevelTraversal(root, 1);
    System.out.println("\nNode Level Traversal, Level 1:");
    nodeLevelTraversal(root, 2);
    System.out.println("\nNode Level Traversal, Level 2:");
    nodeLevelTraversal(root, 3);
  }
  
  /**
   * Prints how an in order traversal would look like for the binary tree.
   * In order is: left, current, right
   * @param node the root node
   */
  private static void inOrderTraversal(BinaryTreeNode<Integer> node) {
    if (node != null) {
      inOrderTraversal(node.getLeft());
      System.out.print(node + " ");
      inOrderTraversal(node.getRight());
    }
  }
  
  /**
   * Prints how a pre-order traversal would look like for the binary tree.
   * Pre-order is: current, left, right
   * @param node the root node
   */
  private static void preOrderTraversal(BinaryTreeNode<Integer> node) {
    if (node != null) {
      System.out.print(node + " ");
      preOrderTraversal(node.getLeft());
      preOrderTraversal(node.getRight());
    }
  }
  
  /**
   * Prints how a post-order traversal would look like for the binary tree.
   * Post order is: left, right, current
   * @param node the root node
   */
  private static void postOrderTraversal(BinaryTreeNode<Integer> node) {
    if (node != null) {
      postOrderTraversal(node.getLeft());
      postOrderTraversal(node.getRight());
      System.out.print(node + " ");
    }
  }
  
  /**
   * Prints the nodes at the given level.
   * @param node the node to start from
   * @param level the level to print from
   */
  private static void nodeLevelTraversal(BinaryTreeNode<Integer> node, int level) {
    nodeLevelTraversal(node, level, 1);
  }
  
  /**
   * Prints the nodes at the given level.
   * @param node the current node
   * @param level the level we want to traverse
   * @param currLevel the current level that we are traversing
   */
  private static void nodeLevelTraversal(BinaryTreeNode<Integer> node, int level, int currLevel) {
    if (currLevel == level && node != null) {
      System.out.println(node);
    } else if (currLevel < level) {
      nodeLevelTraversal(node.getLeft(), level, currLevel + 1);
      nodeLevelTraversal(node.getRight(), level, currLevel + 1);
    }
  }
}
