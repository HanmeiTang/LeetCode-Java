public class Solution101 {
    public int largest(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int[][] dp = new int[n][n];
        int globMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                    System.out.println(dp[i][j]);
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1);
                    dp[i][j] = Math.min(matrix[i - 1][j - 1] + 1, dp[i][j]);
                    System.out.printf("%d, %d, %d --> %d\n", matrix[i][j - 1], matrix[i - 1][j], matrix[i - 1][j - 1], dp[i][j]);

                }

                globMax = Math.max(globMax, dp[i][j]);
            }
        }
        return globMax;
    }

    public static void main(String[] args) {
        Solution101 s = new Solution101();
        int[][] test = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
//        System.out.println();
        s.largest(test);
    }
}
