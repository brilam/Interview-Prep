package interview.priceline;

import java.util.HashSet;
import java.util.Set;

public class IntersectTwoLL {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {    
    int length1 = getLength(headA);
    int length2 = getLength(headB);
   
    int diff = Math.abs(length2 - length1);
    
    if (length2 > length1) {      
      ListNode startingHead = getNewHead(headB, diff);
      return findMatchingNode(startingHead, headA);
      
    } else {
      ListNode startingHead = getNewHead(headA, diff);
      return findMatchingNode(startingHead, headB);
    }
  }
  
  public static int getLength(ListNode headNode) {
    ListNode curr = headNode;
    int length = 0;
    
    String msg = "";
    while (curr != null) {
      length++;
      msg += String.format("%d->", curr.val);
      curr = curr.next;
    }
    return length;
  }
  
  public static ListNode getNewHead(ListNode headNode, int diff) {
    ListNode startingHead = headNode;
    int index  = 0;
    while (index < diff) {
      startingHead = startingHead.next;
      index++;
    }
    return startingHead;
  }
  
  /**
   * Returns the first intersection node.
   * @param list1
   * @param list2
   * @return
   */
  public static ListNode findMatchingNode(ListNode list1, ListNode list2) {
    ListNode list1Curr = list1;
    ListNode list2Curr = list2;
    
    ListNode matchingNode = null;
    
    while (list1Curr != null) {
      if (list1Curr.val == list2Curr.val && matchingNode == null) {
        matchingNode = list1Curr;
      } else if (list1Curr.val != list2Curr.val && matchingNode != null) {
        matchingNode = null;
      }
      
      list1Curr = list1Curr.next;
      list2Curr = list2Curr.next;
    }
    return matchingNode;
  }


  public static void main(String[] args) {
    // LinkedList 1
    ListNode ln = new ListNode(2);
    ListNode ln1 = new ListNode(3);
    ListNode ln2 = new ListNode(5);
    ListNode ln3 = new ListNode(7);
    ListNode ln4 =  new ListNode(4);
    ln.next = ln1;
    ln1.next = ln2;
    ln2.next = ln3;
    ln3.next = ln4;
    
    // LinkedList 2
    ListNode ln5 = new ListNode(7);
    ListNode ln6 =  new ListNode(4);
    //ListNode ln7 =  new ListNode(4);
    ln5.next = ln6;
    //ln6.next = ln7;


    System.out.println(getIntersectionNode(ln, ln5));

  }

}
