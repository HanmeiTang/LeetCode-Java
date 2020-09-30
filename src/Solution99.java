import java.util.HashSet;

public class Solution99 {
    public boolean canBreak(String input, String[] dict) {
        // corner cases
        if (input == null || input.length() == 0) {
            return false;
        }

        if (dict == null || dict.length == 0) {
            return false;
        }

        // preprocessing, base case and dp table
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] == null || dict[i].length() == 0) {
                return false;
            }
            set.add(dict[i]);
        }

        boolean[] dp = new boolean[input.length()];

        for (int i = 0; i < input.length(); i++) {
            System.out.println(i);
            dp[i] = false;
            // check all from set
            System.out.println("line 28 " + input.substring(0, i + 1));
            if (set.contains(input.substring(0, i + 1))) {
                dp[i] = true;

                break;
            }

            for (int j = 1; j <= i; j++) {
                // check left part from table
                // check right part from set
                System.out.println("line 38 " + input.substring(j, i + 1));
                if (dp[j - 1] && set.contains(input.substring(j, i + 1))) {
                    dp[i] = true;
                    System.out.println("line 41");
                    break;

                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution99 s = new Solution99();
        boolean output = s.canBreak("catbobd", new String[]{"cat", "bob", "d"});
        System.out.println(output);
    }
}
