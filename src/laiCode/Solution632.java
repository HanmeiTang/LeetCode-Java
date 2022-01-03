package laiCode;

import java.util.*;

public class Solution632 {

    int[][] dp;
    int[] pizza;

    public boolean canWin(int[] pizza) {
        // corner case
        if (pizza == null || pizza.length == 0) return false;
        else if (pizza.length <= 2) return true;

        int sum = 0;
        for (int slice : pizza) sum += slice;

        // dp table
        this.pizza = pizza;
        int slices = pizza.length;
        dp = new int[slices][slices];
        getScore(0, slices - 1);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(sum);
        return dp[0][slices - 1] > sum - dp[0][slices - 1];
    }

    // left, right are inclusive boundaries
    private int getScore(int i, int j) {
        // base case
        if (i == j) {
            return pizza[i];
        } else if (i > j) {
            return Integer.MIN_VALUE;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i + 1 == j) {
            dp[i][j] = Math.max(pizza[i], pizza[j]);
            return dp[i][j];
        }

        // recursive rule, if dp[][] is not defined
        int curMax = 0;

        // chose left slice
        if (pizza[i + 1] > pizza[j]) curMax = Math.max(curMax, pizza[i] + getScore(i + 2, j));
        else curMax = Math.max(curMax, pizza[i] + getScore(i + 1, j - 1));

        // chose right slice
        if (pizza[i] > pizza[j - 1]) curMax = Math.max(curMax, pizza[j] + getScore(i + 1, j - 1));
        else curMax = Math.max(curMax, pizza[j] + getScore(i, j - 2));

        dp[i][j] = curMax;
        return curMax;
    }

    public static void main(String[] args) {
        Solution632 s = new Solution632();
        s.canWin(new int[]{47, 9, 7, 88, 74, 29, 85, 29, 54, 12, 41, 33, 52, 22, 12});
    }
}

/*
  dp[i][j] max score I can get
  max {
    1. choose left pizza[i]
        pizza[i+1] > pizza[j] --> pizza[i] + dp[i+2][j]
        pizza[i+1] <= pizza[j] -->pizza[i] + dp[i+1][j-1]

    2. choose right pizza[j]
        [i,j-1]
        pizza[i] > pizza[j-1] --> pizza[j] + dp[i+1][j-1]
        pizza[i] <=pizza[j-1] --> pizza[j] + dp[i][j-2]
  }

*/