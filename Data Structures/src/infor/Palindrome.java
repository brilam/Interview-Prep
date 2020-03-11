package infor;

public class Palindrome {
  /**
   * Returns if the word is a palindrome.
   * @param word the word to check
   * @return if the word is a palindrome
   */
  public static boolean isPalindrome(String word) {
    if (word.length() == 0 || word.length() == 1) {
      return true;
    } else {
      // Right index starts at last character and moves towards the left
      int rightIndex = word.length() - 1;
      for (int index = 0; index < word.length() / 2; index++) {
        if (!(word.charAt(index) == word.charAt(rightIndex))) {
          return false;
        }
        rightIndex--;
      }
    }
    return true;
  }
  
  public static boolean isPalindromeRecursive(String word) {
    if (word.length() == 0 || word.length() == 1) {
      return true;
    } else {
      int index = 0;
      int rightIndex = word.length() - 1;
      if (!(word.charAt(index) == word.charAt(rightIndex))) {
        return false;
      } else {
        isPalindromeRecursive(word.substring(1, rightIndex));
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String[] words = {"", "h", "hello", "hi", "dad", "bye"};
    for (String word : words) {
      System.out.println(isPalindrome(word));
    }
    System.out.println("\n\nRECURSIVE:");
    for (String word : words) {
      System.out.println(isPalindromeRecursive(word));
    }
    
  }
}
