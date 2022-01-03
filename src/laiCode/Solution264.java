package laiCode;

import java.util.*;

public class Solution264 {
    int[] output = null;
    public int[] keepDistance(int k) {
        if (k <= 1) return null;

        int[] result = new int[2 * k];
        for (int i = 0; i < 2 * k; i++) result[i] = -1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) set.add(i + 1);

        // dfs
        dfs(0, result, set);

        // return;
        return output;
    }

    private void dfs(int ind, int[] result, Set<Integer> set) {
        if (output != null) return;
        if (set.size() == 0) {
            output = new int[result.length];
            for (int i = 0; i < result.length; i++) output[i] = result[i];
            return;
        }

        // try number in set at current index
        for (int n : set) {
            if (ind + n + 1 < result.length && result[ind + n + 1] == -1) {
                Set<Integer> nextSet = new HashSet(set);
                nextSet.remove(n);
                result[ind] = n;
                result[ind + n + 1] = n;
                int nextInd = 0;
                for (int x : result) {
                    if (x != -1) nextInd++;
                    else break;
                }

                dfs(nextInd, result, nextSet);
                result[ind] = -1;
                result[ind + n + 1] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution264 s = new Solution264();
        int[] output = s.keepDistance(3);
        System.out.println(Arrays.toString(output));
    }
}

/*
1 1  2 2
-1
1 1

*/