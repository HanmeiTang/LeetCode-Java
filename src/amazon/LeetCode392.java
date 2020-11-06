package amazon;


public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        int i = 0, j = 0, ctr = 0;

        while (ctr <= i && i < schars.length) {

            while (j < tchars.length)
                if (schars[i] == tchars[j++]) {
                    ctr++;
                    break;
                }
            i++;
        }

        return i == ctr;
    }

    public static void main(String[] args) {
        LeetCode392 s = new LeetCode392();
        s.isSubsequence("abc", "ahbgdc");
    }
}
