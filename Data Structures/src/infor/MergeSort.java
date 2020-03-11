package infor;

import java.util.ArrayList;

public class MergeSort {
  public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
    ArrayList<Integer> leftSublist = new ArrayList<>();
    ArrayList<Integer> rightSublist = new ArrayList<>();
    
    // Base case: An array of size 1 is already sorted
    if (arr.size() == 1) {
      return arr;
    } else {
      // Loops through array and splits it into two sublists (left and right)
      for (int index = 0; index < arr.size(); index++) {
        if (index < arr.size() / 2) {
          leftSublist.add(arr.get(index));
        } else {
          rightSublist.add(arr.get(index));
        }
      }
      
      leftSublist = mergeSort(leftSublist);
      rightSublist = mergeSort(rightSublist); 
    }
    return merge(leftSublist, rightSublist);
  }
  
  private static ArrayList<Integer> merge(ArrayList<Integer> leftSublist, ArrayList<Integer> rightSublist) {
    ArrayList<Integer> results = new ArrayList<Integer>();
    
    // If both have elements
    while (leftSublist.size() > 0 && rightSublist.size() > 0) {
      if (leftSublist.get(0) < rightSublist.get(0)) {
        results.add(leftSublist.get(0));
        leftSublist.remove(0);
      } else {
        results.add(rightSublist.get(0));
        rightSublist.remove(0);
      }
    }
    
    // Right side is empty
    while (leftSublist.size() > 0) {
      results.addAll(leftSublist);
      leftSublist.clear();
    }
    
    // Left side is empty
    while (rightSublist.size() > 0) {
      results.addAll(rightSublist);
      rightSublist.clear();
    }
    
    return results;
  }
  
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(7);
    arr.add(2);
    arr.add(8);
    arr.add(5);
    arr.add(3);
    System.out.println(mergeSort(arr));
  }
}
