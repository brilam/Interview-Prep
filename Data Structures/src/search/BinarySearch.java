package search;

public class BinarySearch {
  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5};
    System.out.println(binarySearch(numbers, 5));
  }
  
  /**
   * Returns the index where the number is found in array using
   * iterative binary search. If it is not found, return -1.
   * @param numbers the array of numbers
   * @param number the number to find in the array
   * @return the index where the number is found. If not found, -1
   */
  private static int binarySearch(int[] numbers, int number) {
    int start = 0;
    int end = numbers.length - 1;
    
    while (start <= end) {
      int middle = (start + end) / 2;
      
      if (number < numbers[middle]) {
        end = middle - 1;
      } else if (number > numbers[middle]) {
        start = middle + 1;
      } else {
        return middle;
      }
    }
    return -1;
  }
}
