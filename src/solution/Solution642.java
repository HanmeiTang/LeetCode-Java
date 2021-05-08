package solution;

import java.util.*;

public class Solution642 {
    int n;
    char[] pair = new char[]{'(', ')', '[', ']', '{', '}'};

    public List<String> validParenthesesIII(int l, int m, int n) {
        // corner case
        List<String> result = new ArrayList<>();
        if (l + m + n == 0) return result;

        this.n = 2 * (l + m + n);
        Deque<Character> stack = new ArrayDeque<>();
        int[] pp = new int[]{l, l, m, m, n, n};
        StringBuilder sb = new StringBuilder();
        getPermutation(sb, pp, stack, result); // fixme

        return result;
    }

    private void getPermutation(StringBuilder sb, int[] pp, Deque<Character> stack, List<String> result) {
        // base case
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        // recursive rule

        // any left parenthese
        if ((stack.isEmpty() || stack.peekFirst() == '[' || stack.peekFirst() == '{') && pp[0] > 0) {
            sb.append('(');
            pp[0]--;
            stack.offerFirst('(');

            getPermutation(sb, pp, stack, result);

            sb.deleteCharAt(sb.length() - 1);
            pp[0]++;
            stack.pollFirst();
        }

        if ((stack.isEmpty() || stack.peekFirst() == '{') && pp[2] > 0) {
            sb.append('[');
            pp[2]--;
            stack.offerFirst('[');

            getPermutation(sb, pp, stack, result);

            sb.deleteCharAt(sb.length() - 1);
            pp[2]++;
            stack.pollFirst();
        }

        if (stack.isEmpty() && pp[4] > 0) {
            sb.append('{');
            pp[4]--;
            stack.offerFirst('{');

            getPermutation(sb, pp, stack, result);

            sb.deleteCharAt(sb.length() - 1);
            pp[4]++;
            stack.pollFirst();
        }

        if (!stack.isEmpty()) {
            char c = stack.peekFirst();
            int ind = 0;
            if (c == '[') ind = 2;
            else if (c == '{') ind = 4;

            sb.append(pair[ind + 1]);
            pp[ind + 1]--;
            stack.pollFirst();

            getPermutation(sb, pp, stack, result);

            sb.deleteCharAt(sb.length() - 1);
            pp[ind + 1]++;
            stack.offerFirst(c);
        }

    }

    public static void main(String[] args) {
        Solution642 s = new Solution642();
        s.validParenthesesIII(3, 1, 0);
    }
}

/*
 // l + m + n == 0 --> return blank
 2, 4, 6

 () {
stack | {

  stack is empty --> choose any one left, and push
  stack is not empty --> check the top, match or push more

   0
   string,
   active index stack


*/