package exams;

public class MidTermMinPalindrome {
    public int minPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        if (input.length() == 1) {
            return 0;
        }

        // dp[i] = min cuts ends at this index
        int[] dp = new int[input.length()];
        dp[0] = 0;

        // substring ending at index i
        for (int i = 1; i < input.length(); i++) {
            // check all
            String sub = input.substring(0, i + 1);
            if (isPalindrome(sub)) {
                dp[i] = 0;
                continue;
            }

            // check different cuts
            // j is left part length
            int minCut = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                int left = dp[j - 1];
                int right = isPalindrome(input.substring(j, i + 1)) ? 0 : i - j;
                minCut = Math.min(left + right + 1, minCut);
            }
            dp[i] = minCut;
        }

        return dp[input.length() - 1];
    }


    // determine if a string is a Palindrome
    // O(length)
    private boolean isPalindrome(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            if (input.charAt(i++) != input.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MidTermMinPalindrome mid = new MidTermMinPalindrome();
        System.out.println(mid.minPalindrome("abab"));
        System.out.println("33".repeat(3));
    }
}


// Analysis, N is the length of input string
// TC
// for each element in dp table, O(N^2)
// 1 * 1^2 + 2 * 2^2 + n * n^3 ~ O(N^4)
//
// SC
// N + N = O(N)
