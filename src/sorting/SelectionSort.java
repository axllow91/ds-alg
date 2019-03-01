package sorting;

/**Code for selection sort**/
public class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {
            int min = i; // selecting the new min
            for(int j = i + 1; j < n; j++)
                if(arr[j] < arr[min])
                    min = j; // assigning the new min value

            // swapping new min value
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    void printingArray(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();

        int[] a = {55, 13, 2, 6, 1, 0};

        System.out.println("Printing unsorted array");
        ss.printingArray(a);

        System.out.println("Sort the array with selection sort");
        ss.sort(a);
        ss.printingArray(a);
    }
}
