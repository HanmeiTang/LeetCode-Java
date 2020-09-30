// Assumptions
// 1. all lower cases?
// 2.

public class Solution292 {
    char[] source;
    char[] abb;

    public boolean match(String input, String pattern) {
        // recursion solution
        // corner cases
        if (input.equals("") && pattern.equals("")) {
            return true;
        } else if (input.equals("") || pattern.equals("")) {
            return false;
        }

        source = input.toCharArray();
        abb = pattern.toCharArray();
        return match(0, 0);
    }

    private boolean match(int sourceInd, int abbInd) {
        // base case
        if (sourceInd == source.length && abbInd == abb.length) {
            return true;
        } else if (source.length - sourceInd < abb.length - abbInd) {
            System.out.println("case 1");
            return false;
        } else if (sourceInd > source.length || abbInd > abb.length) {
            System.out.println("case 2");
            return false;
        }

        // recursion
        // case 1: digit
        if (Character.isDigit(abb[abbInd])) {
            int count = 0;
            while (abbInd + count < abb.length && Character.isDigit(abb[abbInd + count])) {
                count++;
            }

            int num = Integer.valueOf(new String(abb, abbInd, count));
            System.out.println(num);
            if (sourceInd + num <= source.length) {
                return match(sourceInd + num, abbInd + count);
            } else {
                System.out.println("case 3");
                return false;
            }
        } else if (Character.isLetter(abb[abbInd])) {
            if (abb[abbInd] == source[sourceInd]) {
                return match(sourceInd + 1, abbInd + 1);
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution292 s = new Solution292();
        boolean result = s.match("apple", "2p1");
        System.out.println(result);
    }
}
