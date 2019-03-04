package HashMap.linear_probing;

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
        System.out.println();

        System.out.println("Found " + ht.get(2));

    }
}
