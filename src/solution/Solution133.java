package solution;


// solution 1: A1 + A2, A12 + A3, A123 + A4...
// solution 2: A1 + A2; A3 + A4; A12 + A34...
// solution 3: k-size minHeap

import javax.management.MBeanAttributeInfo;
import java.util.*;

// solution 1: A1 + A2, A12 + A3, A123 + A4...
// solution 2: A1 + A2; A3 + A4; A12 + A34...
// solution 3: k-size minHeap
import java.util.*;

public class Solution133 {
    public int[] merge(int[][] arrayOfArrays) {
        // corner cases
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return new int[0];
        }

        // create a minHeap of size k
        Queue<Entry> minHeap
                = new PriorityQueue<>(arrayOfArrays.length, new Comparator<Entry>() {
            @Override
            public int compare(Entry a, Entry b) {
                if (a.val == b.val) {
                    return 0;
                } else {
                    return a.val > b.val ? 1 : -1;
                }
            }
        });

        // add all k elements at global index ind
        // create result
        int size = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i] != null && arrayOfArrays[i].length > 0) {
                size += arrayOfArrays[i].length;
                minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
            }
        }

        // !!
        if (size == 0) {
            return new int[0];
        }

        int[] result = new int[size];

        // helper function run
        helper(minHeap, arrayOfArrays, result);

        // return result
        return result;
    }

    private void helper(Queue<Entry> minHeap, int[][] arrayOfArrays, int[] result) {
        // get all k elements
        int ind = 0;
        while (!minHeap.isEmpty()) {
            Entry cur = minHeap.poll();
            result[ind++] = cur.val;
            if (cur.y + 1 < arrayOfArrays[cur.x].length) {
                cur.y++;
                cur.val = arrayOfArrays[cur.x][cur.y];
                minHeap.offer(cur);
            }
        }
    }
}

class Entry {
    public int x;
    public int y;
    public int val;

    public Entry(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public static void main(String[] args) {
        Solution133 s = new Solution133();
        int[] result = s.merge(new int[][]{{},{},{}});
    }
}
