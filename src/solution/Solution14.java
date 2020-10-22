package solution;


public class Solution14 {
    public int binarySearch(int[] array, int target) {
        // corner case
        if (array == null || array.length == 0) {
            return -1;
        }

        // loop check
        int left = 0;
        int right = array.length - 1;

        while (right - left > 1) {
            int med = left + (right - left) / 2;
            if (array[med] > target) {
                left = med;
            } else if (array[med] < target) {
                right = med;
            } else {
                return med;
            }
        }

        // return the index
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution14 s = new Solution14();
        int i = s.binarySearch(new int[]{3, 4, 5, 6, 6, 9, 16}, 4);
    }
}

// Analysis
// TC: log(N)
// SC: 1