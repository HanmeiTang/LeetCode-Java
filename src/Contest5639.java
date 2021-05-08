import java.util.*;

class Contest5639 {
    int[] jobs;
    int k;
    int left;
    int right;

    public int minimumTimeRequired(int[] jobs, int k) {
        // sort and sum
        Arrays.sort(jobs);
        this.jobs = jobs;
        this.k = k;

        int sum = 0;
        for (int j : jobs) sum += j;

        left = sum / k;
        right = 10000000;

        // binary search
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(mid)) right = mid;
            else left = mid;
            System.out.printf("%d, %d\n", left, right, mid);
        }

        // return
        System.out.println(left);
        if (canFinish(left)) return left;
        else return right;
    }

    private boolean canFinish(int t) {
        boolean[] visited = new boolean[jobs.length];
        Set<Integer> remain = new HashSet<>();
        for (int i = 0; i < visited.length; i++) remain.add(i);

        for (int i = 1; i < k; i++) {
            if (remain.size() == 0) return true;
            int count = 0;

            while (count < t) {
                if (remain.size() == 0) return true;
                for (int ind = jobs.length - 1; ind >= 0; ind--) {
                    if (!visited[ind] && count + jobs[ind] < t) {
                        count += jobs[ind];
                        visited[ind] = true;
                        remain.remove(ind);
                    }
                }
            }
        }

        if (remain.size() > 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Contest5639 c = new Contest5639();
        c.minimumTimeRequired(new int[]{3, 2, 3}, 3);
    }
}
