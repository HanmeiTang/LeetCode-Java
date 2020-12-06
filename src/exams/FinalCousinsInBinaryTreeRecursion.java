package exams;

public class FinalCousinsInBinaryTreeRecursion {
    public boolean areCousins(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || one == null || two == null) {
            return false;
        }
        int depth = getDepth(root, one, two);
        return depth != -1;
    }

    private int getDepth(TreeNode root, TreeNode one, TreeNode two) {
        // base case
        if (root == null) {
            return -1; // not found
        }

        if (root == one || root == two) {
            return 0; // found one
        }

        // recursion rule
        int leftDep = getDepth(root.left, one, two);
        int rightDep = getDepth(root.right, one, two);

        if (leftDep > 0 && rightDep > 0) {
            if (leftDep == rightDep) {
                return leftDep + 1;
            } else {
                return -1;
            }
        } else if ((leftDep >= 0 && rightDep == -1) || (rightDep >= 0 && leftDep == -1)) {
            return Math.max(leftDep, rightDep) + 1;
        } else {
            return -1;
        }
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

        FinalCousinsInBinaryTreeRecursion fcit = new FinalCousinsInBinaryTreeRecursion();
        boolean output = fcit.areCousins(root, node5, node3);
        System.out.println(output);

        output = fcit.areCousins(root, node1, node3);
        System.out.println(output);

        output = fcit.areCousins(root, node1, node2);
        System.out.println(output);
    }

}

//      0
//     /  \
//    1   2
//   /|   /\
//  3 4  5 6

// Analysis
// 1.  null checked
// 2.  root
//    /   \
//   null null

// 3.  root
//    /   \
//   left null

// 4.  root
//    /   \
//   null right

// 5.  root
//    /   \
//   left right