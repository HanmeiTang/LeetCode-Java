package amazon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class getMinScore {

    /*
     * Complete the 'getMinScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH products as parameter.
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        // corner cases
        // Assume all inputs are valid

        // 1. Pre processing: convert productsFrom, productsTo to a graph
        Map<Integer, Set<Integer>> graph = constructGraph(productsFrom, productsTo);

        // 2. Iterate all nodes and find trios
        // if found a trio, update product sum
        int minScore = Integer.MAX_VALUE;
        for (int node : graph.keySet()) {
            for (int first : graph.get(node)) {
                for (int second : graph.get(first)) {
                    // Once find a valid trio
                    if (graph.get(second).contains(node)) {
                        int score = 0;

                        for (int n : new int[]{node, first, second}) {
                            score += graph.get(n).size() - 2;
                        }
                        // update global minScore
                        minScore = Math.min(minScore, score);
                    }
                }
            }
        }

        // return
        return minScore == Integer.MAX_VALUE ? -1 : minScore;
    }

    /*
     *  Construct a graph using productsFrom and productsTo
     *  TC: O(edges)
     *  SC: O(nodes)
     */
    private static Map<Integer, Set<Integer>> constructGraph(List<Integer> a, List<Integer> b) {
        // assume input are valid

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            // add A --> B edge
            Set<Integer> neighbour = graph.getOrDefault(a.get(i), new HashSet<Integer>());
            neighbour.add(b.get(i));
            graph.put(a.get(i), neighbour);

            // add B --> A edge
            neighbour = graph.getOrDefault(b.get(i), new HashSet<Integer>());
            neighbour.add(a.get(i));
            graph.put(b.get(i), neighbour);
        }

        return graph;
    }

}
