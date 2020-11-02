package exams;

import java.util.*;

public class MockInterview1 {
    public List<List<String>> getPossibleWays(String input, Set<String> dict) {
        // corner cases
        if (input == null || dict == null || input.length() == 0 || dict.size() == 0) {
            return new ArrayList<List<String>>();
        }

        // recursion run DFS
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<String>(), 0, input.length(), input, dict);

        // return result
        return result;
    }

    // int left is the left bound of the string being checked, inclusive
    // int right is the right bound of the string being checked, exclusive
    private void dfs(List<List<String>> result,
                     List<String> cur, int left, int right, String input, Set<String> dict) {
        // base case
        if (right == input.length()) {
            // check the result
            if (match(input, left, right, dict)) {
                cur.add(input.substring(left, right));
                result.add(new ArrayList<String>(cur));
                cur.remove(cur.size() - 1);
                return;
            }
        }

        // recursive rule
        for (int i = left + 1; i <= right; i++) {
            if (match(input, left, i, dict)) {
                cur.add(input.substring(left, i));
                dfs(result, cur, i, right, input, dict);
                cur.remove(cur.size() - 1);
            }
        }
    }

    // check if the string from index 'left' to index 'right' match one of the element in the hashset
    private boolean match(String input, int left, int right, Set<String> dict) {
        // assume all the input here are valid
        return dict.contains(input.substring(left, right));
    }


    public static void main(String[] args) {
        MockInterview1 m = new MockInterview1();
        Set<String> dict = new HashSet<>();
        for (String i : new String[]{"cat", "ca", "cats", "and", "sand", "tsan", "d"}) {
            dict.add(i);
        }
        List<List<String>> result = m.getPossibleWays("catsand", dict);
        for (List<String> i : result) {
            System.out.println(i);
        }
    }
}
