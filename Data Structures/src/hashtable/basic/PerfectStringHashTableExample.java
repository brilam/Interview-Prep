package hashtable.basic;

public class PerfectStringHashTableExample {
  /**
   * Demonstrates the usage of PerfectStringHashtable by adding two key-value pairs.
   * There are no collisions here and no need for resizing.
   * @param args no arguments needed
   */
  public static void main(String[] args) {
    PerfectStringHashTable<String, String> shs = new PerfectStringHashTable<>();
    try {
      shs.put("Hello", "World");
      shs.put("Bye", "Bye!");
      System.out.println(shs.get("Hello"));
      System.out.println(shs.get("Bye"));
    } catch (InvalidDataTypeException e) {
      e.printStackTrace();
    }
  }
}
