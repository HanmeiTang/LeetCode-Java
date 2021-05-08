package solution;

import java.util.*;

// solution: https://bohenan.gitbooks.io/leetcode/content/lai-replacements-of-a-and-b.html
// Awesome
public class Solution350 {
    public int minReplacements(String input) {
        // corner cases
        if (input == null || input.length() <= 1) return 0;

        // 2 dp table
        int[] left = new int[input.length()];  // a-->b
        int[] right = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (i == 0) left[i] = input.charAt(0) == 'a' ? 0 : 1;
            else {
                left[i] = input.charAt(i) == 'a' ? 0 : 1;
                left[i] += left[i - 1];
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if (i == input.length() - 1) right[i] = input.charAt(i) == 'b' ? 0 : 1;
            else {
                right[i] = input.charAt(i) == 'b' ? 0 : 1;
                right[i] += right[i + 1];
            }
        }

        int numOper = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) numOper = Math.min(numOper, right[0]);
            else if (i == input.length() - 1) numOper = Math.min(numOper, left[i]);
            else numOper = Math.min(numOper, left[i - 1] + right[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        // get the min number
        return numOper;
    }

    public static void main(String[] args) {
        Solution350 s = new Solution350();
        int output = s.minReplacements("ab");
    }
}
