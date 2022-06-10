package graphsPepcoding;

import java.util.*;

class Edge {
	int u;
	int v;
	int wt;

	public Edge(int u, int v, int wt) {
		super();
		this.u = u;
		this.v = v;
		this.wt = wt;
	}

}

class BellmanFord {
	static void bellmanFord(ArrayList<Edge> edges, int N, int src) {
		int dist[] = new int[N];
		for (int i = 0; i < N; i++)
			dist[i] = 10000000;

		dist[src] = 0;

		for (int i = 1; i <= N - 1; i++) {
			for (Edge edge : edges) {
				if (dist[edge.u] + edge.wt < dist[edge.v]) {
					dist[edge.v] = dist[edge.u] + edge.wt;
				}
			}
		}

		int fl = 0;
		for (Edge edge : edges) {
			if (dist[edge.u] + edge.wt < dist[edge.v]) {
				fl = 1;
				System.out.println("Negative Cycle");
				break;
			}
		}

		if (fl == 0) {
			for (int i = 0; i < N; i++) {
				System.out.print(dist[i] + " ");
			}
		}
	}

	public static void main(String args[]) {
		int n = 6;
		ArrayList<Edge> adj = new ArrayList<Edge>();

		adj.add(new Edge(3, 2, 6));
		adj.add(new Edge(5, 3, 1));
		adj.add(new Edge(0, 1, 5));
		adj.add(new Edge(1, 5, -3));
		adj.add(new Edge(1, 2, -2));
		adj.add(new Edge(3, 4, -2));
		adj.add(new Edge(2, 4, 3));

		bellmanFord(adj, n, 0);

	}
}
