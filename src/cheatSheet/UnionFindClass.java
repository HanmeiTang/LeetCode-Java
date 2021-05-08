package cheatSheet;

import java.util.*;
/*
def UNF:

	def __init__(self, n):
		self.parent = [ i for i in range(n)]
		#  [ 0,1,2,3,4,5,6]
		self.num_group = n

	def find(self, x):
		if parent[x]!=x:
            parent[x]=self.find(parent[x])
        return parent[x]

	def union(self,x,y):
		x_parent = self.find(x)
		y_parent = self.find(y)
		if x_parent != y_parent:
			self.num_group-=1
			parent[	x_parent]=y_parent
                # or parent[ y_parent]=x_parent
                return True
        return False

 */

// This is a demo of Union Find Algo using a package class
public class UnionFindClass {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(edge[0], n);
            n = Math.max(edge[1], n);
        }
        UR ur = new UR(n + 1);
        for (int[] edge : edges) {
            if (!ur.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError("No Redundant edges!");
    }

    public static void main(String[] args) {
        UnionFindClass ufc = new UnionFindClass();
        int[] result = ufc.findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}});
        System.out.println(Arrays.toString(result));

    }
}

class UR {
    int[] parents;
    int[] rank;

    public UR(int size) {
        this.parents = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) parents[i] = i;
    }

    public int find(int x) {
        if (x != parents[x]) parents[x] = find(parents[x]);
        return parents[x];
    }

    /*
    updating node parents
    */
    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp == yp) {
            return false;
        } else if (rank[xp] < rank[yp]) {
            parents[xp] = yp;
        } else if (rank[xp] > rank[yp]) {
            parents[yp] = xp;
        } else {
            parents[yp] = xp;
            rank[xp]++;
        }
//        System.out.printf("%d, %d\n", x, y);
//        System.out.println(Arrays.toString(parents));
//        System.out.println(Arrays.toString(rank));
//        System.out.println();
        return true;
    }
}
