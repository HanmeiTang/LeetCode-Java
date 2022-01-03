package laiCode;

public class Solution4 {
    public int[] solve(int[] array) {
        // Corner cases
        if (array == null || array.length == 0) {
            return array;
        }

        // [0, j) is ordered
        // [j, array.length - 1] is disorded
        int j = 0;
        while (j < array.length) { // TODO: array.length or (-1)
            // Get global min from disordered range
            int min = array[j];
            int min_id = j;
            for (int i = j; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    min_id = i;
                }
            }

            // Move min to right of ordered section
            for (int x = min_id; x > j; x--) {
                array[x] = array[x - 1];
            }
            array[j] = min;

            j++;
        }
        return array;

    }
}

