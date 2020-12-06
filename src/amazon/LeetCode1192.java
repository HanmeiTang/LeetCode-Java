package amazon;


import java.util.*;

class LeetCode1192 {
    // We record the timestamp that we visit each node. For each node, we check every neighbor
    // except its parent and return a smallest timestamp in all its neighbors. If this timestamp
    // is strictly less than the node's timestamp, we know that this node is somehow in a cycle.
    // Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] label = new int[n];

        dfs(graph, -1, 0, timer, visited, results, label);

        return results;
    }


    public void dfs(List<Integer>[] graph, int parent, int node, int timer[],
                    boolean[] visited, List<List<Integer>> results, int[] label) {

        visited[node] = true;
        label[node] = timer[0];
        timer[0]++;
        int curTime = label[node];

        for (int nei : graph[node]) {
            if (nei == parent) continue;
            if (!visited[nei]) dfs(graph, node, nei, timer, visited, results, label);
            label[node] = Math.min(label[node], label[nei]);
            if (curTime < label[nei]) results.add(Arrays.asList(node, nei));
        }


    }

}