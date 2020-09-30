import java.util.ArrayList;
import java.util.List;

public class Solution233 {
    public List<List<Integer>> nqueens(int n) {
        if (n <= 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>(n);
        nqueens(n, cur, result);
        return result;
    }

    private void nqueens(int n, List<Integer> cur, List<List<Integer>> result) {
        // base cases
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < n; i++) {
            cur.add(i);
            if (isValid(cur)) {
                nqueens(n, cur, result);
            }
            cur.remove(cur.size() - 1);
        }
    }

    // check the last element is valid or not
    private boolean isValid(List<Integer> cur) {
        if (cur.size() == 0 || cur.size() == 1) {
            return true;
        }

        int ind = cur.size() - 1;
        int val = cur.get(ind);

        for (int i = 0; i < cur.size() - 1; i++) {
            if (cur.get(i) == val || Math.abs(i - ind) == Math.abs(cur.get(i) - val)) {
                return false;
            }
        }

        return true;
    }
}
