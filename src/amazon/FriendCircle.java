package amazon;

import java.util.*;

public class FriendCircle {
    public int findCircleNum(int[][] M) {
        // corner cases
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }


        // initialization
        int n = M.length;
        Queue<Integer> friends = new LinkedList<>();
        int numCircles = 0;
        boolean[] checked = new boolean[n];


        // BFS loops
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && !checked[i]) {
                    numCircles++;
                    friends.offer(i);
                    checked[i] = true;

                    while (!friends.isEmpty()) {
                        int cur = friends.poll();
                        for (int k = 0; k < n; k++) {
                            if (!checked[k] && M[cur][k] == 1) {
                                checked[k] = true;
                                friends.offer(k);
                            }
                        }
                    }
                }
            }
        }


        // return
        return numCircles;

    }
}


// Analysis

// 1. scan until find a '1'
// [[1,1,0],
// [1,1,1],
// [0,1,1]]

// 2. bfs all friends

//