package arrays.array;

public class HighArray {
    private long a[];
    private int nElems;

    public HighArray(int size) { // initialize array
        a = new long[size];
        nElems = 0;
    }

    public void insert(long value) { // inserting element into the array
        a[nElems] = value;
        nElems++;
    }

    public boolean find(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == value)
                break;

        if (j == nElems) // if we are at the end and could not find it
            return false;  // have not find it
        else
            return true; // found it
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == value)
                break;

        if(j == nElems)
            return false;  // can't find it
        else {
            for(int k = j; k < nElems; k++)
                a[k] = a[k + 1];

            nElems--;
            return true;
        }
    }

    public void display() {
        for(int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        System.out.println("Displaying array");
        arr.display();

        System.out.println("Finding an element in the array: ");
        int searchKey = 00;

        if(arr.find(searchKey))
            System.out.println("Found element " + searchKey);
        else
            System.out.println("Couldn't find element " + searchKey + " in the array");

        System.out.println("Deleting one element from the array: ");
        arr.delete(00);

        arr.display();


    }
}
