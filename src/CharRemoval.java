public class CharRemoval {
    public static void removalChar(StringBuilder input) {
        int l = input.length();
//        for (int i = 0; i < l; i++) {
        for (int i = l - 1; i >= 0; i--) {
            if (input.charAt(i) == 'u' || input.charAt(i) == 'n') {
                input.deleteCharAt(i);
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("stuuudent");
        CharRemoval.removalChar(s);
        System.out.println(s);
    }
}
