package solution;
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
public class Solution524 {
    private String arrow = "->";

    public String[] binaryTreePaths(TreeNode root) {
        // corner case
        if (root == null) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(root, result, cur);

        String[] output = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }

    private void dfs(TreeNode root, List<String> result, List<String> cur) {
        // base case
        if (root.left == null && root.right == null) {
            cur.add(String.valueOf(root.key));
            result.add(String.join(arrow, cur));
            cur.remove(cur.size() - 1);
            return;
        }

        if (root.left != null) {
            cur.add(String.valueOf(root.key));
            dfs(root.left, result, cur);
            cur.remove(cur.size() - 1);
        }

        if (root.right != null) {
            cur.add(String.valueOf(root.key));
            dfs(root.right, result, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        Solution524 s = new Solution524();
        String[] result = s.binaryTreePaths(root);
        for (String i : result) {
            System.out.println(i);
        }
    }
}
