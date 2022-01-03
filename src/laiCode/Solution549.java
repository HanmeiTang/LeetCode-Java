
// =========================
// [NA] 1st round: Check solution
// =========================
// [ ] 2nd round: Oral explanation record
//  - High-level idea (10s)
//  - semantic explanations of vital variables (30s)
//  - Loop bodies etc.
//  - summary: time/space complexity
//  	- Time complexity: O()
//  	- Space complexity: O()
//
// A complete answer will include the following:
// 1. Document your assumptions
// 2. Explain your approach and how you intend to solve the problem
// 3. Provide code comments where applicable
// 4. Explain the big-O run time complexity of your solution. Justify your answer.
// 5. Identify any additional data structures you used and justify why you used them.
// 6. Only provide your best answer to each part of the question.
// =========================
// [ ] 3rd round: Review
// =========================

import java.util.Arrays;

class Solution549 {
    public void partition(int[] array, int pivotIndex) {
        // corner cases
        if (array == null || array.length <= 1) {
            return;
        }

        if (pivotIndex < 0 || pivotIndex >= array.length) {
            return;
        }

        int i = 0;
        int j = array.length - 1;
        int pivot = array[pivotIndex];

        // move pivot to the most right
        swap(array, pivotIndex, array.length - 1);
        j--;

        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }

        swap(array, i, array.length - 1);
    }

    private void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Solution549 solution = new Solution549();
        int[] array = new int[]{1, 11, 2, 8, 4, 3, 5, 7, 6, 9};

        int pivotIndex = 3;
        System.out.println(array[pivotIndex]);
        solution.partition(array, pivotIndex);
        System.out.println(Arrays.toString(array));

        Integer[] test = new Integer[5];
    }

}
