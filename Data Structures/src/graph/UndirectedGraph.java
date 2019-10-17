package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UndirectedGraph<T extends Comparable<T>> {
  private List<GraphNode<T>> nodes;
  private Map<GraphNode<T>, List<GraphNode<T>>> edges;
  private Stack<GraphNode<T>> visited;
  
  public UndirectedGraph() {
    this.nodes = new ArrayList<>();
    this.edges = new HashMap<>();
    this.visited = new Stack<>();
  }
  
  public void addNode(GraphNode<T> node) {
    nodes.add(node);
    edges.put(node, new ArrayList<>());
  }
  
  public void addEdge(GraphNode<T> node1, GraphNode<T> node2) {
    if (edges.get(node1) != null) {
      edges.get(node1).add(node2);
    }
    
    if (edges.get(node2) != null) {
      edges.get(node2).add(node1);
    }
  }
  
  public String toString() {
    String result = "";
    for (GraphNode<T> node: edges.keySet()) {
      if (edges.get(node).isEmpty()) {
        result += node + ";";
      } else {
        for (GraphNode<T> children: edges.get(node)) {
          result += node + "->" + children + ";";
        }
      }
    }
    return result;
  }
}   
