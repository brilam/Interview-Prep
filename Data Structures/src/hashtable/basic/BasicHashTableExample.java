package hashtable.basic;


public class BasicHashTableExample {
  /**
   * Demonstrates the usage of BasicHashTableExample by adding two key-value pairs. There are no
   * collisions here and no need for resizing.
   * 
   * @param args no arguments needed
   */
  public static void main(String[] args) {
    BasicHashTable bht = new BasicHashTable();
    bht.put("Hello", "World");
    bht.put("Bye", "Bye!");
    System.out.println(bht.get("Hello"));
    System.out.println(bht.get("Bye"));
    System.out.println(bht.get("Woo!"));
  }
}
