package leetCode;

import java.util.*;

class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner cases

        // Construct the graph
        Map<String, Set<String>> graph = constructGraph(wordList);
        Set<String> visited = new HashSet<>();

        Set<String> nodes1 = new HashSet<>();
        for (String word : wordList) if (hasEdge(word, beginWord)) nodes1.add(word);
        graph.put(beginWord, nodes1);

        // BFS
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return count;

                for (String nei : graph.get(cur)) {
                    if (!visited.contains(nei)) {
                        queue.offer(nei);
                        visited.add(nei);
                    }
                }

            }
        }


        // return
        return 0;
    }

    // private method constructing the graph, O(N2)
    private Map<String, Set<String>> constructGraph(List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String w1 = wordList.get(i);
                String w2 = wordList.get(j);
                if (hasEdge(w1, w2)) {
                    Set<String> set1 = graph.getOrDefault(w1, new HashSet<String>());
                    set1.add(w2);
                    graph.put(w1, set1);

                    Set<String> set2 = graph.getOrDefault(w2, new HashSet<String>());
                    set2.add(w1);
                    graph.put(w2, set2);
                }
            }
        }

        return graph;
    }

    // private method determine two nodes have an edge
    // which differ by one letter only
    private boolean hasEdge(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count == 1;
    }

    public static void main(String[] args) {
        LeetCode127 l = new LeetCode127();
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"});
        int i = l.ladderLength("hit", "cog", wordList);
        System.out.println(i);
    }
}