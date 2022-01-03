package laiCode;

import java.util.*;

/**
 * public class TreeNode {
 * public int key;
 * public TreeNode left;
 * public TreeNode right;
 * public TreeNode(int key) {
 * this.key = key;
 * }
 * }
 */
public class Solution211 {
    public TreeNode reconstruct(int[] post) {
        // corner case
        if (post == null || post.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        for (int i : post) {
            list.add(i);
        }

        // recursively extend
        return reconstruct(list);
    }

    private TreeNode reconstruct(List<Integer> list) {
        // base case
        if (list == null || list.size() == 0) {
            return null;
        }

        // recursive rule
        TreeNode root = new TreeNode(list.get(list.size() - 1));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < root.key) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        System.out.println(list);

        root.left = reconstruct(left);
        root.right = reconstruct(right);

        // return
        return root;
    }

    public static void main(String[] args) {
        Solution211 s = new Solution211();
        TreeNode root = s.reconstruct(new int[]{1,2,4,7,5,10,13,12,8,3});
        System.out.println(root.left.key);
        System.out.println(root.right.key);
    }
}
