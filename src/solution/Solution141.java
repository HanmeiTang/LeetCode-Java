package solution;

import java.util.*;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Solution141 {
    public boolean exist(TreeNode root, int target) {
        // corner case
        if (root == null) {
            return false;
        }

        if (root.key == target) {
            return true;
        }

        // recursion dfs
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, root.key, null, target);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int curSum, Integer preSum, int target) {
        // base case
        if (root == null) {
            return false;
        }

        preSum = curSum;
        curSum = preSum + root.key;

        if (root.key == target || curSum == target || set.contains(target) || set.contains(curSum - target)) {
            return true;
        }

        if (root.left != null) {
            set.add(curSum);
            boolean left = dfs(root.left, set, curSum, preSum, target);
            set.remove(curSum);

            if (left) return true;
        }

        if (root.right != null) {
            set.add(curSum);
            boolean right = dfs(root.left, set, curSum, preSum, target);
            set.remove(curSum);
            if (right) return true;
        }
        return false;

    }

}
