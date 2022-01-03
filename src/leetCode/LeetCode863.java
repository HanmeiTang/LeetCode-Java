package leetCode;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class LeetCode863 {
    private Map<TreeNode, Set<TreeNode>> graph;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        graph = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            K--;
            if (K < 0) break;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (K == 0) {
                    for (TreeNode node : graph.get(cur)) {
                        if (!seen.contains(node)) result.add(node.val);

                    }
                } else {
                    for (TreeNode node : graph.get(cur)) {
                        if (!seen.contains(node)) queue.offer(node);
                        seen.add(node);
                    }
                }
            }
        }
        return result;

    }

    // dfs to get the graph
    private void dfs(TreeNode node, TreeNode parent) {
        // base case
        if (node == null) return;

        // recursive rule
        Set<TreeNode> nei = graph.getOrDefault(node, new HashSet<TreeNode>());
        if (parent != null) nei.add(parent);
        if (node.left != null) {
            nei.add(node.left);
            dfs(node.left, node);
        }

        if (node.right != null) {
            nei.add(node.right);
            dfs(node.right, node);
        }

        graph.put(node, nei);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode target = new TreeNode(5);
        root.left = target;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LeetCode863 s = new LeetCode863();
        List<Integer> result = s.distanceK(root, target, 2);
        System.out.println(result);
    }
}


// BFS
// queue | root
// expand: add to cache to label the rank
// generate: if not null, add to queue
// if target rank is found, scan at most at K + targetRank
// finally return the list of node that has correct rank