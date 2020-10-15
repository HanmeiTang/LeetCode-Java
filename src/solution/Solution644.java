package solution;

import java.util.*;

public class Solution644 {
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
        if (input == null || input.size() == 0) {
            return new ArrayList<Integer>();
        }

        // minHeap, MaxHeap and result
        Queue<Cell> minHeap = new PriorityQueue<>(input.size(), new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                if (a.val == b.val) {
                    return 0;
                } else {
                    return a.val > b.val ? 1 : -1;
                }
            }
        });
        Queue<Cell> maxHeap = new PriorityQueue<>(input.size(), new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                if (a.val == b.val) {
                    return 0;
                } else {
                    return a.val > b.val ? -1 : 1;
                }
            }
        });
        List<Integer> result = new ArrayList<>();
        int[] ind = new int[input.size()];

        // Initialization
        int size = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != null && input.get(i).size() != 0) {
                minHeap.offer(new Cell(i, 0, input.get(i).get(0)));
                maxHeap.offer(new Cell(i, 0, input.get(i).get(0)));
                size += input.get(i).size();
            } else {
                return result;
            }
        }

        // check every element
        for (int i = 0; i < size; i++) {
            if (minHeap.size() != input.size()) {
                return result;
            }
            if (minHeap.peek().val == maxHeap.peek().val) {
                result.add(minHeap.peek().val);
                minHeap.clear();
                maxHeap.clear();

                for (int j = 0; j < input.size(); j++) {
                    ind[j]++;
                    if (ind[j] >= input.get(j).size()) {
                        return result;
                    }
                    minHeap.offer(new Cell(j, ind[j], input.get(j).get(ind[j])));
                    maxHeap.offer(new Cell(j, ind[j], input.get(j).get(ind[j])));
                }
            } else {

                Cell cur = minHeap.poll();
                maxHeap.clear();
                if (cur.y + 1 < input.get(cur.x).size()) {
                    cur.y = cur.y + 1;
                    cur.val = input.get(cur.x).get(cur.y);
                    minHeap.offer(cur);
                    ind[cur.x] = cur.y;
                }

                for (int j = 0; j < input.size(); j++) {
                    maxHeap.offer(new Cell(j, ind[j], input.get(j).get(ind[j])));
                }

            }

            if (minHeap.size() != input.size()) {
                return result;
            }
        }

        // return
        return result;
    }

    public static void main(String[] args) {
        Solution644 s = new Solution644();
        List<List<Integer>> input = new ArrayList<>();
        int[][] haha = new int[][]{
                {1, 1, 1, 3, 3, 3, 5, 7, 7, 8, 9, 11, 12, 13, 15, 17},
                {0, 2, 3, 3, 5, 6, 6, 8, 10, 10, 12, 14, 14, 15}};
        for (int i = 0; i < haha.length; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j : haha[i]) {
                cur.add(j);
            }
            input.add(cur);
        }

        List<Integer> result = s.commonElementsInKSortedArrays(input);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}


class Cell {
    public int x;
    public int y;
    public int val;

    public Cell(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
