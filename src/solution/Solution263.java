package solution;

import java.util.*;

public class Solution263 {

    HashMap<Set<Integer>, Integer> memo;
    int min = Integer.MAX_VALUE;
    int n; // final index
    int[] array;

    public int minDifference(int[] array) {
        if (array == null) return 0;
        if (array.length == 1) return array[0];

        memo = new HashMap<>();
        n = (array.length - 2) / 2;
        this.array = array;

        // dfs: FIXME
        int[] cur = new int[array.length];
        for (int i = 0; i < cur.length; i++) cur[i] = i;
        dfs(0, cur);

        // return
        return min;
    }

    // dfs to recursively check all combinations of sub set
    private void dfs(int index, int[] cur) {
        // base case
        if (index > n) {
            return;
        }

        // recursive explore
        if (!memo.containsKey(getSet(cur, 0, n))) {
            Set<Integer> set1 = getSet(cur, 0, n);
            Set<Integer> set2 = getSet(cur, n + 1, cur.length - 1);

            int sum1 = 0, sum2 = 0;
            for (int x : set1) sum1 += array[x];
            for (int x : set2) sum2 += array[x];
            int diff = Math.abs(sum1 - sum2);

            memo.put(set1, diff);
            memo.put(set2, diff);

            min = diff < min ? diff : min;
        }

        for (int i = index; i < cur.length; i++) {
            swap(cur, i, index);
            if (!memo.containsKey(getSet(cur, 0, n))) {
                dfs(index + 1, cur);
            }
            swap(cur, i, index);
        }
    }

    private Set<Integer> getSet(int[] num, int startInd, int endInd) {
        Set<Integer> set = new HashSet<>();
        for (int i = startInd; i <= endInd; i++) set.add(num[i]);
        return set;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        Solution263 s = new Solution263();
        s.minDifference(new int[]{3, 1, -2, 5, 1, 6});
        //System.out.println(s.memo);
    }
}

/*
dfs, permutation



*/