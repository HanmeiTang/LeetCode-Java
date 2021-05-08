package solution;

import java.util.*;

public class Solution195 {

    private int minDist = Integer.MAX_VALUE;
    private List<Integer> chairSite;
    private char[][] gym;
    private int numE;

    public List<Integer> putChair(char[][] gym) {
        // corner cases

        // count equipment, count chair site
        this.gym = gym;
        chairSite = new ArrayList<>();
        chairSite.add(-1);
        chairSite.add(-1);

        int m = gym.length;
        int n = gym[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == 'E') numE++;
            }
        }

        // iterate all available sites and get the minimum dist
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == 'C') {
                    bfs(i, j);
                }
            }
        }

        // return
        return chairSite;
    }

    // update minDist if possible
    private void bfs(int i, int j) {
        int count = 0;
        int dist = 0;
        int m = gym.length;
        int n = gym[0].length;
        boolean[][] seen = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 0});
        seen[i][j] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int[] coord = q.poll();
                int x = coord[0];
                int y = coord[1];
                int d = coord[2];

                if (count < numE && x - 1 >= 0 && !seen[x - 1][y] && gym[x - 1][y] != 'O') {
                    q.offer(new int[]{x - 1, y, d + 1});
                    seen[x - 1][y] = true;

                    if (gym[x - 1][y] == 'E') {
                        count++;
                        dist += d + 1;
                    }
                }

                if (count < numE && x + 1 < m && !seen[x + 1][y] && gym[x + 1][y] != 'O') {
                    q.offer(new int[]{x + 1, y, d + 1});
                    seen[x + 1][y] = true;

                    if (gym[x + 1][y] == 'E') {
                        count++;
                        dist += d + 1;
                    }
                }

                if (count < numE && y - 1 >= 0 && !seen[x][y - 1] && gym[x][y - 1] != 'O') {
                    q.offer(new int[]{x, y - 1, d + 1});
                    seen[x][y - 1] = true;

                    if (gym[x][y - 1] == 'E') {
                        count++;
                        dist += d + 1;
                    }
                }

                if (count < numE && y + 1 < n && !seen[x][y + 1] && gym[x][y + 1] != 'O') {
                    q.offer(new int[]{x, y + 1, d + 1});
                    seen[x][y + 1] = true;
                    if (gym[x][y + 1] == 'E') {
                        count++;
                        dist += d + 1;
                    }
                }
            }
        }

        // update data
        if (dist < minDist) {
            minDist = dist;
            chairSite.set(0, i);
            chairSite.set(1, j);
        }
        System.out.printf("%d, %d, %d, %d\n", i, j, count, dist);
    }

    public static void main(String[] args) {
        Solution195 s = new Solution195();
        char[][] chairs = new char[][]{
                {'C', 'C', 'E', 'O', 'C'},
                {'C', 'C', 'O', 'C', 'E'},
                {'C', 'C', 'E', 'E', 'C'},
                {'C', 'O', 'C', 'E', 'E'},
                {'C', 'C', 'O', 'C', 'C'}
        };

        List<Integer> chair = s.putChair(chairs);
    }
}

/*
1. if no C --> return -1, -1


*/