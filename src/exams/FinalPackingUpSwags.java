package exams;


import java.util.*;

public class FinalPackingUpSwags {
    public int getNumBox(int num) {
        // Illegal input...
        if (num <= 0) {
            return 0;
        }

        // Some data sets we need
        int size = (int) Math.sqrt(num); // e.g. 10 --> 3 is max box size
        int[] min = new int[1]; // final output number: min box num
        min[0] = num; // the worst case if using 1x1 box
        int[] cur = new int[size]; // current solution
        int[] set = new int[size]; // possible box sizes
        for (int i = 0; i < size; i++) {
            set[i] = (size - i) * (size - i);
        }

        dfs(set, 0, cur, num, min);

        // it is guaranteed to have a solution since 1x1 is available
        return min[0];
    }

    private void dfs(int[] set, int index, int[] cur, int remain, int[] min) {
        // base case
        if (index == set.length - 1) {
            cur[index] = remain;
            int sum = 0;
            for (int i = 0; i < cur.length; i++) {
                sum += cur[i];
            }

            min[0] = Math.min(min[0], sum);
            return;
        }

        // recursive rule
        for (int i = 0; i <= remain / set[index]; i++) {
            cur[index] = i;
            dfs(set, index + 1, cur, remain - set[index] * i, min);
        }

    }

    public static void main(String[] args) {
        FinalPackingUpSwags fpus = new FinalPackingUpSwags();
        int num = fpus.getNumBox(10);
        System.out.println(num);
    }
}


// Analysis, N is the number of itmes
// TC: O(N^sqrt(N)), at most sqrt(N) layer, with N nodes each layer
// SC: O(N)





