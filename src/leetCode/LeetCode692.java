package leetCode;

import java.util.*;

class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        // corner cases: okay


        // hashmap
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        // minHeap
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                else return -1 * e1.getValue().compareTo(e2.getValue());
            }
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            maxHeap.offer(e);
        }

        // get the k elements
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;

    }
}

