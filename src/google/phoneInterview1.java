package google;

import java.util.*;

public class phoneInterview1 {
}

// questions:
// introduce yourself
// 1. what is a static method in java
// 2. what is override and overloading
// 3. What is a stack?
//  - you mean logical structure or physical structure?
//  what are the common operations using a stack?
//  - push/pop/peek/size

//    Given a digit string, return all possible letter combinations that the number could represent.
//        A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//        2-> 'abc'
//        3-> 'def'
//        4-> 'ghi'
//        5-> 'jkl'
//        6-> 'mno'
//        7-> 'pqrs'
//        8-> 'tuv'
//        9-> 'wxyz'
//
//        Input:Digit string "35"
//        Output: ["dj", "dk", "dl", "ej", "ek", "el", "fj", "fk", "fl"].
//        Note:
//        Although the above answer is in lexicographical order, your answer could be in any order you want.
// duplicates
// empty -> return []
// lower case
// assume 2-9
// super long
// input: all number
  /*

  123 , n = number of digits input 3^n
  a    b c
  /|\
  d e f

  */


class GetString {
    public List<String> getLetterComb(String digits) {
        // corner cases
        List<String> result = new ArrayList<>();
        if (digits == null) return result;

        digits.replaceAll("[01]", ""); // double check later
        if (digits.length() == 0) return result;

        // parse digits
        int[] nums = new int[digits.length()]; // "23"
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (digits.charAt(i) - '0'); // [2, 3]
        }

        // map construction
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        // dfs recursion
        dfs(new StringBuilder(), nums, 0, result, map);

        // return result
        return result;
    }

    // determine ind th element in the final string
    private void dfs(StringBuilder sb, int[] nums, int ind, List<String> result, Map<Integer, char[]> map) {
        // base case
        if (ind == nums.length) { // 0, 2
            result.add(sb.toString());
            return;
        }

        // recursive rule
        for (char c : map.get(nums[ind])) { // a, b, c
            sb.append(c); // "a"

            dfs(sb, nums, ind + 1, result, map); // "b" then bd, be, bf

            sb.deleteCharAt(sb.length() - 1); // ""
        }
    }
}

//    Reverse digits of an integer.
//        Example1: x = 123, return 321
//        Example2: x = -123, return -321
//        Example3: x = 320, return 23

// reverse an int, ie 123 -> 321 or -123 -> -321
/*
Solution 1
if negative, boolean isNegative = true;
long -> int[]
2 pointer swap
find the real beginning, skip all zeros
combine the sign, and return

Solution 2
take off the sign
convert it to a string.valueOf(input integer)
swap all char using two pointers, char[] --> string -->Integer.valueOf(string) --> combine the sign

// may cause error if the input is super long
*/

class ReverseInteger {
    public int getReversed(int input) {
        int sign = input < 0 ? -1 : 1;
        input /= sign;

        String inputStr = String.valueOf(input);
        char[] array = inputStr.toCharArray();
        int i = 0;
        int j = inputStr.length() - 1;

        // swap
        while (i < j) {
            swap(array, i++, j--);
        }

        // return
        return Integer.valueOf(new String(array)) * sign;

    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
