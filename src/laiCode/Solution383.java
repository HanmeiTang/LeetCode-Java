package laiCode;

import java.util.*;

public class Solution383 {
    public String reverseWords(String input) {
        if (input == null) return input;
        input = input.trim();

        if (input.length() <= 1) return input;

        char[] array = input.toCharArray();

        int i = 0;
        while (i < array.length) {
            if (array[i] == ' ') {
                i++;
                continue;
            }

            int j = i;
            while (j + 1 < input.length() && array[j + 1] != ' ') j++;

            reverse(array, i, j);
            i = j + 1;
        }

        reverse(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return new String(array);
    }

    private void reverse(char[] input, int i, int j) {
        System.out.printf("%d, %d\n", i, j);
        while (i < j) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution383 s = new Solution383();
        String sput = s.reverseWords(" an  apple  ");

    }
}
