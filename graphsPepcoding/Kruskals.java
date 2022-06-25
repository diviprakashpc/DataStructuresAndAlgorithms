package graphsPepcoding;

import java.util.*;

public class Kruskals {

	void KruskalsAlgo(ArrayList<Edge> adj, int n) {
		Collections.sort(adj, new SortComparator());
		int[] parent = new int[n];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		int costMst = 0;
		ArrayList<Edge> mst = new ArrayList<>();
		for (Edge edge : adj) {
			int src = edge.getU();
			int dest = edge.getV();
			int weight = edge.getWeight();
			if (find(src, parent) != find(dest, parent)) {
				mst.add(edge);
				costMst += weight;
				union(src, dest, parent, rank);
			}
		}

		System.out.println("Cost of mst is " + costMst);
		for (Edge edge : mst) {
			System.out.println(edge.getU() + " -> " + edge.getV());
		}

	}

	private int find(int u, int parent[]) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u], parent);
	}

	private void union(int u, int v, int parent[], int rank[]) {
		u = find(u, parent);
		v = find(v, parent);
		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}

	class SortComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge node1, Edge node2) {
			if (node1.getWeight() < node2.getWeight())
				return -1;
			if (node1.getWeight() > node2.getWeight())
				return 1;
			return 0;

		}
	}

	static class Edge {
		private int u;
		private int v;
		private int weight;

		Edge(int _u, int _v, int _w) {
			u = _u;
			v = _v;
			weight = _w;
		}

		Edge() {
		}

		int getV() {
			return v;
		}

		int getU() {
			return u;
		}

		int getWeight() {
			return weight;
		}
	}

	public static void main(String args[]) {
		int n = 5;
		ArrayList<Edge> adj = new ArrayList<Edge>();

		adj.add(new Edge(0, 1, 2));
		adj.add(new Edge(0, 3, 6));
		adj.add(new Edge(1, 3, 8));
		adj.add(new Edge(1, 2, 3));
		adj.add(new Edge(1, 4, 5));
		adj.add(new Edge(2, 4, 7));

		Kruskals obj = new Kruskals();
		obj.KruskalsAlgo(adj, n);

	}

}
