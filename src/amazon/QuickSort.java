package amazon;

import java.util.Arrays;

class QuickSort {
    public static int[] sortArray(int[] nums) {
        // corner cases
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // quickSort
        partition(nums, 0, nums.length - 1);

        // return
        return nums;
    }

    private static void partition(int[] nums, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        // current layer
        // get pivot index; partition; and keep partition left and right
        int pivotInd = getPivot(left, right);
        int pivot = nums[pivotInd];
        swap(nums, pivotInd, right);

        int i = 0;
        int j = right - 1;

        while (i <= j) {
            if (nums[i] < pivot) i++;
            else if (nums[j] > pivot) j--;
            else swap(nums, i++, j--);
        }

        swap(nums, i, right);

        // recursive rule
        partition(nums, left, i - 1);
        partition(nums, i + 1, right);

    }

    private static int getPivot(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 3, 9, 5};
        QuickSort.sortArray(array);
        System.out.println(Arrays.toString(array));
    }

}