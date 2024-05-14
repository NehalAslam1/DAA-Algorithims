import java.util.Arrays;

public class Knapsack {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int[] knapsackDP(int n, int capacity, int weight[], int profit[]) {
        int[][] v = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    v[i][w] = 0;
                else if (weight[i - 1] <= w)
                    v[i][w] = max(v[i - 1][w], profit[i - 1] + v[i - 1][w - weight[i - 1]]);
                else
                    v[i][w] = v[i - 1][w];
            }
        }

        int[] result = new int[n];
        int i = n, w = capacity, idx = 0;
        while (i > 0 && w > 0) {
            if (v[i][w] != v[i - 1][w]) {
                result[idx++] = i;
                w = w - weight[i - 1];
                i--;
            } else {
                i--;
            }
        }

        return Arrays.copyOf(result, idx);
    }

    static void knapsackGR(int n, int capacity, int weight[], int profit[]) {
        int[] x = new int[n];

        int remaining_cap = capacity;
        int i = 0;
        for (i = 0; i < n; i++) {
            if (weight[i] > remaining_cap)
                break;
            x[i] = 1;
            remaining_cap = remaining_cap - weight[i];
        }

        if (i < n)
            x[i] = (remaining_cap / weight[i]);

        int max_profit = 0;
        for (i = 0; i < n; i++) {
            max_profit += profit[i] * x[i];
        }

        System.out.println("Max Profit = " + max_profit);
        System.out.print("Selected items: ");
        for (i = 0; i < n; i++) {
            if (x[i] != 0)
                System.out.print((i + 1) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 1};
        int[] profit = {100, 20, 60, 40};
        int n = weight.length;
        int capacity = 5;

        System.out.println("Knapsack using Dynamic Programming:");
        int[] resultDP = knapsackDP(n, capacity, weight, profit);
        int maxProfitDP = 0;
        for (int item : resultDP)
            maxProfitDP += profit[item - 1];
        System.out.println("Max Profit = " + maxProfitDP);
        System.out.print("Selected items: ");
        for (int item : resultDP)
            System.out.print(item + " ");
        System.out.println("\n");

        System.out.println("Knapsack using Greedy Approach:");
        knapsackGR(n, capacity, weight, profit);
    }
}
