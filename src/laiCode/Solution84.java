public class Solution84 {
    public String reverseWords(String input) {
        // corner cases
        if (input == null || input.length() <= 1) {
            return input;
        }

        // two pointers
        int i = 0;
        char[] array = input.toCharArray();

        // loop replacement
        while (i < input.length()) {
            if (array[i] != ' ') {
                // move j to the end of the word
                int j = i;
                while (j+1 != input.length() && array[j+1] != ' ') {
                    j++;
                }

                // record end
                int endInd = j;

                // swap(i, j)
                while (i < j) {
                    swap(array, i++, j--);
                }

                // increase i to the end of word
                //i == input.length() - 1 ? i+1 : endInd;
                i = endInd + 1;

            } else {
                i++;
            }
        }

        // reverse all
        int x = 0;
        int y = input.length() - 1;
        while (x < y) {
            swap(array, x++, y--);
        }

        return new String(array);

    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
//        String test = "AC B C D";
//        Solution84 s = new Solution84();
//        String output = s.reverseWords(test);
//        System.out.println(output);
//        double a = 0.75;
//        float b = 0.75f;
        System.out.println((int )'b' - 'a');

    }
}
