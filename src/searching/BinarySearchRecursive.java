package searching;

public class BinarySearchRecursive {


    public static int binarySearch(int[] arr, int l, int r, int x) {
        if(r >= l) {
            int mid = l + (r - l) / 2;

            // if element is present in the middle
            //
            if(arr[mid] == x) {
                return mid;
            }

            // if the element is smaller than mid, then
            // it can only be present in left subarray
            if(arr[mid] > x) {
                return binarySearch(arr,l, mid - 1, x);
            }

            // else the element can be only present
            // in right subarray
            return binarySearch(arr, l, mid + 1, x);
        }

        // We reach here when element is not present
        // in array
        return -1;

    }
    public static void main(String[] args) {


        int[] arr = {14, 5, 3, 1, 2, 10};
    }
}
