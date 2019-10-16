package interview.tripadvisor;

/**
 * This class represents a Linkedlist.
 * @author Brian
 * @param <T> the type of the data in the LinkedlIst
 */
public class LinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  
  /**
   * Creates a LinkedList with the given data as its head.
   * @param val the value of the data
   */
  public LinkedList(T val) {
    this.head = new Node<T>(val);
  }
  
  /**
   * Returns the head of the LinkedList.
   * @return the head of the LinkedList
   */
  public Node<T> getHead() {
    return head;
  }
  
  /**
   * Returns the tail of the LinkedList.
   * @return
   */
  public Node<T> getTail() {
    return tail;
  }
  
  /**
   * Adds a node with the given value to the tail of the LinkedList.
   * @param val the value to add to the LinkedList
   */
  public void addToTail(T val) {
    Node<T> newNode = new Node<T>(val);

    if (head == null) {
      head = newNode;
      tail = newNode; 
    } else {
      Node<T> currNode = head;
      while (currNode != null) {
        if (currNode.getNext() == null) {
          currNode.setNext(newNode);
          tail = newNode;
          return;
        }
        currNode = currNode.getNext();
      }
    }
  }
  
  /**
   * Reverses the LinkedList.
   */
  public void reverse() {
    Node<T> currNode = head;
    Node<T> prevNode = null;
    Node<T> nextNode = null;

    while (currNode != null) {
      nextNode = currNode.getNext();
      currNode.setNext(prevNode);
      prevNode = currNode;
      currNode = nextNode;
    }
    head = prevNode;
  }
  
  @Override
  public String toString() {
    String message = "";
    Node<T> currNode = head;
    while (currNode != null) {
      message += currNode + "->";
      currNode = currNode.getNext();
    }
    return message;
  }
}
