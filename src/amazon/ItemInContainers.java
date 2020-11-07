package amazon;

import java.util.*;

public class ItemInContainers {
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // corner cases
        // 1. not consistent?
        // 2. end < beg
        // 3. out of bound?


        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] preSum = new int[n];


        // update left
        left[0] = s.charAt(0) == '|' ? 0 : -1;
        for (int i = 1; i < s.length(); i++) {
            left[i] = s.charAt(i) == '|' ? i : left[i - 1];
        }

        // update right
        right[n - 1] = s.charAt(n - 1) == '|' ? n - 1 : -1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = s.charAt(i) == '|' ? i : right[i + 1];
        }

        // preSum[i]: [0, i] total star number
        preSum[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            preSum[i] = s.charAt(i) == '*' ? preSum[i - 1] + 1 : preSum[i - 1];
        }

        // iterate pairs
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;

            int realStart = right[start];
            int realEnd = left[end];

            if (realStart >= realEnd) {
                result.add(0);
            } else {
                result.add(preSum[realEnd] - preSum[realStart]);
            }
        }

        // return
        return result;
    }

    public static void main(String[] args) {
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);
        startIndices.add(1);

        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(5);
        endIndices.add(6);

        List<Integer> result = ItemInContainers.numberOfItems("|**|*|*", startIndices, endIndices);

        for (int i : result) {
            System.out.println(i);
        }
    }
}


// Analysis
//         0 1 2 3 4 5 6 7 8 9
//         * * | * * * | * * *
//left    -1-1 2 2 2 2 6 6 6 6
//right   2 2 2 6 6 6 6-1-1-1
//preSum  1 2 2 3 4 5 5 6 7 8

// TC: O(s.len * 3 + indices.len)
// SC: O(s.len * 3)

