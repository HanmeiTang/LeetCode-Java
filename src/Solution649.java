// TODO: if target is empty

public class Solution649 {
    public String replace(String input, String source, String target) {
        if (input.equals("")) {
            return "";
        }

        // case 1: if source is longer or equal
        if (source.length() >= target.length()) {
            return replace1(input.toCharArray(), source, target);
        } else {
            // case 2: if source is shorter
            return replace2(input.toCharArray(), source, target);
        }

    }

    // case 1: if source is longer or equal
    public String replace1(char[] input, String pattern, String replacement) {
        // find the pattern first letter
        // if matches to the end, replace it from the beginning and
        int slow = 0;
        int fast = 0;

        // loop looking foward to find pattern
        while (fast <= input.length) {
            boolean match = true;
            if (fast + pattern.length() <= input.length) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (input[fast + j] != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            } else {
                match = false;
            }


            if (match) {
                // copy replacement to [slow] slow++
                for (int i = 0; i < replacement.length(); i++) {
                    input[slow + i] = replacement.charAt(i);
                }
                slow += replacement.length();
                fast += pattern.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    // case 2: if source is shorter
    // 1. find occurrence
    // 2. increase the length by #occurance
    // 3. copy from the right side
    public String replace2(char[] input, String source, String target) {
        return "";
    }
}
