import java.util.*;


public class Solution179 {
    public List<String> validParentheses(int l, int m, int n) {
        // corner case
        if (l < 0 || m < 0 || n < 0) {
            return null;
        }

        char[] cur = new char[l * 2 + m * 2 + n * 2];
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', l);
        map.put(')', l);
        map.put('<', m);
        map.put('>', m);
        map.put('{', n);
        map.put('}', n);


        dfs(result, map, 0, cur, stack);

        return result;
    }

    private void dfs(List<String> result, Map<Character, Integer> map, int index, char[] cur, Deque<Character> stack) {
        // base case
        if (index >= cur.length) {
            result.add(new String(cur));
            return;
        }

        // dfs rules
        for (char item : map.keySet()) {
            if (map.get(item) <= 0) {
                continue;
            }

            if (item == '(' || item == '<' || item == '{') {
                cur[index] = (char) item;
                stack.offerFirst(item);
                map.put(item, map.get(item) - 1);

                dfs(result, map, index + 1, cur, stack);
                // recover
                stack.pollFirst();
                map.put(item, map.get(item) + 1);
            }

            if (item == ')' || item == '>' || item == '}') {
                if (!stack.isEmpty() && (char) stack.peek() == item) {
                    cur[index] = (char) item;
                    map.put(item, map.get(item) - 1);

                    dfs(result, map, index + 1, cur, stack);
                    // recover
                    map.put(item, map.get(item) + 1);
                }
            }
        }


    }

    public static void main(String[] args) {
        Solution179 s = new Solution179();
        for (String i : s.validParentheses(2, 0, 0)) {
            System.out.println(i);
        }
    }
}
