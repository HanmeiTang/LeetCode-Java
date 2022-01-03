package leetCode;


public class LeetCode392Worse {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode392Worse s = new LeetCode392Worse();
        s.isSubsequence("abc", "ahbgdc");
    }
}