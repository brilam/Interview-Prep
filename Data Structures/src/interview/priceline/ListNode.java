package interview.priceline;

public class ListNode {
  int val;
  ListNode next;
  ListNode tail;

  public ListNode(int x) {
    val = x;
    next = null;
  }
  
  
  public String toString() {
    return String.format("%d", val);
  }
}
