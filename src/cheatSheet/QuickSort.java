package cheatSheet;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // Corner cases
        if (array == null || array.length <= 1) return array;

        // Recursion
        quickSort(array, 0, array.length - 1);
        return array;
    }

    // in-place quick sort a given array
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    // partition() runs a single step partition in-place and returns the pivot index
    private int partition(int[] array, int left, int right) {
        int pivotIndex = getPivotIndex(left, right);
        int pivot = array[pivotIndex];

        int i = left;
        int j = right;

        // put pivot to the most right
        swap(array, pivotIndex, j);
        j--;

        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        return i;

    }

    // getPivotIndex() gets a random index from [left, right]
    private int getPivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
