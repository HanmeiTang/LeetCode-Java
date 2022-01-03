package leetCode;

import java.util.*;

class LeetCode105 {

    Map<Integer, Integer> hm = new HashMap<>();
    int startIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[startIndex++]);
        if (start == end) return root;

        int index = hm.get(root.val);

        root.left = helper(preorder, start, index - 1);
        root.right = helper(preorder, index + 1, end);

        return root;

    }

    public static void main(String[] args) {
        LeetCode105 lc = new LeetCode105();
        TreeNode t = lc.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}