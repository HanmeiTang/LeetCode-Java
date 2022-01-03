package leetCode;

import java.util.*;

class LeetCode957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;

        Map<String, Integer> map = new HashMap<>();
        List<String> steps = new ArrayList<>();
        map.put(getStr(cells), 1);

        int beg = 0;
        int end = 0;

        // count N, if the loop is found
        while (N > 0) {
            cells = next(cells);
            String cellStr = getStr(cells);
            map.put(cellStr, map.getOrDefault(cellStr, 0) + 1);

            // cycle not found yet
            if (map.get(cellStr) == 1) {
                steps.add(cellStr);
                N--;
            } else if (map.get(cellStr) == 2) {
                // find the beginning of cycle
                beg = steps.indexOf(cellStr);
                end = steps.size() - 1;
                break;
            }
        }

        // if N is not zero yet
        if (N > 0) {
            N = N % (end - beg + 1);
            return getCell(steps.get(beg + N));
        } else {
            return cells;
        }
    }

    // private method to get next day
    private int[] next(int[] cells) {
        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 7) {
                temp[i] = 0;
                continue;
            }
            if (cells[i - 1] == cells[i + 1]) temp[i] = 1;
            else temp[i] = 0;
        }
        return temp;
    }

    private String getStr(int[] cells) {
        char[] a = new char[8];
        for (int i = 0; i < 8; i++) a[i] = (char) ('0' + cells[i]);
        return new String(a);
    }

    private int[] getCell(String s) {
        int[] cells = new int[8];
        for (int i = 0; i < 8; i++) cells[i] = s.charAt(i) - '0';
        return cells;
    }

    public static void main(String[] args) {
        LeetCode957 s = new LeetCode957();
        System.out.println(s.getStr(s.next(s.getCell("10001000"))));
        int[] result = s.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        System.out.println(Arrays.toString(result));
    }
}
//       3  2  1  0 --> 5
//  0 1  2  3
// [0 1 '2 '3 '4 '5] 6

// 10001000
// 10101010


//
// beg = 2
//
// 001001001
// 000000000
//  1111111
//  0111110
// 100110011
// 000000000 -> xxxx -> used in hashmap
// 1 -> 2 -> 3
//       \    \
//        5 <- 4
//
// map
// 1: 1
// 2: 2 ! --> there is a cycle
// run the cycle again to determine the cycle node number
// if N is not finished yet, calculate the list
