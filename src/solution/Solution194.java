package solution;

import java.util.*;

public class Solution194 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here
        Set<List<Integer>> set = new HashSet<>();
        Queue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> x, List<Integer> y) {
                long d1 = getDist(x.get(0), x.get(1), x.get(2));
                long d2 = getDist(y.get(0), y.get(1), y.get(2));
                if (d1 == d2) return 0;
                else return d1 > d2 ? 1 : -1;
            }
        });

        List<Integer> first = Arrays.asList(0, 0, 0);
        minHeap.offer(first);
        set.add(first);

        for (int i = 1; i < k; i++) {
            List<Integer> cur = minHeap.poll();

            List<Integer> s1 = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (s1.get(0) < a.length && set.add(s1)) {
                System.out.println(s1.toString());
                minHeap.offer(Arrays.asList(a[s1.get(0)], b[s1.get(1)], c[s1.get(2)]));
            }

            s1 = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (s1.get(1) < b.length && set.add(s1)) {
                minHeap.offer(Arrays.asList(a[s1.get(0)], b[s1.get(1)], c[s1.get(2)]));
            }

            s1 = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (s1.get(2) < c.length && set.add(s1)) {
                minHeap.offer(Arrays.asList(a[s1.get(0)], b[s1.get(1)], c[s1.get(2)]));
            }
        }


        // return
        List<Integer> r = minHeap.poll();
        List<Integer> output = Arrays.asList(a[r.get(0)], b[r.get(1)], c[r.get(2)]);
        return output;
    }

    private long getDist(int i, int j, int k) {
        long num = 0;
        num += i * i;
        num += j * j;
        num += k * k;
        return num;
    }

    public static void main(String[] args) {
        Solution194 s = new Solution194();
        s.closest(new int[]{1, 2, 3}, new int[]{2, 4}, new int[]{1, 2}, 10);
        // [[1,2,3],[2,4],[1,2],10]
    }
}

/*
heap<k>
hashSet seen
 a = {1, 2, 3}
 b = {2, 4}
 c = {0, 3}

     000                   100
 100 010 001           200 110 101
000, 100, 001, 010, 011, 110, 101, 111, 200, 210
                          x
*/