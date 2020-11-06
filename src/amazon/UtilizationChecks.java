package amazon;

public class UtilizationChecks {
    public static int calInstance(int[] averageUtil, int n) {
        // corner cases

        // loop check
        int i = 0;
        while (i < averageUtil.length) {
            if (averageUtil[i] < 25) {
                if (n > 1) {
                    n = (n + 1) / 2;
                    i += 10;
                }
            } else if (averageUtil[i] >= 25 && averageUtil[i] <= 60) {
                i++;
            } else {
                if (2 * n <= 2 * Math.pow(10, 8)) {
                    n *= 2;
                    i += 10;
                }
            }
            i++;
        }

        // return
        return n;
    }

    public static void main(String[] args) {
        int result = UtilizationChecks.calInstance(new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}, 2);
        System.out.println(result);
    }

}


// Analysis
// instance = 2
//  0    1  2  3  4  5  6  7  8  9  10  11 12  13
// [25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80]
//
// 3 --> 2
// 2 --> 1

// TC: O(N)
// SC: O(1)
