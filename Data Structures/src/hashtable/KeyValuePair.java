package hashtable;

public class KeyValuePair {
  private String key;
  private String value;

  /**
   * Creates a key-value pair.
   * @param key the key
   * @param value the value
   */
  public KeyValuePair(String key, String value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Returns the key to the key-value pair.
   * @return the key to the key-value pair
   */
  public String getKey() {
    return key;
  }

  /**
   * Returns the value to the key-value pair.
   * @return the value to the value pair
   */
  public String getValue() {
    return value;
  }
}
