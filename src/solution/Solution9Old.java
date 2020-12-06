package solution;


public class Solution9Old {
    public int[] mergeSort(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        // merge sort
        return mergeSort(array, 0, array.length - 1);
    }

    //
    private int[] mergeSort(int[] array, int left, int right) {
        // assume all input are valid
        // base case
        if (left == right) {
            return new int[]{array[left]};
        }

        // recursive rule
        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(array, left, mid);
        int[] rightArray = mergeSort(array, mid + 1, right);

        // return
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        if (leftArray.length == 0) {
            return rightArray;
        }

        if (rightArray.length == 0) {
            return leftArray;
        }

        int i = 0; // left index
        int j = 0; // right index
        int k = 0; // return array

        int[] result = new int[leftArray.length + rightArray.length];

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        // return
        return result;
    }
}


// merge sort
// len = 5
// 0  1   2  3  4
// 4, 2, -3, 6, 1

// at least two numbers
// [0, 2) [2, 5)
// [left, right)


// 4 2 -3 6 1
//  /     \
// 4 2    -3 6 1
// /\
// [4] [2] (base case)
// ====================
// [2, 4] [-3, 1, 6]

// mergerSOrt(0, 3)
// left = 0
// right = 3
// left, (right + left) / 2 --> [0, 1)
// (right + left) / 2, right --> [1, 3)
//  0  1  2
// [0, 1, 2] --> [0] [1, 2]

// mergerSOrt(0, 4)
// left = 0
// right = 4
// left, (right + left) / 2 --> [0, 2)
// (right + left) / 2, right --> [2, 4)
// [0, 1, 2, 3] --> [0, 1] [2, 3]
// [left, length/2), [length- 2, right]


// 2, 3, 4
// i
// 1, 5, 6
// j
// //

// Analysis
