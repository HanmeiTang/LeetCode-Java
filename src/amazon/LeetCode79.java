package amazon;

//class LeetCode79 {
//    public boolean exist(char[][] board, String word) {
//        // find the beginning letter
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    char c = board[i][j];
//                    board[i][j] = '*';
//                    if (dfs(word, i, j, board, 0)) return true;
//                    board[i][j] = c;
//                }
//            }
//        }
//
//        // return until the end
//        return false;
//    }
//
//    // [i, j] is the index word
//    private boolean dfs(String word, int i, int j, char[][] board, int index) {
//        // base case
//        if (index >= word.length() - 1) {
//            return true;
//        }
//
//        // dfs recursive rule
//        int[][] shift = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        for (int[] s : shift) {
//            i += s[0];
//            j += s[1];
//            if (i < board.length && i >= 0
//                    && j < board[0].length && j >= 0
//                    && board[i][j] == word.charAt(index + 1)) {
//                char c = board[i][j];
//                board[i][j] = '*';
//                boolean result = dfs(word, i, j, board, index + 1);
//                board[i][j] = c;
//                return result;
//            }
//            i -= s[0];
//            j -= s[1];
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        LeetCode79 s = new LeetCode79();
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        boolean result = s.exist(board, "ABCE");
//        System.out.println(result);
//    }
//}


class LeetCode79 {
    private String word;
    private char[][] board;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        // corner cases
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
        if (word.length() == 0) return true;
        m = board.length;
        n = board[0].length;
        this.word = word;
        this.board = board;

        // scan through the table and find possible first locations
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, i, j)) return true;
            }
        }

        // return
        return false;
    }

    // if current letter is a match
    private boolean dfs(int ind, int x, int y) {
        // base cases && corner cases
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != word.charAt(ind)) return false;
        if (ind == word.length() - 1) return true;

        // expanding rule / recursive rule

        char c = board[x][y];

        int[] xx = new int[]{-1, 0, 1, 0};
        int[] yy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            board[x][y] = '*';
            boolean result = dfs(ind + 1, x + xx[i], y + yy[i]);
            board[x][y] = c;
            if (result) return true;
        }

        return false;
    }
}

// 1. find all possible beginnings
// ABCCED
//  A1 A2 A3
//  /B?
//

// Analysis
// DFS
//