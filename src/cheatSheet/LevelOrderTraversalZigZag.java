package cheatSheet;
import java.util.*;

/*
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class LevelOrderTraversalZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // corner cases
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // bfs
        // !reverse: offerLeft, pollRight
        // reverse: offerRight, pollLeft
        boolean reverse = false; // false is scanning from left to rigth
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLayer = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = reverse ? queue.pollFirst() : queue.pollLast();
                curLayer.add(cur.val);

                // if now is false, next round should be inserted from right to left
                if (!reverse) {
                    if (cur.left != null) queue.offerFirst(cur.left);
                    if (cur.right != null) queue.offerFirst(cur.right);
                } else {
                    if (cur.right != null) queue.offerLast(cur.right);
                    if (cur.left != null) queue.offerLast(cur.left);
                }
            }

            result.add(curLayer);
            reverse = !reverse;
        }

        // return
        return result;
    }
}