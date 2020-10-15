package solution;

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

import java.util.*;


public class Solution213 {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        if (inOrder == null || preOrder == null
                || inOrder.length != preOrder.length || inOrder.length == 0) {
            return null;
        }

        // inorder map and preorder list + two pointers
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            iMap.put(inOrder[i], i);
        }

        // left inclusive, right exclusive range
        return reconstruct(iMap, preOrder, 0, inOrder.length);
    }

    private TreeNode reconstruct(
            Map<Integer, Integer> iMap, int[] preOrder, int beg, int end) {
        // corner case
        if (beg >= end || beg >= preOrder.length || end > preOrder.length) {
            return null;
        }

        // recursion
        TreeNode root = new TreeNode(preOrder[beg]);
        int rootInd = iMap.get(root.key);
        int leftEnd = beg;
        int rightBeg = end;

        for (int i = beg + 1; i < end; i++) {
            if (iMap.get(preOrder[i]) < rootInd) {
                leftEnd = i + 1;
            }

            if (iMap.get(preOrder[i]) > rootInd) {
                rightBeg = i;
                break;
            }
        }
        root.left = reconstruct(iMap, preOrder, beg + 1, leftEnd);
        root.right = reconstruct(iMap, preOrder, rightBeg, end);

        return root;
    }
}

