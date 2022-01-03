package laiCode;


public class Solution625 {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (k <= 0) {
            return getLongestOne(nums);
        }

        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count++;
            }
        }

        k = Math.min(count, k);

        // recursion to implement dfs
        int[] longest = new int[]{0};
        dfs(nums, longest, k);


        // return
        return longest[0];
    }

    // private method to run dfs
    private void dfs(int[] cur, int[] longest, int k) {
        // base case
        if (k == 0) {
            longest[0] = Math.max(longest[0], getLongestOne(cur));
            return;
        }

        // recursive rule: try all zero positions
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] == 0) {
                cur[i] = 1;
                dfs(cur, longest, k - 1);
                cur[i] = 0;
            }
        }
    }

    // private method to count the longest 1 array
    private int getLongestOne(int[] nums) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 1) {
                int j = i;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                count = Math.max(count, j - i);
                i = j;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution625 s = new Solution625();
        System.out.println(s.longestConsecutiveOnes(new int[]{1, 0, 1, 0, 1, 0}, 2));
    }
}

// DFS
// k = 2

// index | 0 1 2 3 4 5 6 7 8 9
// array | 1,1,0,0,1,1,1,0,0,0
//                              i
//                       j

// i == 1 && j == 1 --> j++
// i == 1 && j == 0 --> count = max(count, j - i); j move to next 1, i = j


//     /                 |
// 1,1,k,0,1,1,1,0,0,0    1,1,0,k,1,1,1,0,0,0         (5)
//   /
//  (4)
// N * (N -1).... (N-K)