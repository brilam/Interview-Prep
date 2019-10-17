package graph;

public class GraphNode<T extends Comparable<T>> implements Comparable {
  private T value;

  public GraphNode(T value) {
    this.value = value;
  }

  public String toString() {
    return value.toString();
  }

  public T getValue() {
    return value;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof GraphNode) {
      GraphNode<T> gn = (GraphNode<T>) o;
      System.out.println("Comparing: " + this.getValue() + " with " + gn.getValue());
      return this.getValue().compareTo(gn.getValue());
    }
    return 0;
  }
}
