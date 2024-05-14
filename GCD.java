public class EuclideanAlgorithm {
    static int euclid(int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (y == 0)
            return x;
        else
            return euclid(y, x % y);
    }

    public static void main(String[] args) {
        int x = 48, y = 18;
        System.out.printf("GCD of %d and %d is %d\n", x, y, euclid(x, y));
    }
}
