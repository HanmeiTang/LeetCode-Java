package amazon;

import java.util.*;

public class FiveStarSeller {
    public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) {
        // corner cases

        // get cur rate
        double curRate = 0.0;
        int count = 0; // #review needed
        for (List<Integer> l : productRatings) {
            curRate += (l.get(0) + 0.0) / l.get(1);
        }
        curRate = curRate / productRatings.size() * 100;

        // construct heap with size N, without 100% rate
        Queue<Rate> maxHeap = new PriorityQueue<>(productRatings.size(), new Comparator<Rate>() {
            @Override
            public int compare(Rate o1, Rate o2) {
                double diff1 = calRateDiff(o1.fiveStar, o1.allStar);
                double diff2 = calRateDiff(o2.fiveStar, o2.allStar);

                if (diff1 == diff2) {
                    return 0;
                }
                return diff1 > diff2 ? -1 : 1;
            }
        });

        // initialization
        for (int i = 0; i < productRatings.size(); i++) {
            maxHeap.offer(new Rate(i, productRatings.get(i).get(0), productRatings.get(i).get(1)));
        }

        // loop until the desired rate achieved
        while (curRate < ratingsThreshold) {
            Rate cur = maxHeap.poll();
            curRate += calRateDiff(cur.fiveStar, cur.allStar) / productRatings.size() * 100;
            cur.fiveStar++;
            cur.allStar++;
            maxHeap.offer(cur);
            count++;
        }

        // return
        return count;
    }

    // to avoid divided by zero...
    private static double calRate(int fiveStar, int allStar) {
        if (allStar == 0) {
            return 0.0;
        }
        return fiveStar / (allStar + 0.0);
    }

    // difference if one more 5 star review added
    private static double calRateDiff(int fiveStar, int allStar) {
        return calRate(fiveStar + 1, allStar + 1) - calRate(fiveStar, allStar);
    }

    public static void main(String[] args) {


        List<List<Integer>> ratings = new ArrayList() {
            {
                add(Arrays.asList(4, 4));
                add(Arrays.asList(1, 2));
                add(Arrays.asList(3, 6));
            }
        };
        int threshold = 77;

        int result = FiveStarSeller.fiveStarReviews(ratings, threshold);
        System.out.println(result);
    }
}

class Rate {
    int ind;
    int fiveStar;
    int allStar;

    public Rate(int ind, int fiveStar, int allStart) {
        this.ind = ind;
        this.fiveStar = fiveStar;
        this.allStar = allStart;
    }
}


// Analysis
// TC: O(N + X logN), X is the operation number until
// SC: O(N)