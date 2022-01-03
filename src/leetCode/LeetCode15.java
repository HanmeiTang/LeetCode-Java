package leetCode;

import java.util.*;

class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }

        System.out.println(res);
        System.out.println(seen);
        System.out.println(dups);
        return new ArrayList(res);
    }

    public static void main(String[] args) {
        LeetCode15 l = new LeetCode15();
        l.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}