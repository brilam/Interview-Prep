package infor;

import java.util.HashSet;
import java.util.Set;

public class SomethingElse {
  public static void main(String[] args) {
    String[] arrB = {"hi", "like"};
    String[] arrA = {"bye", "hi"};

    System.out.println(isInBoth("hi", arrA, arrB));
  }

  public boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
    boolean found = false;
    Set<String> values = new HashSet<>();
    
    if (arrayA.length == 0 || arrayB.length == 0) {
      return found;
    }
    
    boolean isContainedInA = addToValues(values, arrayA, value);
    
    if (!isContainedInA) {
      return found;
    }
    
    boolean isContainedInB = addToValues(values, arrayB, value);
    
    if (!isContainedInB) {
      return found;
    } else {
      found = true;
    }
    
    return found;
  }

  private boolean addToValues(Set<String> values, String[] arr, String value) {
    boolean isContainedIn = false;
    // O(n) operation to add all arrayA characters
    for (String somethingInA : arr) {
      if (somethingInA.equals(value)) {
        isContainedIn = true;
      }
      values.add(somethingInA);
    }
    return isContainedIn;
  }

}
