import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution63 {
    private char[] charSet;

    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        // corner cases
        if (set == null) {
            return result;
        }

        if (set.length() == 0) {
            result.add("");
            return result;
        }

        // create charcter set and sort
        charSet = set.toCharArray();
        Arrays.sort(charSet); // O(N*LogN)

        // DFS with skip
        dfs(result, 0, cur);
        return result;
    }

    private void dfs(List<String> result, int index, StringBuilder cur) {
        // base case
        if (index >= charSet.length) {
            result.add(cur.toString());
            return;
        }

        // add
        cur.append(charSet[index]);
        dfs(result, index + 1, cur);
        cur.deleteCharAt(cur.length() - 1);

        // add nothing
        char curChar = charSet[index];
        while (index < charSet.length && charSet[index] == curChar) {
            index++;
        }
        dfs(result, index, cur);
    }

    public static void main(String[] args) {
        Solution63 s = new Solution63();
        int i = 0;
        for (String result: s.subSets("abc")) {
            System.out.print(i++);
            System.out.println(result);
        }

        char[] d = new char[3];
        System.out.println(d.length);
    }
}