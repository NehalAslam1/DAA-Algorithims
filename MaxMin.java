public class MaxAndMin {
    static class Pair {
        int max;
        int min;

        Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    static Pair maxAndMin(int[] arr, int low, int high) {
        if (low == high)
            return new Pair(arr[low], arr[low]);
        else if (low == high - 1) {
            if (arr[low] > arr[high])
                return new Pair(arr[low], arr[high]);
            else
                return new Pair(arr[high], arr[low]);
        } else {
            int mid = (low + high) / 2;
            Pair left = maxAndMin(arr, low, mid);
            Pair right = maxAndMin(arr, mid + 1, high);
            int max = Math.max(left.max, right.max);
            int min = Math.min(left.min, right.min);
            return new Pair(max, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 2, 8};
        Pair result = maxAndMin(arr, 0, arr.length - 1);
        System.out.println("Max: " + result.max);
        System.out.println("Min: " + result.min);
    }
}
