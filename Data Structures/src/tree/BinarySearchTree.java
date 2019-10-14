package tree;

public class BinarySearchTree<T> {
  private BinaryTreeNode<T> root;

  public BinarySearchTree(T val) {
    this.root = new BinaryTreeNode<T>(val);
  }
  
  public void add(BinaryTreeNode<T> node) {
    add(root, node);
  }
  
  public void add(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> node) {    
    // Case 1: If node < root node
    if (node.compareTo(rootNode) < 0) {
      if (rootNode.getLeft() == null) {
        rootNode.setLeft(node);
      } else {
        add(rootNode.getLeft(), node);
      }
    } else {
      if (rootNode.getRight() == null) {
        rootNode.setRight(node);
      } else {
        add(rootNode.getRight(), node);
      }
    }
  }
  
  public void delete(BinaryTreeNode<T> rootNode) {
    
  }
  
  public void inOrderTraversal() {
    inOrderTraversal(root);
  }
  
  /**
   * Prints how an in order traversal would look like for the binary tree.
   * In order is: left, current, right
   * @param node the root node
   */
  private void inOrderTraversal(BinaryTreeNode<T> node) {
    if (node != null) {
      inOrderTraversal(node.getLeft());
      System.out.print(node + " ");
      inOrderTraversal(node.getRight());
    }
  }
}
