import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution67 {
    public String[] topKFrequent(String[] combo, int k) {
        // corner cases
        if (combo == null || combo.length == 0) {
            return new String[0];
        }

        // init a hash map
        Map<String, Integer> dict = new HashMap<String, Integer>();
        String[] result;

        // organize everything to hashmap
        for (int i = 0; i < combo.length; i++) {
            if (!dict.containsKey(combo[i])) {
                dict.put(combo[i], 1);
            } else {
                dict.put(combo[i], dict.get(combo[i]) + 1);
            }
        }

        // new a minHeap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        for (Map.Entry<String, Integer> element : dict.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(element);
            } else if (element.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(element);
            }
        }

        for (Map.Entry<String, Integer> element : minHeap) {
            System.out.println(element.getKey());
        }

        // put all element from minHeap to String[]
        int size = Math.min(k, dict.size());
        result = new String[size];

        for (int i = size - 1; i >= 0; i--) {
            //System.out.print(minHeap.peek().getKey());
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"a", "a", "a", "b", "b", "c"};
        Solution67 s = new Solution67();
        String[] result = s.topKFrequent(test, 2);
        for (String i : result) {
            System.out.printf("\n%s ", i);
        }
    }
}
