public class InsertionSort {
    static void insertionSort(int arr[]) {
        int n = arr.length;
        int i, j, current;
        for (i = 1; i < n; i++) {
            current = arr[i];
            j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] a = {60, 20, 76, 98, 29, 10};
        insertionSort(a);

        System.out.println("Sorted array:");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
