package amazon;
import java.util.*;
public class LeetCode743 {
}

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // corner case

        // fixme: get graph
        // todo: this is another example
        // this is a standard comment
        Node[] set = new Node[N + 1]; // 1 to N, first one is always null
        for (int[] edge : times) {
            if (set[edge[0]] == null) set[edge[0]] = new Node(edge[0]);
            if (set[edge[1]] == null) set[edge[1]] = new Node(edge[1]);
            set[edge[0]].nei.put(set[edge[1]], edge[2]);
        }

        // bfs
        Queue<Node> q = new PriorityQueue<>();

        // return -1 if not found
        return -1;
    }
}


class Node {
    int val;
    Map<Node, Integer> nei;

    public Node(int val) {
        this.val = val;
        this.nei = new HashMap<>();
    }
}