package laiCode;


public class Solution638 {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // dp table
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // left
                left[i][j] = (matrix[i][j - 1] == 1 || matrix[i][j - 1] == 3) ? left[i][j - 1] + 1 : 0;

                // up
                up[i][j] = (matrix[i - 1][j] == 2 || matrix[i - 1][j] == 3) ? up[i - 1][j] + 1 : 0;

                if (left[i][j] > 0 && up[i][j] > 0) {
                    for (int len = Math.min(left[i][j], up[i][j]); len >= 1; len--) {
                        if (up[i][j - len + 1] >= len && left[i - len][j] >= len) {
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
            }
        }

        // scan through

        return maxLen;
    }

    public static void main(String[] args) {
        Solution638 s = new Solution638();
        int[][] m1 = new int[][]{
                {2, 0, 1, 3, 3, 1, 3, 0}, {1, 0, 2, 1, 1, 3, 0, 2},
                {1, 2, 3, 3, 3, 3, 0, 2}, {3, 3, 3, 1, 0, 2, 2, 2},
                {3, 3, 2, 3, 3, 3, 2, 0}, {3, 3, 0, 1, 1, 3, 2, 2},
                {1, 0, 1, 1, 0, 0, 1, 0}};

        int[][] m2 = new int[][]{
                {2, 1, 1, 0, 3, 1, 3, 0, 0},
                {3, 2, 2, 1, 1, 0, 1, 0, 2},
                {1, 1, 0, 0, 0, 0, 0, 1, 0}};

        int[][] m3 = new int[][]{{0, 3, 3, 2}, {3, 2, 3, 2},
                {3, 2, 0, 2}, {3, 3, 1, 0}, {3, 2, 1, 2}, {3, 1, 3, 2}, {2, 2, 3, 2}, {3, 1, 2, 2}, {3, 1, 1, 2}, {1, 1, 1, 0}};
//        System.out.println(Arrays.toString(m3));
        int result = s.largestSquareOfMatches(m3);
        System.out.println(result);
    }
}
