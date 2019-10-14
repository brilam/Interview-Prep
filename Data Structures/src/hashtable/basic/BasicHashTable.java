package hashtable.basic;

import hashtable.KeyValuePair;

/**
 * A HashTable that only takes in String key-value pairs. This HashTable is not 
 * meant to be any means "complicated". It just demonstrates the concept of how a
 * basic hashtable works conceptually. There is no resizing or handling
 * of collision in any way. In this way, the Hashtable is perfect with
 * the example code given (no collision or resizing needed) as the hashtable can 
 * contain all the elements without any problems.
 * @author Brian
 */
public class BasicHashTable {
  private int size;
  private KeyValuePair[] keysAndValues;
  
  /**
   * Creates MyHashTable (default size is 10).
   */
  public BasicHashTable() {
    // Sets default size for the hashtable
    this.size = 10;
    keysAndValues = new KeyValuePair[size];
  }
  
  /**
   * Creates MyHashTable with a set size.
   * @param size the size to set
   */
  public BasicHashTable(int size) {
    this.size = size;
    keysAndValues = new KeyValuePair[size];
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
   * Returns the value for a particular key. This is an O(1) operation.
   * @param key the key to look for in the hashtable
   * @return the value for the particular key
   */
  public String get(String key) {
    int index = hashKey(key) % size;
    if (keysAndValues[index] == null) {
      return "Not in the hashtable";
    }
    if (keysAndValues[index].getKey().equals(key)) {
      return keysAndValues[index].getValue();
    } else {
      return "Not in the hashtable!";
    }
  }
  
  /**
   * Puts the key and value pair (the key is associated with that value) in the hashtable.
   * This is an O(1) operation.
   * @param key the key to place into the hashtable
   * @param value the value to place for the key in the hashtable
   */
  public void put(String key, String value) {
    int index = hashKey(key) % size;
    keysAndValues[index] = new KeyValuePair(key, value);
  }
}
