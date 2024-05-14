public class Search {
    static int linearSearch(int arr[], int n, int element) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int arr[], int low, int high, int element) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == element)
                return mid;

            if (arr[mid] > element)
                return binarySearch(arr, low, mid - 1, element);

            return binarySearch(arr, mid + 1, high, element);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = a.length;
        int element1 = 8;
        System.out.println("Linear Search Result: " + linearSearch(a, n, element1));

        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int element2 = 7;
        int result = binarySearch(b, 0, n - 1, element2);
        if (result != -1)
            System.out.println("Binary Search Result: Element found at index " + result);
        else
            System.out.println("Binary Search Result: Element not found");
    }
}
