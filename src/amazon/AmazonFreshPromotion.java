package amazon;

public class AmazonFreshPromotion {
    public int matchcodeList(String[] shoppingCart, String[][] codeList) {
        // corner cases
        if (codeList == null || shoppingCart == null || shoppingCart.length == 0) {
            return 0;
        }

        if (codeList.length == 0) {
            return 1;
        }

        // index indicating the group index
        int cIndex = 0;

        // iteratively check if the pattern has a match
        for (int i = 0; i < shoppingCart.length; i++) {
            if (cIndex >= codeList.length) {
                return 1;
            }

            if (i + codeList[cIndex].length <= shoppingCart.length) {
                if (matchCode(codeList[cIndex], shoppingCart, i, i + codeList[cIndex].length)) {
                    cIndex++;
                }
            } else {
                return 0;
            }

        }


        return 1;
    }

    // String.equals() plus "anything" match
    // TC: O(length of the word/pattern)
    private boolean matchWord(String word, String pattern) {
        // corner cases
        if (word == null || pattern == null) {
            return false;
        }

        if (pattern.equals("anything")) {
            return true;
        }

        return word.equals(pattern);
    }

    // Check if a range [left, right) matches the given code
    private boolean matchCode(String[] code, String[] words, int left, int right) {
        // corner cases
        if (code == null || words == null) {
            return false;
        }

        if (code.length == 0) {
            return true;
        }

        if (code.length != right - left) {
            return false;
        }

        for (int i = 0; i < right - left; i++) {
            if (!matchWord(words[left + i], code[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AmazonFreshPromotion afp = new AmazonFreshPromotion();
        int output = afp.matchcodeList(
                new String[]{"orange", "apple", "apple", "banana", "orange", "banana"},
                new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}});

        System.out.println(output);
    }
}
