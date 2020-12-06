package cheatSheet;

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

import java.util.*;

public class UnionFind {
    public int[] findRedundantConnection(int[][] edges) {
        // corner cases

        // construct the node list
        int n = 0; // number of nodes
        for (int[] edge : edges) {
            n = Math.max(edge[0], n);
            n = Math.max(edge[1], n);
        }

        int[] parents = new int[n];
        int[] num_group = new int[]{n};
        for (int i = 0; i < n; i++) parents[i] = i + 1;

        for (int[] edge : edges) {
            if (!union(edge, parents, num_group)) {
                return edge;
            }
        }

        // return
        return new int[2];

    }

    // private method updating node parents
    // return true if successfully unioned
    private boolean union(int[] edge, int[] parents, int[] num_group) {
        int p1 = find(edge[0], parents);
        int p2 = find(edge[1], parents);

        if (p1 == p2) return false;
        else {
            parents[p1 - 1] = Math.min(p1, p2);
            parents[p2 - 1] = Math.min(p1, p2);
            num_group[0]--;
            return true;
        }

    }

    private int find(int node, int[] parents) {
        if (parents[node - 1] != node) { // this has some parent
            return find(parents[node - 1], parents);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        int[] result = uf.findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}});
        System.out.println(Arrays.toString(result));

    }
}

