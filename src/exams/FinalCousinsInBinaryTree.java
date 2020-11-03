package exams;


import java.util.*;

public class FinalCousinsInBinaryTree {
    public boolean areCousins(TreeNode root, TreeNode one, TreeNode two) {
        // Assume the two nodes are in the tree!!
        if (root == null) {
            return false;
        }

        // recursively compare
        return (root.left == one && root.right == two) || (root.left == two && root.right == one)
                || areCousins(root.left, one, two) || areCousins(root.right, one, two);
    }
}

// Analysis
// TC: O(N)
// SC: O(Depth of the tree)