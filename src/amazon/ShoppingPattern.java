package amazon;

import java.lang.reflect.Array;
import java.util.*;

public class ShoppingPattern {
    public static int getMinScore(int products_nodes, int products_edges, int[] products_from, int[] products_to) {
        // corner cases

        // Pre-processing
        // Construct a graph using the given pairs
        Map<Integer, Set<Integer>> graph = constructGraph(products_from, products_to);

        // Get all possible trios by iterating all nodes
        Set<Set<Integer>> trios = new HashSet<>();
        for (int node : graph.keySet()) {
            for (int first : graph.get(node)) {
                for (int second : graph.get(first)) {
                    if (graph.get(second).contains(node)) {
                        Set<Integer> trio = new HashSet<>();
                        trio.add(node);
                        trio.add(first);
                        trio.add(second);
                        trios.add(trio);
                    }
                }
            }
        }

        // get min score
        int minScore = Integer.MAX_VALUE;
        for (Set<Integer> trio : trios) {
            int score = 0;
            for (int i : trio) {
                score += graph.get(i).size() - 2;
            }
            minScore = Math.min(minScore, score);
        }

        // return
        return minScore == Integer.MAX_VALUE ? -1 : minScore;
    }

    private static Map<Integer, Set<Integer>> constructGraph(int[] a, int[] b) {
        // may assume all input are valid
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            // add A--> B pair
            Set<Integer> neighbour = graph.getOrDefault(a[i], new HashSet<Integer>());
            neighbour.add(b[i]);
            graph.put(a[i], neighbour);

            // add B --> A pair
            neighbour = graph.getOrDefault(b[i], new HashSet<Integer>());
            neighbour.add(a[i]);
            graph.put(b[i], neighbour);
        }
        return graph;
    }

    public static void main(String[] args) {

        int result = ShoppingPattern.getMinScore(6, 6,
                new int[]{1, 2, 2, 3, 4, 5}, new int[]{2, 4, 5, 5, 5, 6});
        System.out.println(result);
    }
}


//    Product           Related Product
//        1                  2
//        2                  1, 4, 5
//        3                  5
//        4                  2, 5
//        5                  2, 3, 4, 6
//        6                  5