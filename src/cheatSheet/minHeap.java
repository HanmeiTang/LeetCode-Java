package cheatSheet;

import java.util.Arrays;

public class minHeap {
    int size;
    int[] array;

    public minHeap(int[] array) {
        this.size = array.length;
        this.array = array;
        for (int i = (array.length - 2) / 2; i >= 0; i--) percolateDown(i);
    }

    private void percolateDown(int ind) {
        while (ind <= (size - 2) / 2) {
            int leftVal = array[ind * 2 + 1];
            int rightVal = array[ind * 2 + 2];

            if (array[ind] > leftVal) {
                swap(ind, ind * 2 + 1);
                ind = ind * 2 + 1;
            } else if (array[ind] > rightVal) {
                swap(ind, ind * 2 + 2);
                ind = ind * 2 + 2;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        minHeap m = new minHeap(new int[]{10, 11, 4, 2, 8, 7, 6, 13, 3});
        System.out.println(Arrays.toString(m.array));
    }
}
