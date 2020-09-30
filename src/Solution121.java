import java.util.ArrayList;
import java.util.List;

public class Solution121 {
    public List<Integer> spiral(int[][] matrix) {
        // corner cases
        if (matrix == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        spiral(matrix, result, matrix.length);
        return result;
    }

    private void spiral(int[][] matrix, ArrayList<Integer> result, int n) {
        int N = matrix.length;
        int ind = (N - n) / 2;
        // base case: n = 0 OR 1
        if (n == 0) {
            return;
        } else if (n == 1) {
            result.add(matrix[N / 2][N / 2]);
            return;
        }

        // recursion
        for (int i = ind; i <= n - 2 - ind; i++) {
            result.add(matrix[0][i]);
        }
        for (int i = ind; i <= n - 2 - ind; i++) {
            result.add(matrix[i][n - 1]);
        }

        for (int i = n - 1 - ind; i >= 1 + ind; i--) {
            result.add(matrix[n - 1][i]);
        }

        for (int i = n - 1 - ind; i >= 1 + ind; i--) {
            result.add(matrix[i][0]);
        }

        // return value
        spiral(matrix, result, n - 2);
    }
}
