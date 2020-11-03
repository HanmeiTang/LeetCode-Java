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
        max[0] = Math.max(max[0], leftSum + rightSum + root.key);

        return Math.max(leftSum, rightSum) + root.key;
    }

    public static void main(String[] args) {
        MidTermMaxPath mid = new MidTermMaxPath();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(-4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        int result = mid.getMaxPath(root);
        System.out.println(result);
    }
}


// Analysis, N is number of the given tree
// Time C = O(N)
// Space C = O(height of the given tree)