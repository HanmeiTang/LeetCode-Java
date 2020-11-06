package amazon;

// https://leetcode.com/discuss/interview-question/877624/
// youtube solution: https://www.youtube.com/watch?v=uykXhWaTCBs&feature=youtu.be

import java.util.*;

public class SubstringsSizeK {
    public List<String> distinctGame(String input, int num) {
        // corner cases
        if (num <= 1 || input == null || input.length() <= 1) {
            return null;
        }

        if (num > input.length()) {
            return new ArrayList<String>();
        }

        char[] array = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        // add first substring to map
        for (int i = 0; i < num; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        if (map.size() == num - 1) {
            result.add(new String(array, 0, num));
        }

        // sliding window with length = num
        for (int i = 1; i <= input.length() - num; i++) {
            // remove previous character
            char preChar = array[i - 1];
            if (map.get(preChar) == 1) {
                map.remove(preChar);
            } else {
                map.put(preChar, map.get(preChar) - 1);
            }

            // add new character
            char newChar = array[i + num - 1];
            map.put(newChar, map.getOrDefault(newChar, 0) + 1);

            // check if substring should be recorded
            if (map.size() == num - 1) {
                result.add(new String(array, i, num));
            }
        }

        // return
        return result;
    }

    public static void main(String[] args) {
        SubstringsSizeK s = new SubstringsSizeK();
        List<String> result = s.distinctGame("wawaglknagagwunagkwkwagl", 4);
        System.out.println(result);
    }
}


// Demo
// num = 5
// input.length() = 9
// HashMap<Character, Integer>
// i________  democ subString = array[i, i + 5)
//   i________  emocr == remove [i-1], add [i+4]
//         i________  emocr == remove [i-1], add [i+4]
// 0 1 2 3 4 5 6 7 8
// d e m o c r a c y

// Analysis
// TC: O(input.length())
// SC: O(num + input.length()) // hashmap + char[]