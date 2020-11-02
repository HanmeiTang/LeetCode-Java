package exams;

import java.util.*;

class FinalRecruitingEventSchedules2 {
    public List<String> RecruitingEventSchedule(String input) {
        // Invalid cases
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }

        // no gap if only one event given
        if (input.length() == 1) {
            result.add(input);
            return result;
        }

        // dfs recursion
        char[] array = input.toCharArray();
        StringBuilder cur = new StringBuilder();
        dfs(array, 0, cur, result);

        // return
        return result;
    }

    private void dfs(char[] array, int index, StringBuilder cur, List<String> result) {
        // base case
        if (index >= array.length - 1) {
            cur.append(array[array.length - 1]);
            result.add(cur.toString());
            cur.deleteCharAt(cur.length() - 1);
            return;
        }

        // recursive rule
        // add
        //cur[2 * index + 1] = 'x';
        cur.append(array[index]);
        cur.append('x');
        dfs(array, index + 1, cur, result);
        cur.deleteCharAt(cur.length() - 1);
        cur.deleteCharAt(cur.length() - 1);

        // not add
        cur.append(array[index]);
        dfs(array, index + 1, cur, result);
        cur.deleteCharAt(cur.length() - 1);
    }

    public static void main(String[] args) {
        FinalRecruitingEventSchedules2 fes = new FinalRecruitingEventSchedules2();
        for (String i : fes.RecruitingEventSchedule("ABC")) {
            System.out.println(i);
        }
    }
}


// Analysis, N is the length of input
// TC: O(2^N * N)
// SC: O(N)











