package HashMap.generic_hashtable;

import java.util.*;

public class App {
    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();

//        ht.put("a", 1);
//        System.out.println(ht.size());
//
//        ht.put("b", 2);
//        System.out.println(ht.size());
//
//        ht.put("c", 3);
//        System.out.println(ht.size());
//
//        ht.put("d", 4);
//        System.out.println(ht.size());
//
//        ht.put("e", 5);
//        System.out.println(ht.size());
//
//        ht.put("f", 6);
//        System.out.println(ht.size());
//
//        ht.put("g", 7);
//        System.out.println(ht.size());
//
//        ht.put("h", 8);
//        System.out.println(ht.size());
//
//        ht.put("i", 9);
//        System.out.println(ht.size());
//
//        ht.put("j", 10);
//        System.out.println(ht.size());
//
//        ht.put("k", 11);
//        System.out.println(ht.size());
//
//        ht.put("l", 12);
//        System.out.println(ht.size());
//
//        ht.put("m", 13);
//        System.out.println(ht.size());
//
//        ht.put("n", 14);
//        System.out.println(ht.size());
//
//        ht.put("p", 15);
//        System.out.println(ht.size());


        ht.put("Burga", 12);
        ht.put("Eva", 32);
        ht.put("Ella", 22);

        System.out.println(ht.get("Eva"));
        ht.remove("Eva");


        /**Maps in Collection
         * Map is an object that maps keys to values. Map cannot contain duplicate keys, each key
         * can map to at most one value
         *
         * Some map, like TreeMap class make specific guarantees as to their order, HashMap do not keep oder
         * TreeMap: sorted
         * HashTable: synchronized + slow + null keys or values are not allowed
         * HashMap: does not synchronize + allows one key to be null and any number of null values
         * HashFunction() -> O(1)
         * **/
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Me");
        map.put(2, "You");

        System.out.println(map.get(1));

        // THis is a sorted map
        Map<String, String> map1 = new TreeMap<>();
        map1.put("Me", "You");
        map1.put("You", "Me");
        map1.put("Tudu", "Metu");
        map1.put("Yoko", "Hama");

        Map<Integer, Integer> map2 = new Hashtable<>(); // can't have null keys + is synchronized

        map2.put(1, 10);
        map2.put(2, 20);
        map2.put(3, 30);
        map2.put(4, 400);

        // Iterating through a hashtable
        System.out.println("\nIterating through a hash table: ");
        map2.forEach((k, v) -> System.out.println(k + " " + v));

        // 1. Iterate through a map using Iterator
        System.out.println("\nIterate through a map using Iterator");
        Iterator<Map.Entry<String, String>> it = map1.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            System.out.println(pair.getKey() + ", "  + pair.getValue());
        }

        // 2. Using foreach and Map.Entry
        System.out.println("\nUsing foreach and Map.Entry");
        for(Map.Entry<String, String> pair : map1.entrySet()) {
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }

        // 3. Using keySet and foreach
        System.out.println("\nUsing keySet and foreach()");
        for(String key : map1.keySet()) {
            System.out.println(key + " " + map1.get(key));
        }

        // 4. Using foreach from java8
        System.out.println("\nUsing foreach from java8");
        map1.forEach((k,v) -> System.out.println(k + " " + v));

        // Using java& api stream
        System.out.println("\nUsing java8 Api Stream");
        map1
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

    }
}
