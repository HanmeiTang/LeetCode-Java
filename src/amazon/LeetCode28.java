package amazon;

class LeetCode28 {
    public static int strStr(String haystack, String needle) {
        // corner cases
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.length() == 0) return 0;


        // scan from begin
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = false;
            System.out.println(needle.length());
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if (j == needle.length() - 1) match = true;
            }
            if (match) return i;
        }

        // return
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode28.strStr("mississippi", "mississippi"));
    }
}