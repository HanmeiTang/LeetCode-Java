package amazon;


import java.util.*;

class MusicPair {
    public int numPairsDivisibleBy60(int[] time) {
        // corner cases
        if (time == null || time.length == 0) {
            return 0;
        }

        // 1. construct data sets, O(N)
        int SIZE = 60;
        int sum = 0;
        List<List<Integer>> set = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            set.add(new ArrayList<Integer>());
        }

        for (int t : time) {
            if (t == 0) {
                continue;
            }

            set.get(t % SIZE).add(t);
        }

        // 2. loop checking O(N)
        // 2.1 check [1, 29] - [31, 59]
        for (int i = 1; i <= 29; i++) {
            sum += (set.get(i).size() * set.get(SIZE - i).size());
        }


        // 2.2 check 0, 30
        int a = set.get(0).size();
        if (a > 1) {
            sum += a * (a - 1) / 2;
        }

        int b = set.get(SIZE / 2).size();
        if (b > 1) {
            sum += b * (b - 1) / 2;
        }


        // return result
        return sum;
    }

    public static void main(String[] args) {
        MusicPair mc = new MusicPair();
        int output = mc.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        System.out.println(output);

    }
}

// Assumption
// 1. No such 0-length song --> otherwise? ignore it?
// 2. list is null or empty --> return 0

// Analysis
// [30,20,150,100,40]
// 3


//  0   1  2   3   4
// [30,20,150,100,40, 60]

// 1. construct the data sets
// mod result: [index collection]
// 0: [0, 1]
// 1: [2, 3]
// ...
// 59: [5, 6]


// 2. loop from [1, 29] checking pairs
//      1 & 59 - 1.len * 59.len
//   check 0 & 30
// len <= 1 --> 0 pairs
//  len >= 2 --> len * (len - 1)



