public class RecursionExamples {
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return factorial(n - 1) * n;
    }

    static int fibonacci(int n) {
        if (n < 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("Factorial of %d is %d\n", n, factorial(n));
        System.out.printf("Fibonacci of %d is %d\n", n, fibonacci(n));
    }
}
