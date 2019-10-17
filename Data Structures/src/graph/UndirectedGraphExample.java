package graph;

public class UndirectedGraphExample {
  public static void main(String[] args) {
    UndirectedGraph<Integer> udg = new UndirectedGraph<>();
    GraphNode<Integer> node1 = new GraphNode<>(1);
    GraphNode<Integer> node2 = new GraphNode<>(2);
    GraphNode<Integer> node3 = new GraphNode<>(3);


    udg.addNode(node1);
    udg.addNode(node2);
    udg.addNode(node3);
    udg.addEdge(node1, node2);
    udg.addEdge(node1, node3);
    
    System.out.println(udg);
  }
}
