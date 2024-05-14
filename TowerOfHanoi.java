public class TowerOfHanoi {
    static void towerOfHanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from Source " + source + " to Target " + target);
            return;
        } else {
            towerOfHanoi(n - 1, source, target, auxiliary);
            System.out.println("Move disk " + n + " from Source " + source + " to Auxiliary " + auxiliary);
            towerOfHanoi(n - 1, auxiliary, source, target);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
