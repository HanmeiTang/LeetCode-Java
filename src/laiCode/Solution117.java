package laiCode;

public class Solution117 {
    public int[] dedup(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        // pointers
        int left = array.length;  // out of bound
        int right = array.length;
        int i = array.length - 1;

        while (i >= 0) {
            if (isDup(array, i)) {
                // move i to the beginning of dup
                // copy [left, right) to the beginnign of dup
                int cur = array[i];
                while (i - 1 >= 0 && array[i - 1] == cur) {
                    i--;
                }

                // copy left to right to cur index if left, right are initialized
                if (left != array.length) {
                    for (int j = 0; j < right - left; j++) {
                        array[i + j] = array[left + j];
                    }

                    right = i + right - left;
                    left = i;
                }

            } else {
                // initialize left and right if needed
                // if already initialized, then left--
                if (left == array.length) {
                    left = i;
                } else {
                    left--;
                }
            }

            i--;
        }

        // check left, right
        if (left == array.length) {
            return new int[0];
        } else {
            int[] output = new int[right - left];
            for (int j = left; j < right; j++) {
                output[j - left] = array[j];
            }
            return output;
        }
    }

    // the element is a dup, O(1)
    private boolean isDup(int[] array, int i) {
        if (i - 1 >= 0) {
            return array[i - 1] == array[i];
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println((char)0);
        char[] i = new char[3];
        System.out.println(new String(i));
        System.out.println((int)Math.sqrt(10));

    }
}

//if (i - 1 >= 0) {
//            return array[i - 1] == array[i];
//        }
//    } else {
//        return false;

// Analysis
