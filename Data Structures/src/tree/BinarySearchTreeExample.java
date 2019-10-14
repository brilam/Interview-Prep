package tree;

public class BinarySearchTreeExample {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(5);
    bst.add(new BinaryTreeNode<Integer>(2));
    bst.add(new BinaryTreeNode<Integer>(7));
    bst.add(new BinaryTreeNode<Integer>(1));
    bst.add(new BinaryTreeNode<Integer>(3));
    bst.add(new BinaryTreeNode<Integer>(6));
    bst.add(new BinaryTreeNode<Integer>(8));
    bst.inOrderTraversal();
  }
}
