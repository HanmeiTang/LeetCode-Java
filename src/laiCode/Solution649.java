package laiCode;

public class Solution649 {
    public String replace(String input, String source, String target) {
        // corner cases
        if (input == null || input.length() == 0) {
            return input;
        }

        // scan once to identify output length
        char[] array = input.toCharArray();
        int count = 0;
        int i = 0;
        int j = source.length() - 1;
        while (j < input.length()) {
            if (match(array, i, j, source)) {
                count++;
                i = j + 1;
                if (j + source.length() < input.length()) {
                    j += source.length();
                } else {
                    break;
                }
            } else {
                i++;
                j++;
            }
        }

        int outputLength = input.length() - (count * (source.length() - target.length()));
        char[] result = new char[outputLength];

        // replace
        i = input.length() - 1;
        j = outputLength - 1;
        while (j >= 0) {
            //System.out.println(new String(result));
            //System.out.println(i);
            if (i >= source.length() - 1 && match(array, i - source.length() + 1, i, source)) {
                for (int k = target.length() - 1; k >= 0; k--) {
                    //System.out.printf("%s %s\n", k, j);
                    result[j--] = target.charAt(k);
                }
                i -= source.length();
            } else {
                result[j--] = array[i--];
            }
        }

        // return
        return new String(result);
    }


    // helper function
    private boolean match(char[] array, int left, int right, String source) {
        // assume all input are valid
        if ((right - left + 1) != source.length()) {
            return false;
        }

        for (int n = 0; n <= right - left; n++) {
            if (array[left + n] != source.charAt(n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution649 s = new Solution649();
        String a = s.replace("laicode", "code", "offer");
        System.out.println(a);
        System.out.println(s.match(new char[]{'a', 'p', 'p'}, 0, 2, "app"));
    }
}

