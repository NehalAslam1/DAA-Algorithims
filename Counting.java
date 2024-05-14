public class CountingSort {
    static void countingSort(int arr[]) {
        int n = arr.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k)
                k = arr[i];
        }

        int[] count = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedArr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            sortedArr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sortedArr[i];
        }
    }

    public static void main(String args[]) {
        int[] a = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
        countingSort(a);
        System.out.println("Sorted array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
