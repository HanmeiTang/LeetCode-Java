package google;

import java.util.*;

class LeetCode1646 {
    int max = -1;

    public int getMaximumGenerated(int n) {
        // corner cases
        if (n == 0 || n == 1) return n;

        // cache
        int[] cache = new int[101];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;

        // recursion until get the result...
        for (int i = n; i >= 1; i--) {
            if (cache[i] == 0) System.out.println(getNum(i, cache));
            else max = Math.max(max, cache[i]);
        }


        return max;

    }

    private int getNum(int n, int[] cache) {
        // base case
        if (n <= 1 || cache[n] != 0) {
            max = Math.max(cache[n], max);
            return cache[n];
        }

        // recursive rule
        if (n % 2 == 0) {
            if (cache[n / 2] == 0) cache[n / 2] = getNum(n / 2, cache);
            cache[n] = cache[n / 2];
        } else {
            if (cache[n / 2] == 0) cache[n / 2] = getNum(n / 2, cache);
            if (cache[n / 2 + 1] == 0) cache[n / 2 + 1] = getNum(n / 2 + 1, cache);
            cache[n] = cache[n / 2] + cache[n / 2 + 1];
        }

        max = Math.max(cache[n], max);
        return cache[n];
    }

    public static void main(String[] args) {
        LeetCode1646 l = new LeetCode1646();
        l.getMaximumGenerated(4);
    }

}

/**
 * 5
 * /\
 * 2   3
 * /    |\
 * 1*2  1 2
 * <p>
 * <p>
 * <p>
 * 0 1 2 3 4 5 6 7 8 9
 * 0 1 1 2 1 3 2 3 1
 * <p>
 * 2* xx + 1 = N
 * /\
 * xx xx+1
 * /
 * <p>
 * in total: lgN layers
 * tc: 2 ^ (lgN) = N
 * sc: lgN
 */