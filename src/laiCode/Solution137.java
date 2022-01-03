package laiCode;

public class Solution137 {
    public int minCost(int[] cuts, int length) {
        // corner case

        // construct dp table
        int n = cuts.length;
        int[][] dp = new int[n + 1][n + 1];

        // iterate thru dp table
        for (int l = 0; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l;
                int beg = i == 0 ? 0 : cuts[i - 1];
                int end = j == n ? length - 1 : cuts[j] - 1;

                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int mid = i; mid <= j - 1; mid++) {
                        dp[i][j] = Math.min(end - beg + 1 + dp[i][mid] + dp[mid + 1][j], dp[i][j]);
                    }
                }
            }
        }

        // return the dp[i][j]
        return dp[0][n];
    }

    public static void main(String[] args) {
        Solution137 s = new Solution137();
        int[] cuts = new int[]{3, 16, 19, 28, 37, 44, 47, 48, 51, 52, 62};
        int length = 67;
        int output = s.minCost(cuts, length);
        System.out.println(output);
    }
}



/*
10
i | 0  1  2  3  4
s | 0, 1, 3, 6, 9
dp| 10 10 10
 0  1    2  3
 2  4   7   10
-- -- --- ---
0 1 2 3
0,0 -- [0,2]
0,1 -- [0,3]
for (int mid = i; mid <= j-1; mid++)
0,3 -- [0,9]
1,3 -- [2,9]
  0, 2
[cuts[i - 1], cuts[j] - 1] -1 --> 0; n --> 10
[0, 3]

i<=j
N



                10
   /             |             \
   [0,1]+[2,9]  [0,3]+[4,9]   [0,6]+[7,9]
          /|\
       [2,3]+[4,9] or [2,6]+[7,9]
               |          |
          [4,6]+[7,9]   [2,3]+[4,6]

N!

dp[0][]
dp[i][j] - the min cost to cut wood from i to j, which are inclusive







*/