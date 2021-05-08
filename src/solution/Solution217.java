package solution;

import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution217 {
    public int largest(Point[] points) {
        if (points == null || points.length <= 1) return 0;

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.x == b.x) return a.y - b.y;
                else return a.x - b.x;
            }
        });

        List<Point> asc = new ArrayList<>();
        asc.add(points[0]);

        for (int i = 1; i < points.length; i++) {
            Point p = points[i];
            Point last = asc.get(asc.size() - 1);
            if (last.y < p.y) {
                if (last.x < p.x) asc.add(p);
            } else if (last.y > p.y) {
                int j = asc.size() - 1;
                while (j > 0 && p.y < asc.get(j - 1).y) j--;
                if (p.y < asc.get(j).y && (j == 0 || asc.get(j - 1).y < p.y)) asc.set(j, p);
            }
        }

        return asc.size() == 1 ? 0 : asc.size();
    }

    public static void main(String[] args) {
        Solution217 s = new Solution217();

        Point[] list = new Point[9];

        int i = 0;
        list[i++] = new Point(0, 1);
        list[i++] = new Point(1, 3);
        list[i++] = new Point(2, 3);
        list[i++] = new Point(3, 1);
        list[i++] = new Point(3, 3);
        list[i++] = new Point(4, 2);
        list[i++] = new Point(5, 2);
        list[i++] = new Point(5, 5);
        list[i++] = new Point(6, 1);

        int x = s.largest(list);
        System.out.println(x);

    }
}

/*
0, 1, 2, 3, 4, 4, 3





*/