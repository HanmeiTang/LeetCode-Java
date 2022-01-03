package leetCode;

import java.util.*;

public class LeetCode496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int num : nums) {
            while (!stack.isEmpty() && num > stack.peek())
                map.put(stack.pollLast(), num);
            stack.offerFirst(num);
        }
        while (!stack.isEmpty()) map.put(stack.pollLast(), -1);
        System.out.println(map);
        for (int i = 0; i < findNums.length; i++) res[i] = map.get(findNums[i]);

        return res;
    }

    public static void main(String[] args) {
        LeetCode496 s = new LeetCode496();
        int[] result = s.nextGreaterElement(new int[]{2, 1, 5}, new int[]{2, 3, 5, 1, 0, 7});
        System.out.println(Arrays.toString(result));
    }
}