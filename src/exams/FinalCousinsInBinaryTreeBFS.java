package exams;

import java.util.*;

public class FinalCousinsInBinaryTreeBFS {
    public boolean areCousins(TreeNode root, TreeNode one, TreeNode two) {
        // corner case
        if (root == null || one == null || two == null) {
            return false;
        }

        // queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            boolean foundOne = false;
            boolean foundTwo = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur == one) {
                    foundOne = true;
                }

                if (cur == two) {
                    foundTwo = true;
                }

                if ((cur.left == one && cur.right == two) || (cur.right == one && cur.left == two)) {
                    return false;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            // if they are found
            if (foundOne && foundTwo) {
                return true;
            } else if (foundOne || foundTwo) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        root.left.left = node3;
        root.left.right = node4;
        root.right.left = node5;
        root.right.right = node6;

        FinalCousinsInBinaryTreeBFS fcit = new FinalCousinsInBinaryTreeBFS();
        boolean output = fcit.areCousins(root, node5, node3);
        System.out.println(output);

        output = fcit.areCousins(root, node1, node3);
        System.out.println(output);

        output = fcit.areCousins(root, node1, node2);
        System.out.println(output);
    }
}
