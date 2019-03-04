package HashMap.map;

public class HashTable {
    private HashItem[] hashTable; // array of hash items


    public HashTable() {
        // construct new hashtable with the size
        hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    // getting a key and make sure the
    // hash will be between  0 and size of the hash table
    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }


    public void put(int key, int value) {
        int hashArrayIndex = hash(key);

        if(hashTable[hashArrayIndex] == null) {
            System.out.println("No collision simple insertion...");
            // we can add new hash item into hash table
            hashTable[hashArrayIndex] = new HashItem(key, value);
        } else { // it is a collision
            System.out.println("Collision when inserting with key " + key);
            HashItem hashItem = hashTable[hashArrayIndex];

            // iterate until next hash item is null
            while(hashItem.getNextHashItem() != null) {
                hashItem = hashItem.getNextHashItem(); // consider next item if not null
                System.out.println("Considering the next item in the linked list " + hashItem.getValue());
            }

            System.out.println("Finally we have found the place to insert...");
            hashItem.setNextHashItem(new HashItem(key, value)); // set next hash item with the new hash item we want to insert
        }
    }

    public int get(int key) {
        int generatedArrayIndex = hash(key);

        if(hashTable[generatedArrayIndex] == null) {
            return -1; // or throw some exception
        } else { // search for the given item
            HashItem hashItem = hashTable[generatedArrayIndex];
            // make sure the hash item is not null and the keys are not the same
            while(hashItem != null && hashItem.getKey() != key) {
                hashItem = hashItem.getNextHashItem(); // 23 --> 45 --> [100] found
            }

            if(hashItem == null) {
                return -1;
            } else {
                return hashItem.getValue();
            }
        }
    }

}
