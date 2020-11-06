package amazon;

// [100, 50, 50, 25] --> [1, 2, 2, 4]
// [1, 2, 3, 4, 4]

// [2, 2, 3, 4, 5]
// 5, 4, 3, 3, (2, 2), (1, 1),

// int[] rank, rank[0] = 1
// [1, 2, 3, 3, 5, 5, 7, 7]
// if [i] == 0, then break the loop
// if [i] is equal to [i-1], then remanin the same
// if [i] is smaller than [i-1], then rank[i] = i + 1
// if rank[i] > cutoff, then return
//


import java.util.*;

public class CutOffRank {
    public int getRankCut(int cutOff, int num, Integer[] scores) {
        // corner cases
        if (scores == null || num == 0) {
            return 0;
        }

        // sort O(NlngN)
        Arrays.sort(scores, Collections.reverseOrder());

        // get the rank list
        int[] rank = new int[num];
        rank[0] = 1;

        for (int i = 1; i < num; i++) {
            if (scores[i] == 0) {
                break;
            }

            if (scores[i].equals(scores[i - 1])) {
                rank[i] = rank[i - 1];
            } else {
                if (i + 1 > cutOff) {
                    break;
                } else {
                    rank[i] = i + 1;
                }
            }
        }
        for (int i : rank) {
            System.out.println(i);
        }

        return rank.length;
    }

    public static void main(String[] args) {
        CutOffRank r = new CutOffRank();
        int s = r.getRankCut(4, 6, new Integer[]{100, 50, 50, 25, 0, 0});
        System.out.println(s);
    }
}

// Analysis:
// TC: O(n*lg(n) + n)
// SC: O(n)
