package exams;


import java.util.ArrayList;
import java.util.List;

class MidTermConc {
    private String leftIf = "if{\n";
    private String nl = "\n"; // also inner block
    private String rightIf = "}\n";
    private String ind = "\t";

    public String conc(int n) {
        if (n <= 0) {
            return null;
        }

        List<String> result = new ArrayList<>(); // combined strings
        List<String> cur = new ArrayList<>(2 * n);
        conc(0, 0, n, cur, result);

        return String.join(nl, result);
    }

    private void conc(int left, int right, int n, List<String> cur, List<String> result) {
        if (left == right && left == n) {
            result.add(String.join(nl, cur));
        }

        if (left < n) {
            cur.add(ind.repeat(left - right) + leftIf);
            conc(left + 1, right, n, cur, result);
            cur.remove(cur.size() - 1);
        }

        if (right < left) {
            cur.add(ind.repeat(left-right) + rightIf);
            conc(left, right + 1, n, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        MidTermConc mid = new MidTermConc();
        System.out.println(mid.conc(3));
    }
}


// analysis, N is the input number
// TC: 2^1 + 2^2 + 2^3 + ... 2^2N = 4^N
// SC: 2^(2N) solutions * N