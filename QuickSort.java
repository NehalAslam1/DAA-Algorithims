public class QuickSort {
    static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int index = si;

        for (int i = si; i < ei; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }

        int temp = arr[index];
        arr[index] = arr[ei];
        arr[ei] = temp;

        return index;
    }

    static void quickSort(int arr[], int si, int ei) {
        if (si < ei) {
            int pivot = partition(arr, si, ei);
            quickSort(arr, si, pivot - 1);
            quickSort(arr, pivot + 1, ei);
        }
    }

    public static void main(String[] args) {
        int[] a = {21, 4, 5, 2, 5, 7, 9, 23, 51, 77, 90};
        int n = a.length;

        quickSort(a, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
