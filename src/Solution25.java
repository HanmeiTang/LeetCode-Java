import java.util.*;

public class Solution25 {
    public int[] kSmallest(int[] array, int k) {
        // corner cases
        if (array == null) {
            return new int[]{};
        }

        // avoid out of bound
        k = k <= array.length ? k : array.length;

        // Create a max heap with k elements
        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a.equals(b)) {
                    return 0;
                } else {
                    return a > b ? -1 : 1;
                }
            }
        });

        // put in the first k elements
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }

        // add remaining length - k elements to maxHeap
        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        // The returned numbers should be in ascending order
        int[] result = new int[k];
        Queue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.offer(maxHeap.poll());
        }

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        System.out.println("abc".length());
    }
}