package hashtable.basic;

/**
 * A HashTable that only takes in String key-value pairs. Type checking
 * is done with each operation. This HashTable is not meant to be
 * any means "complicated". It just demonstrates the concept of how a
 * basic hashtable works conceptually. There is no resizing or handling
 * of collision in any way. In this way, the Hashtable is perfect with
 * the driver code given (no collision or resizing needed) as the hashtable can 
 * contain all the elements without any problems.
 * @author Brian
 * @param <K> the type of the keys
 * @param <V> the type of the values
 */
public class PerfectStringHashTable<K, V> {
  // These have to be explicitly casted due to Java not allowing generic type arrays
  public K[] keys = (K[]) new Object[10];
  public V[] values = (V[]) new Object[10];
  
  /**
   * Returns a hashed value for the key (this isn't the index!). The hashed value
   * in this case is just the ASCII code for the first character. This is
   * an O(1) operation.
   * @param key the key to be hashed
   * @return a hashed value for the key (this isn't the index!)
   * @throws InvalidDataTypeException if the key isn't a String
   */
  public int hashKey(K key) throws InvalidDataTypeException {
    if (key instanceof String) {
      String converted = (String) key;
      return converted.charAt(0);
    }
    throw new InvalidDataTypeException("Invalid type for key. Must be String!");
  }
  
  /**
   * Returns the value for a particular key. This is an O(1) operation.
   * @param key the key to look for in the hashtable
   * @return the value for the particular key
   * @throws InvalidDataTypeException if the key isn't a String
   */
  public V get(K key) throws InvalidDataTypeException  {
    if (key instanceof String) {
      int index = hashKey(key) % 10;
      return values[index];
    }
    throw new InvalidDataTypeException("Invalid data type for key. Must be String!");
  }
  
  /**
   * Puts the key and value pair (the key is associated with that value) in the hashtable.
   * This is an O(1) operation.
   * @param key the key to place into the hashtable
   * @param value the value to place for the key in the hashtable
   * @throws InvalidDataTypeException if the key or value is not a String
   */
  public void put(K key, V value) throws InvalidDataTypeException {
    int index = hashKey(key) % 10;
    if (key instanceof String && value instanceof String) {
      keys[index] = key;
      values[index] = value;
    } else {
      throw new InvalidDataTypeException("Invalid data type for key and values. Must be String!");
    }
  }
}
