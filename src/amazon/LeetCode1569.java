package amazon;

import java.util.*;

class LeetCode1569 {
    public List<String> restoreIpAddresses(String s) {
        // corner cases
        if (s == null || s.length() <= 3) {
            return new ArrayList<String>();
        }

        // dfs
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(s, sb, 0, result); // FIXME

        // result return
        return result;
    }

    // private
    private void dfs(String s, StringBuilder sb, int ind, List<String> result) {
        // base case
        if (s.length() == 0) return;
        if (ind == 3) {
            System.out.println(ind);
            System.out.println(s);
            if (Integer.valueOf(s) > 255) return;
            if (s.length() > 1 && s.charAt(0) == '0') return;
            sb.append(s);
            result.add(sb.toString());
            return;
        }

        // recursive rule
        // ind = 0, s.len = 5 --> max 2
        // ind = 1, s.len = 5 --> max 3
        // maxLen = s.len + ind - 3

        for (int len = 1; len <= Math.min(s.length() + ind - 3, 3); len++) {
            String backup = sb.toString();
            String segment = s.substring(0, len);
            if (len == 1
                    || (len > 1
                    && segment.charAt(0) != '0'
                    && Integer.valueOf(segment) <= 255)) {
                sb.append(segment);
                sb.append(".");
                dfs(s.substring(len), sb, ind + 1, result);
            }


            sb = new StringBuilder(backup);
        }
    }

    public static void main(String[] args) {
        LeetCode1569 l = new LeetCode1569();

        System.out.println(l.restoreIpAddresses("0279245587303"));
    }
}

/*
   25525511135
0  2, 25, 255

1 5, 55

2


3 have to digest all the rest, no choice any more


1, 2, 3 digits if available
&& the number in 0,255 range
*/