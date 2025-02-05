import java.util.Arrays;

public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Matrix Rotation by 90 degrees
        System.out.println("\nMatrix after 90 degrees rotation:");
        rotateMatrix90(matrix);
        printMatrix(matrix);

        // Matrix Rotation by 180 degrees
        System.out.println("\nMatrix after 180 degrees rotation:");
        rotateMatrix180(matrix);
        printMatrix(matrix);

        // Matrix Rotation by 270 degrees
        System.out.println("\nMatrix after 270 degrees rotation:");
        rotateMatrix270(matrix);
        printMatrix(matrix);

        // Saddle Point in Matrix
        System.out.println("\nSaddle Point in Matrix:");
        findSaddlePoint(matrix);

        // Diagonal Sum in Matrix
        System.out.println("\nDiagonal Sum in Matrix:");
        int diagonalSum = calculateDiagonalSum(matrix);
        System.out.println("Diagonal Sum: " + diagonalSum);
    }

    // ===================== Print Matrix =====================
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // ===================== Matrix Rotation by 90 degrees =====================
    public static void rotateMatrix90(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // ===================== Matrix Rotation by 180 degrees =====================
    public static void rotateMatrix180(int[][] matrix) {
        // Rotate by 90 degrees twice
        rotateMatrix90(matrix);
        rotateMatrix90(matrix);
    }

    // ===================== Matrix Rotation by 270 degrees =====================
    public static void rotateMatrix270(int[][] matrix) {
        // Rotate by 90 degrees thrice
        rotateMatrix90(matrix);
        rotateMatrix90(matrix);
        rotateMatrix90(matrix);
    }

    // ===================== Find Saddle Point in Matrix =====================
    public static void findSaddlePoint(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int minRowValue = matrix[i][0];
            int minRowIndex = 0;
            // Find minimum value in the row
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minRowValue) {
                    minRowValue = matrix[i][j];
                    minRowIndex = j;
                }
            }
            // Check if it's the maximum in its column
            boolean isSaddlePoint = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minRowIndex] > minRowValue) {
                    isSaddlePoint = false;
                    break;
                }
            }
            if (isSaddlePoint) {
                System.out.println("Saddle Point: " + minRowValue + " at position (" + i + ", " + minRowIndex + ")");
                return;
            }
        }
        System.out.println("No Saddle Point Found.");
    }

    // ===================== Calculate Diagonal Sum =====================
    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i]; // Sum of main diagonal
            sum += matrix[i][matrix.length - 1 - i]; // Sum of secondary diagonal
        }
        // If the matrix is odd, we subtract the center element twice (it was added in both diagonals)
        if (matrix.length % 2 != 0) {
            sum -= matrix[matrix.length / 2][matrix.length / 2];
        }
        return sum;
    }
}
