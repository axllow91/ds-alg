package sorting;

public class BubbleSort {


    void bubbleSort(int arr[]) {
        int n = arr.length;
        int i, j;
        boolean swapped;

        for(i = 0; i < n - 1; i++) {
            swapped = false;
            for(j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap values
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(swapped)
                break;
        }
    }


    void printingArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("\nBubble Sort Algorithm: ");

        BubbleSort bb = new BubbleSort();

        int[] a = {55, 13, 2, 6, 1, 0};

        System.out.println("Printing unsorted array");
        bb.printingArray(a);

        System.out.println("Sort the array with bubble sort algorithm");

        bb.bubbleSort(a);
        bb.printingArray(a);
    }
}
