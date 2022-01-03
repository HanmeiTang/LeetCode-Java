package leetCode;

import java.util.*;


class LeetCode253 {
    public int minMeetingRooms(int[][] intervals) {
        // corner cases
        if (intervals == null || intervals.length == 0) return 0;
        // created a new list
        Queue<Integer> minHeap = new PriorityQueue<>(intervals.length * 2, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a != 0 && a + b == 0) return a - b;
                else return Math.abs(a) - Math.abs(b);
            }
        });

        for (int[] interval : intervals) {
            minHeap.offer(interval[0]);
            minHeap.offer(-interval[1]);
        }

        int room = 0;
        int max = 0;
        while (!minHeap.isEmpty()) {
            if (minHeap.poll() >= 0) room++;
            else room--;
            max = Math.max(max, room);
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode253 s = new LeetCode253();
        s.minMeetingRooms(new int[][]{{0, 30}, {5, 10}});
    }

}


// 1: [[0, 30], []]
// sorted by begin
// [[0, 30],[5, 10],[15, 20]]
// sorted by end
// [[5, 10],[15, 20], [0, 30]]
// minHeap: 
// 1. globalTime = 0
// 2. 

// time  0
//  [[0, 30],[5, 10],[15, 20]]
// 0...(5..10) room++; (15, 20) room++,30
// 


// 1: [[0, 30], []]
// sorted by begin
// [[0, 30],[5, 10],[15, 20]]
// sorted by end
// [[5, 10],[15, 20], [0, 30]]
// minHeap:
// 1. globalTime = 0
// 2.

// time  0
//  [[0, 30],[5, 10],[15, 20]]
// 0...(5..10) room++; (15, 20) room++,30
//