package arrays.array;

public class OrderArray {
    private long[] a;
    private int nElems;

    public OrderArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public int getSize() {
        return nElems;
    }

    public int find(long value) { // we are using binary search to find an element
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while(true) {
            curIn = (lowerBound + upperBound) / 2;
            if(a[curIn] == value)
                return curIn;
            else if(lowerBound > upperBound)
                return nElems;

            else {
                if(a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
       int j;
       for(j = 0; j < nElems; j++)
           if(a[j] > value)
               break;

       for(int k = nElems; k > j; k--)
           a[k] = a[k - 1];

       a[j] = value;
       nElems++;
    }

    public boolean delete(long value) {

        int j = find(value); // if has been found (using the find method)

        if(j == nElems) // if we area at the end
            return false; // could not find it
        else { // found it
            // if element was found in the array
            // move elements to a lower position
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


    private static void addElements(OrderArray arr) {
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
    }

    public static void main(String[] args) {

        int size = 100;
        OrderArray arr;
        arr = new OrderArray(size);

        addElements(arr);

        System.out.println("\nDisplay array in order");

        arr.display();

        System.out.println("\nInserting element to the array");
        arr.insert(45);

        // find element in array
        int searchKey = 11;
        if(arr.find(searchKey) != arr.getSize())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Could not find " + searchKey);

        arr.display();

        arr.delete(77);
        arr.delete(00);
        arr.delete(33);

        System.out.println("Array after deletion");
        arr.display();
    }
}
