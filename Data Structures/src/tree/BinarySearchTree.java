package tree;

/**
 * This class is used to represent a binary search
 * tree.
 * @author Brian
 * @param <T> the type that is stored in the binary search tree
 */
public class BinarySearchTree<T> {
  private BinaryTreeNode<T> root;

  /**
   * Creates a binary search tree with the value for the root node.
   * @param val the value for the root node
   */
  public BinarySearchTree(T val) {
    this.root = new BinaryTreeNode<T>(val);
  }
  
  /**
   * Returns the root of the binary search tree.
   * @return
   */
  public BinaryTreeNode<T> getRoot() {
    return root;
  }
  
  /**
   * Adds the node to the binary search tree.
   * @param node the node to add to the binary search tree
   */
  public void add(BinaryTreeNode<T> node) {
    add(root, node);
  }
  
  
  /**
   * Adds to the given root node the given node.
   * @param rootNode the root node to add to
   * @param node the node to add
   */
  private void add(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> node) {    
    // Case 1: If node < root node
    if (node.compareTo(rootNode) < 0) {
      if (rootNode.getLeft() == null) {
        rootNode.setLeft(node);
      } else {
        add(rootNode.getLeft(), node);
      }
    } else {
      // Case 2: If node > root node
      if (rootNode.getRight() == null) {
        rootNode.setRight(node);
      } else {
        add(rootNode.getRight(), node);
      }
    }
  }
  
  
  /**
   * Returns the in order successor of the given node.
   * @param node the node to find the in order successor for
   * @return the in order successor of the given node
   */
  private BinaryTreeNode<T> findInOrderSuccessor(BinaryTreeNode<T> node) {
    return findMinimumValue(node.getRight());
  }
  
  /**
   * Returns the minimum value to the given node.
   * @param node the node to find the minimum value for
   * @return the node to find the minimum value for
   */
  private BinaryTreeNode<T> findMinimumValue(BinaryTreeNode<T> node) {
    if (node.getLeft() == null) {
      return node;
    } else {
      return findMinimumValue(node.getLeft());
    }
  }
  
  /**
   * Deletes the given node from the binary search tree.
   * @param node the node to delete from the binary search tree
   */
  public void delete(BinaryTreeNode<T> node) {
    root = delete(root, node);
  }
  
  /**
   * Deletes the node from the tree rooted at the given root node.
   * @param rootNode the root node of the tree to delete from
   * @param node the node to delete
   * @return the root of the tree with the deleted node
   */
  private BinaryTreeNode<T> delete(BinaryTreeNode<T> rootNode, BinaryTreeNode<T> node) {
    if (rootNode == null) {
      return rootNode;
    }
    if (node.compareTo(rootNode) == 0) {
      if (rootNode.getLeft() == null) {
        return rootNode.getRight();
      } else if (rootNode.getRight() == null) {
        return rootNode.getLeft();
      } else {
        // Finds the in order successor and sets the root node as the in order successor
        BinaryTreeNode<T> inOrderSuccessor = findInOrderSuccessor(rootNode);
        rootNode.setValue(inOrderSuccessor.getValue());
        // Updates the right subtree with the in order successor deleted from the right subtree
        rootNode.setRight(delete(root.getRight(), inOrderSuccessor));
      }
    } else if (node.compareTo(rootNode) > 0) {
      // Updates the right subtree with whatever nodes are deleted or updated
      rootNode.setRight(delete(rootNode.getRight(), node));
    } else {
      // Updates the left subtree with whatever nodes are deleted or updated
      rootNode.setLeft(delete(rootNode.getLeft(), node));
    }
    return rootNode;
  }
  
  
  /**
   * Prints an in order traversal of the binary search tree.
   */
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
