package exams;

public class FinalInfiniteLoopAroundTable {
    public boolean hasInfiniteLoop(String[] names) {
        // corner cases
        if (names == null || names.length <= 1) {
            return false;
        }

        // dfs
        boolean[] result = new boolean[1];
        dfs(names, 0, result);

        return result[0];
    }

    private void dfs(String[] names, int index, boolean[] result) {
        // base case
        if (result[0]) {
            return;
        } else if (index >= names.length) {
            char last = names[names.length - 1].charAt(names[names.length - 1].length() - 1);
            char first = names[0].charAt(0);
            if (last == first) {
                result[0] = true;
            }
            return;
        }

        // recursion rule
        for (int i = index; i < names.length; i++) {
            swap(names, i, index);

            String preName = names[(index - 1 + names.length) % names.length];
            char last = preName.charAt(preName.length() - 1);
            char first = names[index].charAt(0);
            if (last == first) {
                dfs(names, index + 1, result);
            }

            swap(names, i, index);
        }

    }

    private void swap(String[] names, int a, int b) {
        String temp = names[a];
        names[a] = names[b];
        names[b] = temp;
    }

    public static void main(String[] args) {
        FinalInfiniteLoopAroundTable filat = new FinalInfiniteLoopAroundTable();
        boolean output = filat.hasInfiniteLoop(new String[]{"ALICA", "CHARLES", "ERIC", "SOPHIA"});
        System.out.println(output);
    }
}

// “ALICE”, “CHARLES”, “ERIC”, “SOPHIA”
//     A
//   / | \
//  C  E  S
// / \
// E S
// | |
// SA E
// if there exists one path
// and it forms a loop, then return true

// if exhausted all possibilities, return false;


