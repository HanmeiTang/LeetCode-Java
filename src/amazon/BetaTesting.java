package amazon;

// Question: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
// Solution: https://www.geeksforgeeks.org/divide-the-array-in-k-segments-such-that-the-sum-of-minimums-is-maximized/
// https://leetcode.com/problems/split-array-largest-sum/solution/


public class BetaTesting {
    // Function to maximize the
    // sum of the minimums
    public static int maximizeSum(int[] a, int n, int ind, int k, int[][] dp) {
        // If k segments have been divided
        if (k == 0) {
            // If we are at the end
            if (ind == n)
                return 0;

                // If we donot reach the end
                // then return a negative number
                // that cannot be the sum
            else
                return -1;
        }

        // If at the end but
        // k segments are not formed
        else if (ind == n)
            return -1;

            // If the state has not
            // been visited yet
        else if (dp[ind][k] != -1)
            return dp[ind][k];

            // If the state has
            // not been visited
        else {
            int ans = 0;

            // Get the minimum
            // element in the segment
            int mini = a[ind];

            // Iterate and try to break
            // at every index
            // and create a segment
            for (int i = ind; i < n; i++) {

                // Find the minimum element
                // in the segment
                mini = Math.min(mini, a[i]);

                // Find the sum of all the
                // segments trying all
                // the possible combinations
                ans = Math.max(ans, maximizeSum(a, n, i + 1, k - 1, dp) + mini);
            }

            // Return the answer by
            // memoizing it
            return dp[ind][k] = ans;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int MAX = 10;
        int[] a = {5, 7, 4, 2, 8, 1, 6};
        int k = 3;
        int n = a.length;

        // Initialize dp array with -1
        int[][] dp = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++)
                dp[i][j] = -1;
        }

        System.out.println(maximizeSum(a, n, 0, k, dp));
    }
}