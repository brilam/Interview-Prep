package interview.priceline;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  
  /**
   * Solves the two sum problem using merge sort and binary search.
   * @param arr the array to sort
   * @param target the target value to get
   * @return the indices of the two values that match the target. Returns {-1, -1} if there is no solution
   */
  public static int[] twoSumSort(int[] arr, int target) {
    int[] copy = arr;
    
    // n log n
    Arrays.sort(copy);
    
    // O(n)
    for (int index = 0; index < arr.length; index++) {
      // log n
      int secondIndex = doBinarySearch(arr, target - arr[index]);
      if (secondIndex != -1) {
        return new int[] {index, secondIndex};
      }
    }
    
    return new int[] {-1, -1}; 
  }
  
  public static int[] twoSumHash(int[] arr, int target) {
    Map<Integer, Integer> valToIndex = new HashMap<>();
    
    // O(n)
    for (int index = 0; index < arr.length; index++) {
      valToIndex.put(arr[index],  index);
    }
    
    for (int index = 0; index < arr.length; index++) {
      if (valToIndex.get(target - arr[index]) != null) {
        return new int[] {index, valToIndex.get(target - arr[index])};
      }
    }
    
    return new int[] {-1, -1};
  }
  
  public static int doBinarySearch(int[] sorted, int val) {
    int lower = 0;
    int higher = sorted.length - 1;
    
    while (lower <= higher) {
      int middleIndex = (lower + higher) / 2;

      if (sorted[middleIndex] == val) {
        return middleIndex;
      } else if (sorted[middleIndex] < val) {
        lower = middleIndex + 1;
        middleIndex =  (lower + higher) / 2;
      } else if (sorted[middleIndex] > val) {
        higher = middleIndex - 1;
        middleIndex =  (lower + higher) / 2;
      }
    }
    return -1;
  }
  
  public static int doBinarySearchRecursive(int lower, int higher, int[] sorted, int val) {
    int middleIndex = (lower + higher) / 2;
    System.out.println(String.format("Lower: %d Higher: %d", lower, higher));
    
    if (lower < higher) {
      if (sorted[middleIndex] == val) {
        return middleIndex;
      } else if (sorted[middleIndex] < val) {
        return doBinarySearchRecursive(middleIndex + 1, higher, sorted, val);
      } else if (sorted[middleIndex] > val) {
        return doBinarySearchRecursive(lower, middleIndex - 1, sorted, val);
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 5};
    System.out.println(Arrays.toString(twoSumHash(arr, 9)));
  }

}
