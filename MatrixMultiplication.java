public class MatrixOperations {
    static int numRows(int[][] m) {
        return m.length;
    }

    static int numColumns(int[][] m) {
        return m[0].length;
    }

    static int[][] matrixMultiplication(int[][] m1, int[][] m2) {
        int[][] resultMatrix = new int[numRows(m1)][numColumns(m2)];
        if (numColumns(m1) != numRows(m2))
            return null;
        else {
            for (int i = 0; i < numRows(m1); i++) {
                for (int j = 0; j < numColumns(m2); j++) {
                    resultMatrix[i][j] = 0;
                    for (int k = 0; k < numColumns(m1); k++) {
                        resultMatrix[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return resultMatrix;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};

        int[][] result = matrixMultiplication(a, b);
        if (result != null) {
            System.out.println("Result Matrix:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix multiplication not possible.");
        }
    }
}
