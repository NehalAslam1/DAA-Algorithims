public class MergeSort {
    static void merge(int arr[], int si, int mid, int ei) {
        int n1 = mid - si + 1;
        int n2 = ei - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[si + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = si;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int si, int ei) {
        if (si < ei) {
            int mid = si + (ei - si) / 2;

            mergeSort(arr, si, mid);
            mergeSort(arr, mid + 1, ei);

            merge(arr, si, mid, ei);
        }
    }

    public static void main(String[] args) {
        int[] arr = {92, 12, 32, 15, 16, 2, 1};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
