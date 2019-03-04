package HashMap.linear_probing;

public class HashTable {
    private HashItem[] hashTable;

    public HashTable() {
        hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public void put(int key, int value) {
        int generatedIndex = hashFunction(key); // create index
        System.out.println("put() method called with value " + value + " -generated index= " + generatedIndex);

        while(hashTable[generatedIndex] != null) {
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE; // make sure we don't get array index of bound exc
            System.out.println("Collision -> nextIndex " + generatedIndex);
        }
        System.out.println("Inserted finally at index " + generatedIndex);
        hashTable[generatedIndex] = new HashItem(key, value); // insert new item into the generated index
    }

    public int get(int key) {
        int generatedIndex = hashFunction(key);

        // if key are not matching and the hashtable is not empty
        while(hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey() != key) {
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Hopping to the next index: " + generatedIndex);
        }

        // can't find
        if(hashTable[generatedIndex] == null) {
            return -1;
        } else { // found it
            return hashTable[generatedIndex].getValue(); //return the value of the hashtable index value
        }
    }

    private int hashFunction(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
