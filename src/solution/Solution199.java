package solution;

import java.util.*;

class Solution199 {
    public int maxTrapped(int[] array) {
        if (array == null || array.length == 0) return 0;
        // Write your solution here
        int n = array.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = array[0];
        right[n - 1] = array[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], array[i]);
            right[n - i - 1] = Math.max(right[n - i], array[n - i - 1]);
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int wall = Math.min(left[i], right[i]);
            water += Math.max(wall - array[i], 0);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return water;
    }

    public static void main(String[] args) {
        Solution199 s = new Solution199();
        s.maxTrapped(new int[]{5, 3, 1, 4, 6, 2, 3});
    }
}
