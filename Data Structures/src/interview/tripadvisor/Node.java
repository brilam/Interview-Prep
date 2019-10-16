package interview.tripadvisor;

public class Node<T> {
  private T value;
  private Node<T> next;
 
  public Node(T value) {
    this.value = value;
  }
  
  public void setNext(Node<T> next) {
    this.next = next;
  }
  
  public Node<T> getNext() {
    return next;
  }
  
  @Override
  public String toString() {
    return value.toString();
  }
}
