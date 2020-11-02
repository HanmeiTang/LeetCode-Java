package exams;

import java.util.*;

class FinalRecruitingEventSchedules1 {
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
        char[] cur = new char[2 * array.length - 1];
        for (int i = 0; i < input.length(); i++) {
            cur[2 * i] = input.charAt(i);
        }
        dfs(array, 0, cur, result);

        // return
        return result;
    }

    private void dfs(char[] array, int index, char[] cur, List<String> result) {
        // base case
        if (2 * index + 1 >= cur.length) {
            result.add(new String(cur));
            return;
        }

        // recursive rule
        // add
        cur[2 * index + 1] = 'x';
        dfs(array, index + 1, cur, result);
        cur[2 * index + 1] = (char) 0;

        // not add
        dfs(array, index + 1, cur, result);
    }

    public static void main(String[] args) {
        FinalRecruitingEventSchedules1 fes = new FinalRecruitingEventSchedules1();
        for (String i : fes.RecruitingEventSchedule("ABC")) {
            System.out.println(i);
        }
    }
}


// Analysis, N is the length of input
// TC: O(2^N * N)
// SC: O(N)

// okay, should use Character[] instead













