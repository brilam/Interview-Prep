package tree;

/**
 * This class is used to represent a node in a binary tree.
 * @author Brian
 * @param <T> the type for the binary tree node
 */
public class BinaryTreeNode<T> {
  private T val;
  private BinaryTreeNode<T> left = null;
  private BinaryTreeNode<T> right = null;
  
  /**
   * Creates a BinaryTreeNode with the given value.
   * @param val the value for the newly created BinaryTreeNode
   */
  public BinaryTreeNode(T val) {
    this.val = val;
  }
  
  /**
   * Creates a BinaryTreeNode with the given left and right children.
   * @param val the value for the newly created BinaryTreeNode
   * @param left the left BinaryTreeNode
   * @param right the right BinaryTreeNode
   */
  public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
  
  /**
   * Sets the left child of the binary tree node.
   * @param left the left child of the binary tree node
   */
  public void setLeft(BinaryTreeNode<T> left) {
    this.left = left;
  }
  
  /**
   * Sets the right child of the binary tree node.
   * @param right the right child of the binary tree node
   */
  public void setRight(BinaryTreeNode<T> right) {
    this.right = right;
  }
  
  /**
   * Returns the value for the current binary tree node.
   * @return the value for the current binary tree node
   */
  public T getValue() {
    return val;
  }
  
  /**
   * Returns the value for the left child of the binary tree node.
   * @return the value for the left child of the binary tree node
   */
  public BinaryTreeNode<T> getLeft() {
    return left;
  }
  
  /**
   * Returns the value for the right child of the binary tree node.
   * @return the value for the right child of the binary tree node
   */
  public BinaryTreeNode<T> getRight() {
    return right;
  }
  
  /**
   * Returns the String for the value of the current binary tree node.
   */
  public String toString() {
    return val.toString();
  }
}
