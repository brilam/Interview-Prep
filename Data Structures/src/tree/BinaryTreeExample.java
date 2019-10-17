package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeExample {
  private List<BinaryTreeNode<Integer>> path;
  
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
    System.out.println("\nPath: ");
    BinaryTreeExample bte = new BinaryTreeExample();
    System.out
        .println(bte.leastCommonAncestor(root, new BinaryTreeNode<>(2), new BinaryTreeNode<>(0)));
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
  
  /**
   * Returns the least common ancestor of two nodes given the root node of the tree.
   * @param rootNode the root node of the tree
   * @param node1 the first node to look for an ancestor for
   * @param node2 the second node to look for an ancestor for
   * @return the least common ancestor of two nodes given the root node of the tree
   */
  private BinaryTreeNode<Integer> leastCommonAncestor(BinaryTreeNode<Integer> rootNode,
      BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
    List<BinaryTreeNode<Integer>> path1 = findPath(rootNode, node1);
    List<BinaryTreeNode<Integer>> path2 = findPath(rootNode, node2);
    
    int times = Math.min(path1.size(), path2.size());
    
    for (int index = 0; index < times; index++) {
      if (!path1.get(index).equals(path2.get(index))) {
        return path1.get(index - 1);
      }
    }
    
    if (path1.size() < path2.size()) {
      return path1.get(path1.size() - 1);
    }
    return path2.get(path2.size() - 1);
  }
  
  /**
   * Returns the path to the node from the root.
   * @param root the root of the tree
   * @param node the node to look for
   * @return the path to the node from the root
   */
  private List<BinaryTreeNode<Integer>> findPath(BinaryTreeNode<Integer> root,
      BinaryTreeNode<Integer> node) {
    path = new ArrayList<>();
    findPathHelper(root, node);
    return path;
  }
  
  /**
   * Returns if the path to the node exists from the root node.
   * @param rootNode the root node
   * @param node the node to look for
   * @return if the path to the node exists from the root nod
   */
  private boolean findPathHelper(BinaryTreeNode<Integer> rootNode,
      BinaryTreeNode<Integer> node) {
    // If we've reached the end of the tree, we are done
    if (rootNode == null) {
      return false;
    }
    
    // Add the root node to the path for now
    path.add(rootNode);
    
    // If we found the node, we've found the path
    if (rootNode.equals(node)) {
      return true;
    }
    
    // If there exists a left subtree, we can still find a path
    if (rootNode.getLeft() != null && findPathHelper(rootNode.getLeft(), node)) {
      return true;
    }
    
    // If there exists a right subtree, we can still find a path
    if (rootNode.getRight() != null && findPathHelper(rootNode.getRight(), node)) {
      return true;
    }
    
    /* If it is not found or we've gone through both the left and right subtree,
     * it is not possible. Remove the last node added.
     */
    path.remove(rootNode);
    return false; 
  }
}
