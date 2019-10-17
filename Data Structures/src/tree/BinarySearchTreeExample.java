package tree;

public class BinarySearchTreeExample {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(9);
    bst.add(new BinaryTreeNode<>(6));
    bst.add(new BinaryTreeNode<>(10));
    bst.add(new BinaryTreeNode<>(7));
    bst.add(new BinaryTreeNode<>(5));
    bst.add(new BinaryTreeNode<>(3));
    bst.inOrderTraversal();
    /*bst.delete(new BinaryTreeNode<Integer>(6));
    System.out.println("After deletion:\n");
    bst.inOrderTraversal();*/
    System.out.println("\nFind path: ");
    System.out.println(bst.findPath(new BinaryTreeNode<>(7)));
    System.out.println("\nLowest common ancestor:");
    System.out.println(bst.lowestCommonAncestor(new BinaryTreeNode<>(3), new BinaryTreeNode<>(7)));
  }
}
