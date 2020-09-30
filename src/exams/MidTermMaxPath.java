package exams;


class MidTermMaxPath {
    public int getMaxPath(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getSum(root, max);
        return max[0];
    }

    private int getSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftSum = getSum(root.left, max);
        int rightSum = getSum(root.right, max);

        leftSum = leftSum < 0 ? 0 : leftSum;
        rightSum = rightSum < 0 ? 0 : rightSum;
        max[0] = Math.max(max[0], leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        MidTermMaxPath mid = new MidTermMaxPath();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(-4);
        int result = mid.getMaxPath(root);
        System.out.println(result);
    }
}


class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

// Analysis, N is number of the given tree
// Time C = O(N)
// Space C = O(height of the given tree)