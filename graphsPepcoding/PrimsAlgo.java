package graphsPepcoding;

import java.util.*;

//Node class contains value and weight.
public class PrimsAlgo {

	static class Node implements Comparable<Node> {
		int value;
		int weight;

		public Node(int value, int weight) {
			super();
			this.value = value;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String args[]) {

		int n = 5;
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());

		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));

		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));

		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));

		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));

		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));

		primsAlgoforMSTOptimized(adj, n);
	}

	public static void primsAlgoforMSTOptimized(ArrayList<ArrayList<Node>> adj, int n) {
		int[] key = new int[n];
		boolean[] mst = new boolean[n];
		int[] parent = new int[n];
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(mst, false);
		Arrays.fill(parent, -1);
		key[0] = 0;
		parent[0] = -1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		for (int i = 0; i < n - 1; i++) { // since n-1 edges in mst
			int min = Integer.MAX_VALUE;
			int u = 0;
			u = pq.remove().value;
			mst[u] = true;
			for (Node nbr : adj.get(u)) {
				if (!mst[nbr.value] && nbr.weight < key[nbr.value]) {
					key[nbr.value] = nbr.weight;
					parent[nbr.value] = u;
					pq.add(new Node(nbr.value, nbr.weight));
				}
			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " -> " + i);
		}

	}

}
