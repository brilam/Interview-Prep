package interview.tripadvisor;

import java.util.Arrays;

public class FindPairsWithDifference {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(findDifference(numbers, 10));


  }

  public static int findDifference(int[] numbers, int k) {
    int numOfPairs = 0;
    
    for (int index = 0; index < numbers.length; index++) {
      int foundIndex = Arrays.binarySearch(numbers, numbers[index] + k);
      if (foundIndex != index && foundIndex >= 0) {
        numOfPairs++;
      }
    }
    return numOfPairs;
  }
}
