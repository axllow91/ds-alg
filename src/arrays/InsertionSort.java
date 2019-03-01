package arrays;

/*
* Insertion sort algorithm
* */
public class InsertionSort {

    // insertion-sort of an array of characters into non decreasing order
    public static void insertionSort(char[] data) {
        int n = data.length;
        // starting at pos 1 to make the change possible
        for(int k = 1; k < n; k++) {
            char curr = data[k];
            int j = k;
            // check for each time the element at a lower position is greater than the current elem
            while(j > 0 && data[j - 1] > curr) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = curr;
        }
    }

    public static void main(String[] args) {

    }
}
