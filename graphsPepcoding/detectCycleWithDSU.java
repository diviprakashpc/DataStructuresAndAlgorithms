package graphsPepcoding;

import java.util.*;

//GFG verified
class detectCycleWithDSU {
	// Function to detect cycle using DSU in an undirected graph.
	static int[] parent;
	static int[] rank;

	public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		parent = new int[V];
		rank = new int[V];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		for (int u = 0; u < V; u++) {
			for (int v : adj.get(u)) {
				if (parent[u] == parent[v] && u < v)
					return 1;
				else
					union(u, v);
			}
		}
		return 0;
	}

	public int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}

	public void union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (rank[pu] < rank[pv]) {
			parent[pu] = pv;
		} else if (rank[pu] > rank[pv]) {
			parent[pv] = pu;
		} else {
			parent[pu] = pv;
			rank[pv]++;
		}
	}

}

/*
 * Edge ki dono vertices ke parent find kro. Agar same aa jaate hai toh iska
 * mtlb ye hai ki dono vertices kisi na kisi same node se connected hai . Aur ab
 * in dono ke beech edge add krne se ofcourse cycle create ho jaegi
 */

/*
 * Initially toh sabke representative(or leader) -1 rhega. Wo khudko represent
 * krenge. Pr iteration krke jaise jaise hum edges add krenge (DSU mei, graph
 * mei nahi. Graph toh pehle se bna hua mila hai. Aur, DSU mei add krna mtlb
 * parent array mei respective change krna) waise waise check krte jaenge ki
 * cycle ban rahi ya nhi.
 */
