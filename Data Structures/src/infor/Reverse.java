package infor;

public class Reverse {
  /**
   * Returns the word reversed.
   * @param word the word to reverse
   * @return the reversed word
   */
  public static String reverseWord(String word) {
    StringBuilder sb = new StringBuilder(word);
    
    int startIndex  = 0;
    int endIndex = sb.length() - 1;
    
    while (startIndex < sb.length() / 2) {
      char leftChar = sb.charAt(startIndex);
      char rightChar =  sb.charAt(endIndex);
      sb.setCharAt(startIndex, rightChar);
      sb.setCharAt(endIndex, leftChar);
      startIndex++;
      endIndex--;
    }
    return sb.toString();
  }
  
  /**
   * Reverses the sentence reversed. 
   * @param sentence the sentence to reverse
   * @return the sentence reversed
   */
  public static String reverseSentence(String sentence) {
    // Splitting is an O(n) algorithm
    String[] split = sentence.split(" ");
    
    int startIndex  = 0;
    int endIndex = split.length - 1;
    
    // O(n) time to swap
    while (startIndex < split.length / 2) {
      String beginningWord = split[startIndex];
      String endingWord = split[endIndex];
      split[startIndex] = endingWord;
      split[endIndex] = beginningWord;
      startIndex++;
      endIndex--;
    }
    
    // O(n) time to add to array
    StringBuilder sb = new StringBuilder();
    for (int index = 0; index < split.length; index++) {
      sb.append(split[index]);
      if (index != split.length - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    String[] words = {"", "h", "hello", "hi", "dad", "bye"};
    for (String word : words) {
      System.out.println(reverseWord(word));
    }
    System.out.println(reverseSentence("Hello World"));
  }
}
