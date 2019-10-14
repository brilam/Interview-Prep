package hashtable.basic;


public class BasicHashTableExample {
  /**
   * Demonstrates the usage of BasicHashTableExample by adding two key-value pairs. There are no
   * collisions here and no need for resizing.
   * 
   * @param args no arguments needed
   */
  public static void main(String[] args) {
    BasicHashTable shs = new BasicHashTable();
    shs.put("Hello", "World");
    shs.put("Bye", "Bye!");
    System.out.println(shs.get("Hello"));
    System.out.println(shs.get("Bye"));
    System.out.println(shs.get("Woo!"));
  }
}
