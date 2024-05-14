import java.util.Arrays;

public class RadixSort {
    static void countSort(int arr[], int n, int pos) {
        int output[] = new int[n];
        int count[] = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++)
            count[(arr[i] / pos) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / pos) % 10] - 1] = arr[i];
            count[(arr[i] / pos) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    static void radixSort(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        for (int pos = 1; max / pos > 0; pos *= 10)
            countSort(arr, n, pos);
    }

    public static void main(String[] args) {
        int array[] = {432, 8, 530, 90, 88, 231, 11, 45, 677, 199};
        int n = array.length;

        radixSort(array, n);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
