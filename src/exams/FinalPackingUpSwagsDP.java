package exams;

public class FinalPackingUpSwagsDP {
    public int getNumBox(int num) {
        if (num <= 0) {
            return 0;
        }

        // box size set
        int size = (int) Math.sqrt(num);
        int[] set = new int[size];
        for (int i = 0; i < size; i++) {
            set[i] = (size - i) * (size - i);
        }

        // dp table
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        // DP loop
        for (int i = 2; i <= num; i++) {
            int minBox = i; // worst case
            for (int j = 1; j <= i; j++) {
                int curMin = getCut(set, j) + dp[i - j];
                minBox = Math.min(curMin, minBox);
            }
            dp[i] = minBox;
        }

        return dp[num];
    }

    // only cut where the biggest box is available
    // set is descending and at least {1}
    // num >= 1
    private int getCut(int[] set, int num) {
        for (int size : set) {
            if (size <= num) {
                return num / size + (num % size);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        FinalPackingUpSwagsDP fpuw = new FinalPackingUpSwagsDP();
        int output = fpuw.getNumBox(100);
        System.out.println(output);
    }
}


// e.g. 10 items, how many boxes?
// dp: least number of box we can use
// i | 0 1 2 3 4 5 6 7 8  9 10
// dp| 0 1 2 3 1

// set| 9 4 1

// dp[i] = min(n[i], all j cases)
// i = 2, n[i] = 2
//      worst = i
//      j = 1 --> cut(1) + dp[1]
//      j = 2 --> cut(2) + dp[0]