package solution;

import java.util.*;

public class Solution65 {
    public List<String> permutations(String input) {
        // corner case
        if (input == null) {
            return new ArrayList<String>();
        }

        if (input.length() <= 1) {
            List<String> output = new ArrayList<String>();
            output.add(input);
            return output;
        }

        // init
        List<String> result = new ArrayList<>();
        char[] cur = input.toCharArray();

        // recursion run dps
        dfs(cur, result, 0);

        return result;
    }

    // helper function run recursive dfs
    private void dfs(char[] cur, List<String> result, int index) {
        // base case
        if (index == cur.length) {
            result.add(new String(cur));
            return;
        }

        // recursive rule
        Set<Character> used = new HashSet<>();
        for (int i = index; i < cur.length; i++) {
            if (used.add(cur[i])) {
                swap(cur, i, index);
                dfs(cur, result, index + 1);
                swap(cur, index, i);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution65 s = new Solution65();
        List<String> result = s.permutations("aab");
        for (String i: result) {
            System.out.println(i);
        }
    }
}

// Analysis
// TC:

