package hashtable;

public class BetterHashtableExample {
  public static void main(String[] args) {
    BetterHashTable bht = new BetterHashTable();
    bht.put("Hi", "World!");
    System.out.println(bht.get("Hi"));
    bht.put("Hi", "Blah!");
    System.out.println(bht.get("Hi"));
    bht.put("Hello", "World!");
    System.out.println(bht.get("Hello"));
    bht.put("A", "Apple");
    bht.put("Bye", "World");
    bht.put("C", "Cat");
    bht.put("D", "Dog");
    bht.put("E", "Elephant");
    bht.put("F", "Frog");
    bht.put("G", "Gopher");
    bht.put("H", "Helix");
    System.out.println(bht.get("H"));
  }
}
