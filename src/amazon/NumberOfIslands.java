package amazon;

import java.util.*;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // corner cases
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // Queue<Integer> to store all elements
        int height = grid.length;
        int width = grid[0].length;
        int islandCount = 0;
        Queue<Integer> queue = new LinkedList<>();

        // BFS
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '0') continue;

                // once find a valid cell
                queue.offer(i * width + j);
                grid[i][j] = '0';
                islandCount++;

                while (!queue.isEmpty()) {
                    int val = queue.poll();
                    int x = val / width;
                    int y = val % width;

                    // left
                    if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                        queue.offer((x - 1) * width + y);
                        grid[x - 1][y] = '0';
                    }

                    // right
                    if (x + 1 < height && grid[x + 1][y] == '1') {
                        queue.offer((x + 1) * width + y);
                        grid[x + 1][y] = '0';
                    }

                    // up
                    if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                        queue.offer(x * width + y - 1);
                        grid[x][y - 1] = '0';
                    }

                    // down
                    if (y + 1 < width && grid[x][y + 1] == '1') {
                        queue.offer(x * width + y + 1);
                        grid[x][y + 1] = '0';
                    }
                }

            }
        }

        // return
        return islandCount;
    }
}

// Analysis
// BFS
// scan every row of the given gird
//      once found a cell with value of '1'
//      then add this cell to Queue and run BFS until Queue is empty again
//