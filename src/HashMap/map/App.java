package HashMap.map;

public class App {
    public static void main(String[] args) {

        HashTable ht = new HashTable();

        ht.put(1, 10);
        System.out.println();
        ht.put(2, 100);
        System.out.println();
        ht.put(3, 1000);
        System.out.println();
        ht.put(4, 10000);
        ht.put(5, 10);
        System.out.println();
        ht.put(6, 100);
        System.out.println();
        ht.put(7, 1000);
        System.out.println();
        ht.put(8, 10000);
        ht.put(9, 10);
        System.out.println();
        ht.put(10, 100);
        System.out.println();
        ht.put(11, 1000); // collision (hashtable size is 10)
        System.out.println();
        ht.put(12, 10000); // collision (hashtable size is 10)

        System.out.println("returned " + ht.get(3));
    }
}
