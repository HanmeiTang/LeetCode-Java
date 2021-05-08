package google;

import java.util.*;

class LeetCode150 {

    public int evalRPN(String[] tokens) {
        // corner cases
        //if (tokens == null) return 0;

        // pre processing tokens
        List<String> input = new ArrayList<>();
        for (String s : tokens) input.add(s);
        update(input);

        // return
        return Integer.valueOf(input.get(0));
    }

    // left boundary i, right boundary j
    private List<String> update(List<String> input) {
        // base case
        if (input.size() == 1) return input;

        // recursive rule
        // find the pattern
        int ind = 0;
        for (int i = 0; i < input.size() - 2; i++) {
            if (isNum(input.get(i))
                    && isNum(input.get(i + 1))
                    && !isNum(input.get(i + 2))) {
                ind = i;
                break;
            }
        }


        String rep = calculate(input.get(ind), input.get(ind + 1), input.get(ind + 2));
        input.set(ind, rep);
        System.out.println(input);
        System.out.println(ind);
        input.remove(ind + 2);
        input.remove(ind + 1);

        return update(input);
    }

    private boolean isNum(String s) {
        return Character.isDigit(s.charAt(0));
    }

    private String calculate(String a, String b, String op) {
        int one = Integer.valueOf(a);
        int two = Integer.valueOf(b);
        int result = 0;

        if (op.equals("*")) {
            result = one * two;
        } else if (op.equals("/")) {
            result = one / two;
        } else if (op.equals("+")) {
            result = one + two;
        } else {
            result = one - two;
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        LeetCode150 l = new LeetCode150();
        l.evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}

/*
// ignore

num, num, oper


*/