package graphsPepcoding;

import java.util.*;

class TopologicalSort {
	static void findTopoSortDFS(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				findTopoSortDFS(it, vis, adj, st);
			}
		}
		st.push(node); // When dfs call end we push the node in stack.
	}

	static int[] topoSortDFS(int N, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<Integer>();
		int vis[] = new int[N];

		for (int i = 0; i < N; i++) {
			if (vis[i] == 0) {
				findTopoSortDFS(i, vis, adj, st);
			}
		}

		int topo[] = new int[N];
		int ind = 0;
		while (!st.isEmpty()) {
			topo[ind++] = st.pop();
		}
		return topo;
	}

	public static void topoSortBFS(int N, int[] topo, ArrayList<ArrayList<Integer>> adj) {

		int indegree[] = new int[N];

		// finding indegree
		for (int i = 0; i < N; i++) {
			for (Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			// adding nodes to queue with indegree = 0
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		
		int ind = 0;

		while (!q.isEmpty()) {
			Integer node = q.poll();
			topo[ind++] = node;
			
			// getting neighbour nodes of popped node and decreasing their
			// indegree by1
			for (Integer it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}

	}

	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = 6;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			adj.add(arr);
		}

		adj.get(5).add(2);
		adj.get(5).add(0);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(2).add(3);
		adj.get(3).add(1);

		int res[] = topoSortDFS(6, adj);
		int[] topobfs = new int[n];
		topoSortBFS(n, topobfs, adj);

		System.out.println("Toposort DFS of the given graph is:");
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		System.out.println("Toposort BFS of the given graph is:");
		for (int i = 0; i < topobfs.length; i++) {
			System.out.print(topobfs[i] + " ");
		}
	}
}