package exams;

import java.util.ArrayList;
import java.util.List;

public class MidTermNQueens {
    public List<List<Integer>> nQueens(int n) {
        // corner cases
        if (n <= 0) {
            return null;
        }

        List<Integer> cur = new ArrayList<>(n);
        List<List<Integer>> result = new ArrayList<>();
        nQueens(n, cur, result);
        return result;
    }

    private void nQueens(int n, List<Integer> cur, List<List<Integer>> result) {
        // base cases
        if (n == cur.size()) {
            result.add(new ArrayList<Integer>(cur));
        }

        for (int i = 0; i < n; i++) {
            // try extend one
            cur.add(i);
            if (isValid(cur)) {
                nQueens(n, cur, result);
            }
            cur.remove(cur.size() - 1);
        }
    }

    // Check if the last element is valid
    private boolean isValid(List<Integer> cur) {
        // corner cases
        if (cur.size() == 0 || cur.size() == 1) {
            return true;
        }

        int ind = cur.size() - 1;
        int val = cur.get(ind);
        // loop comparison with all previous element
        for (int i = 0; i < cur.size() - 1; i++) {
            // the same row OR same diagonal
            if (cur.get(i) == val || Math.abs(i - ind) == Math.abs(cur.get(i) - val)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MidTermNQueens mid = new MidTermNQueens();
        List<List<Integer>> result = mid.nQueens(4);
        System.out.println(result);
    }
}

// Analysis, N is the input integer number.
// Time C = N * (N - 1) * ... * 1 = O(N!)
// Space C = stack + heap = N + N * N! --> O(N * N!)
