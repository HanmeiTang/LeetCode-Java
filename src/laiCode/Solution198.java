package laiCode;


// solution 1: dp
// solution 2: stack
// Assume all numbers are non-negative!
public class Solution198 {
    public int largest(int[] array) {
        // corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        // loop
        int globalMax = 0;
        for (int i = 0; i < array.length; i++) {
            int left = i;
            int right = i;
            while (left - 1 >= 0) {
                if (array[left - 1] >= array[i]) left--;
                else break;
            }

            while (right + 1 < array.length) {
                if (array[right + 1] >= array[i]) right++;
                else break;
            }

            int width = right - left + 1;
            globalMax = Math.max(globalMax, width * array[i]);
            System.out.printf("index: %d, width: %d, height: %d, max: %d\n", i, width, array[i], globalMax);
        }

        // return
        return globalMax;
    }

    public static void main(String[] args) {

        Solution198 s = new Solution198();
        int result = s.largest(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(result);
        System.out.println(new String(new char[]{'a', 'b', 'c'}, 0, 2));
    }
}


