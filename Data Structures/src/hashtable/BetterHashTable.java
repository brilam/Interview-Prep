package hashtable;

import java.util.LinkedList;

/**
 * Similar to BasicHashTable but "better" ;-) This
 * HashTable resizes once it hits a particular size
 * (initial factor * size), and it uses chaining
 * by LinkedLists when two keys map to the same index.
 * @author brian
 *
 */
public class BetterHashTable {
  private int size;
  private int currSize = 0;
  private double initialCapacity = 0.75;
  private LinkedList<KeyValuePair>[] keysAndValues;
  
  /**
   * Creates BetterHashTable (default size is 10).
   */
  public BetterHashTable() {
    this.size = 10;
    // Explicitly casting this is required since Java doesn't allow generic arrays
    keysAndValues = (LinkedList<KeyValuePair>[]) new LinkedList[size];
  }
  
  /**
   * Creates BetterHashTable with given size.
   * @param size the size for BetterHashTable
   */
  public BetterHashTable(int size) {
    this.size = size;
    // Explicitly casting this is required since Java doesn't allow generic arrays
    keysAndValues = (LinkedList<KeyValuePair>[]) new LinkedList[size];
  }
  
  /**
   * Returns a hashed value for the key (this isn't the index!). The hashed value
   * in this case is just the ASCII code for the first character. This is
   * an O(1) operation.
   * @param key the key to be hashed
   * @return a hashed value for the key (this isn't the index!)
   */
  public int hashKey(String key) {
    return key.charAt(0);
  }
  
  /**
   * Returns the value for a particular key. This is now an O(n) operation
   * due to chaining which is done by a LinkedList.
   * @param key the key to look for in the hashtable
   * @return the value for the particular key
   */
  public String get(String key) {
    int index = hashKey(key) % size;
    
    /* If there is no LinkedList in that current index, it is not
       in the has table */
    if (keysAndValues[index] == null) {
      return "Not in the hashtable";
    }
    
    for (KeyValuePair kvp: keysAndValues[index]) {
      if (kvp.getKey().equals(key)) {
        return kvp.getValue();
      }
    }
    return "Not in the hashtable";
  }
  
  private void resizeArray() {
    this.size = size * 2;
    // Explicitly casting this is required since Java doesn't allow generic arrays
    LinkedList<KeyValuePair>[] biggerKeysAndValues = 
        (LinkedList<KeyValuePair>[]) new LinkedList[size];
    for (int i = 0; i < keysAndValues.length; i++) {
      biggerKeysAndValues[i] = keysAndValues[i];
    }
    keysAndValues = biggerKeysAndValues;
  }
  
  /**
   * Puts the key and value pair (the key is associated with that value) in the hashtable.
   * This is now an O(n) operation since there is chaining which
   * is done by LinkedLists.
   * @param key the key to place into the hashtable
   * @param value the value to place for the key in the hashtable
   */
  public void put(String key, String value) {
    int index = hashKey(key) % size;
    
    if (currSize >= (int) (initialCapacity * size)) {
      resizeArray();
    }
    
    // If there is no LinkedList at that index, then add LinkedList
    if (keysAndValues[index] == null) {
      LinkedList<KeyValuePair> lkp = new LinkedList<>();
      lkp.add(new KeyValuePair(key, value));
      keysAndValues[index] = lkp;
      currSize++;
    } else {
      /* Otherwise, if LinkedList exists, traverse it and see
       * if it already exists, and if so, it is updating the
       * value of the key.
       */
      for (KeyValuePair kvp: keysAndValues[index]) {
        if (kvp.getKey().equals(key)) {
          kvp.setValue(value);
          return;
        }
      }
      /* If there is no existing key, you can just add it to the
       * end of the LinkedList
       */
      keysAndValues[index].add(new KeyValuePair(key, value));
    }
  }
}
