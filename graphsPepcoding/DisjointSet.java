package graphsPepcoding;

import java.util.Scanner;

public class DisjointSet {
	int[] parent;
	int[] rank;
	int[] size;

	DisjointSet(int n) {
		parent = new int[n + 1];
		rank = new int[n + 1];
		size = new int[n + 1];
	}

	public void makeSet(int n) {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
			size[i] = 1;
		}
	}

	public void union_by_rank(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if (rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
		}
	}

	public void union_by_size(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (size[lx] > size[ly]) {
				parent[ly] = lx;
				size[ly] = size[lx] + size[ly];
			} else {
				parent[lx] = ly;
				size[ly] = size[ly] + size[lx];
			}
		}
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		DisjointSet dsu = new DisjointSet(m);
		dsu.makeSet(m);
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			dsu.union_by_rank(u, v);
		}
		System.out.println("Dsu created Succesfully");
	}

}
