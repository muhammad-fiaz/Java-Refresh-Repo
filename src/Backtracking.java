import java.util.*;

public class Backtracking {

    public static void main(String[] args) {
        System.out.println("==== N-Queens Problem ====");
        nQueens(4); // Solve N-Queens for a 4x4 board

        System.out.println("\n==== Sudoku Solver ====");
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        sudokuSolver(board);
        printBoard(board);

        System.out.println("\n==== Permutations of [1, 2, 3] ====");
        List<List<Integer>> permutations = generatePermutations(new int[]{1, 2, 3});
        permutations.forEach(System.out::println);
    }

    // ===================== N-Queens Problem =====================
    public static void nQueens(int n) {
        int[][] board = new int[n][n];
        if (solveNQueens(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution");
        }
    }

    private static boolean solveNQueens(int[][] board, int row, int n) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1, n)) return true;
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false; // Check column
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 1) return false; // Check left diagonal
            if (col + (row - i) < n && board[i][col + (row - i)] == 1) return false; // Check right diagonal
        }
        return true;
    }

    // ===================== Sudoku Solver =====================
    public static boolean sudokuSolver(int[][] board) {
        return solveSudoku(board);
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // Find an empty spot
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false; // Check row and column
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }

    // ===================== Permutations =====================
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, result, used);
            current.remove(current.size() - 1); // Backtrack
            used[i] = false;
        }
    }

    // ===================== Utility Methods =====================
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
