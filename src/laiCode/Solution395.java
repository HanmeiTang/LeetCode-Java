import java.util.HashSet;
import java.util.Set;

public class Solution395 {
    public String remove(String input, String t) {
        // corner cases
        if (input == "" || t == "") {
            return input;
        }

        // two pointer
        int slow = 0;
        char[] array = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }

        for (int fast = 0; fast < input.length(); fast++) {
            if (set.contains(array[fast])) {
                continue;
            }
            array[slow] = array[fast];
            slow++;
            System.out.println(input.length());
        }

        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        String[] a;







        a = new String[1];



        Solution395 s = new Solution395();
        String output = s.remove("aaaaaa", "bb");
        System.out.println(output);
    }
}
