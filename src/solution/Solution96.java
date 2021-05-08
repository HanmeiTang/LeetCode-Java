package solution;

import java.util.*;

public class Solution96 {
    public int minCost(int[] stones) {
        if (stones.length <= 1) return 0;
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] preSum = new int[n];
        preSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + stones[i];
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum(preSum, i, j));
                }
            }
        }

        return dp[0][n - 1];
    }

    private int sum(int[] preSum, int i, int j) {
        int base = i == 0 ? 0 : preSum[i - 1];
        return preSum[j] - base;
    }

    public static void main(String[] args) {
        Solution96 s = new Solution96();
        //0,2 = 00+12,01+22 = max(4+4+4, 5+3+5) = 13
        //1,3 = 11+23,12+33 = max(1+5+5,4+2+4) = 11
        //0,3 = 00+13,01+23,02+33 = max(4+6+11,)
        System.out.println(s.minCost(new int[]{4, 3, 3, 4}));
    }
}

/*
 4 3 3 4

 dp[i][j]

dp[0][2] = min(sum(0) + sum(1,2) + dp[1][2], sum(2) + sum(1,2), dp[0][1]);
1: 1,1; 2,2... -> 0
2: 1,2 = 1 + 2
3: 1,3 = max(12+3, 1+23)
4: 1,4 = max(1+234,12+34,123+4)
*/