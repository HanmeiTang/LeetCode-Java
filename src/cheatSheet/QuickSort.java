package cheatSheet;

// https://leetcode.com/problems/sort-colors/
// color sort: 2 pivot
class QuickSort {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, j++, i++);
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, k--, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}