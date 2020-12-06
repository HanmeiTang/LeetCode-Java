package cheatSheet;
/*
 * LeetCode 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 */

public class BinarySearch {
    public int minEatingSpeed(int[] piles, int H) {
        // corner cases
        // looks good

        // binary search
        int left = 0;
        int right = 0;
        for (int p : piles) right = Math.max(right, p);

        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (canFinish(mid, H, piles)) right = mid;
            else left = mid;
        }

        // return
        return right;
    }

    // determine if the piles can be finished within h
    // if KOKO consumes cost bananas per hour
    private boolean canFinish(int cost, int h, int[] piles) {
        int count = 0;
        for (int p : piles) count += (p - 1) / cost + 1;
        return count <= h;
    }
}