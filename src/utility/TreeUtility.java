package utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * {
 * <p>
 * }
 * }
 */

class TreeNode {
    public int key;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(Integer key) {
        this.key = key;
    }
}

public class TreeUtility {
    public static TreeNode getTreeFromList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new TreeNode(null);
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int ind = 0;
        queue.offer(new TreeNode(list.get(ind)));
        TreeNode root = queue.peek();

        while (!queue.isEmpty()) {
             TreeNode curNode = queue.poll();

            ind++;
            if (ind < list.size()) {
                curNode.left = new TreeNode(list.get(ind));
                if (list.get(ind) != null) {
                    queue.offer(curNode.left);
                }
            }
            else {
                curNode.left = null;
            }

            ind++;
            if (ind < list.size()) {
                curNode.right = new TreeNode(list.get(ind));
                if (list.get(ind) != null) {
                    queue.offer(curNode.right);
                }
                ind++;
            } else {
                curNode.right = null;
            }
        }

        return root;
    }


    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("_");
        }
        // FIXME
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        l.add(4);
        l.add(3);
        l.add(19);
        l.add(1);
        l.add(null);
        l.add(18);
        l.add(35);
        l.add(null);
        l.add(null);
        l.add(3);
        System.out.println(l.toString());
        TreeNode root = getTreeFromList(l); // FIXME: Buggy!
        //System.out.print(root.key);
    }
}
