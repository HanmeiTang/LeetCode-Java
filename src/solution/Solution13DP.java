package solution;


public class Solution13DP {
    public long power(int a, int b) {
        // Write your solution here
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return 1L;
        }

        // record sign of a
        // then treat it as a positive number
        int sign = 1;
        if (a < 0) {
            a = -a;
            if (b % 2 == 1) {
                sign = -1;
            }
        }


        // dp
        long[] dp = new long[b + 1];
        dp[0] = 1L;
        dp[1] = (long) a;

        // recursion
        power(a, b, dp);

        // return number with sign;
        // with the correct type long
        return (long) dp[b] * sign;
    }

    // fill the dp table
    // a > 0
    private void power(int a, int b, long[] dp) {
        // base case
        if (b == 0 || b == 1) {
            return;
        }

        // recursion rule
        if (dp[b] != 0L) {
            return;
        } else if (dp[b / 2] == 0L) {
            power(a, b / 2, dp);
            System.out.println(dp[b / 2]);
        }

        if (b % 2 == 0) {
            dp[b] = dp[b / 2] * dp[b / 2];
        } else {
            dp[b] = dp[b / 2] * dp[b / 2] * a;
        }

    }

    public static void main(String[] args) {
        Solution13DP s = new Solution13DP();
        System.out.println(s.power(-1, 12345));
    }
}


// corner case a ^ b
// \ a      +    -    0
// b\
// +       okay okay   1
// 0        1     1    1


// a = negative

// TC: O(Logb)
// SC: O(b)