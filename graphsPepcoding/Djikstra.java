package graphsPepcoding;

import java.util.*;
//Node class defined outside. Contains value and weight.
public class Djikstra {

	public static void shortestPathInUnitWeightUndirectedGraph(ArrayList<ArrayList<Integer>> adj, int n, int src) {
		// We would use BFS
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		distance[src] = 0;
		while (!q.isEmpty()) {
			int currnode = q.remove();
			for (Integer i : adj.get(currnode)) {
				if ((distance[currnode] + 1 < distance[i])) {
					distance[i] = distance[currnode] + 1;
					q.add(i);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print("Shortest distance for node " + i + " is " + distance[i]
					+ " using shortestPathInUnitWeightUndirectedGraph algo");
			System.out.println();
		}
	}

	public static void DjikstraAlgorithm(ArrayList<ArrayList<Node>> adj, int n, int src) {

		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(src, 0));
		distance[src] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.remove();
			for (Node i : adj.get(node.value)) {
				if (distance[node.value] + i.weight < distance[i.value]) {
					distance[i.value] = distance[node.value] + i.weight;
					pq.add(new Node(i.value, distance[i.value]));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print("Shortest distance for node " + i + " is " + distance[i] + " using Djikstra algo");
			System.out.println();
		}

	}

	public static void main(String args[]) {
		int n = 5;
		int n1 = 9;
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());
		for (int i = 0; i < n1; i++)
			adj1.add(new ArrayList<Integer>());

		adj1.get(0).add(1);
		adj1.get(0).add(3);

		adj1.get(1).add(3);
		adj1.get(1).add(0);
		adj1.get(1).add(2);

		adj1.get(2).add(1);
		adj1.get(2).add(6);

		adj1.get(3).add(1);
		adj1.get(3).add(4);
		adj1.get(3).add(0);

		adj1.get(4).add(3);
		adj1.get(4).add(5);

		adj1.get(5).add(4);
		adj1.get(5).add(6);

		adj1.get(6).add(2);
		adj1.get(6).add(7);
		adj1.get(6).add(5);
		adj1.get(6).add(8);

		adj1.get(7).add(8);
		adj1.get(7).add(6);

		adj1.get(8).add(6);
		adj1.get(8).add(7);

		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));

		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));

		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));

		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));

		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));

		shortestPathInUnitWeightUndirectedGraph(adj1, n1, 0);
		DjikstraAlgorithm(adj, n, 0);

	}
}
