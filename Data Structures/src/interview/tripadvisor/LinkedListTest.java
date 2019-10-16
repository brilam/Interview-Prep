package interview.tripadvisor;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>(1);
    ll.addToTail(2);
    ll.reverse();
    System.out.println(ll);
  }
}
