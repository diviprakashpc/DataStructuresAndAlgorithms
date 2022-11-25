package graphsPepcoding;
import java.util.*;
public class NumberOfProvinces {

	public int findNumberOfProvinces(int[][] c) {
		DisjointSet ds = new DisjointSet(c.length);
		ds.makeSet(c.length);
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if (c[i][j] == 1) {
					ds.union_by_size(i, j);
				}
			}
		}
		int n_o_p = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < c.length; i++) {
			int leader = ds.find(i);
			set.add(leader);
		}
		return set.size();
		
	}
	
//	There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//
//	A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//
//	You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//
//	Return the total number of provinces.
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Edge matrix is given 
		int[][] edges = {{1,1,0},{1,1,0},{0,0,1}};

	}


	static class DisjointSet {
		int[] parent;
		int[] size;

		DisjointSet(int n) {
			parent = new int[n + 1];
			size = new int[n + 1];
		}

		void makeSet(int n) {
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		int find(int x) {
			if (x == parent[x]) {
				return x;
			}

			int found = find(parent[x]);
			parent[x] = found;
			return found;
		}

		void union_by_size(int x, int y) {
			int lx = find(x);
			int ly = find(y);
			if (lx == ly)
				return;
			if (size[lx] > size[ly]) {
				parent[ly] = lx;
				size[ly] += size[lx];
			} else {
				parent[lx] = ly;
				size[lx] += size[ly];
			}
		}
	}

}
