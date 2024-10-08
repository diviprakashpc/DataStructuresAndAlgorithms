package graphsPepcoding;

import java.util.*;

public class CycleDetectionInGraph {
	static class Pair {
		int current;
		int parent;

		public Pair(int current, int parent) {
			super();
			this.current = current;
			this.parent = parent;
		}

	}

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
			adj.add(i, new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(0);

		// edge 1---2
		adj.get(1).add(2);
		adj.get(2).add(1);

		// edge 2--3
		adj.get(2).add(3);
		adj.get(3).add(2);

		// edge 3--4
		adj.get(3).add(4);
		adj.get(4).add(3);

		// edge 1--4
		adj.get(1).add(4);
		adj.get(4).add(1);

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				boolean cycleWithBfs = detectCycleWithBFS(adj, i, visited);
				System.out.println(cycleWithBfs + " bfs" + i);
			}
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				boolean cycleWithDFS = detectCycleWithDFS(adj, i, visited, -1);
				System.out.println(cycleWithDFS + " dfs" + i);
			}
		}
		// We need a different input for detectCycleWithDirectedDFS
	}

	public static boolean detectCycleWithBFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, -1));
		visited[src] = true;
		while (q.size() > 0) {
			int size = q.size();
			while (size-- > 0) {
				int current = q.element().current;
				int parent = q.element().parent;
				q.remove();

				for (Integer i : graph.get(current)) {
					if (visited[i] == false) {
						q.add(new Pair(i, current));
						visited[i] = true;
					} else if (parent != i)
						return true;
				}
			}
		}
		return false;
	}
	
	public static boolean detectCycleWithBfsMine(ArrayList<ArrayList<Integer>> graph, int src, int n) {
		// Validated on gfg question Undirected Graph Cycle

		boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,-1});
        while(q.size() > 0){
            int[] rem = q.remove();
            int val = rem[0];
            int par = rem[1];
            if(visited[val] == true){
                return true;  // cycle detected
                // If a already visited node is again visited.
                // Since we are making sure that only unvisited child are added in the queue
                // IF a node is removed from queue that is already visited, it simply means 
                // That it was child of two people both at same level and they both added it.
                // First time it got removed and marked visited, second time cycle got detected with bfs
            }
            visited[val] = true;
        
            for(Integer nbr : graph.get(val)){
            	// Here also already visited node is again visited but this is different.
            	// Here we add those child that are not visited.
                  if(!visited[nbr]) q.add(new int[]{nbr, val});
            }
        }
        
        return false;
	}
	
	public static boolean detectCycleWithDFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited,
			int parent) {

		visited[src] = true;
		for (Integer i : graph.get(src)) {
			if (!visited[i]) {
				if (detectCycleWithDFS(graph, i, visited, src))
					;
				return true;
			} else if (i != parent)
				return true;
		}
		return false;
	}

	public static boolean detectCycleWithDirectedDFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited,
			boolean[] dfsvisited) {

		visited[src] = true;
		dfsvisited[src] = true;
		for (Integer i : graph.get(src)) {
			if (!visited[i]) {
				if (detectCycleWithDirectedDFS(graph, i, visited, dfsvisited))
					return true;
			} else if (dfsvisited[i]) {
				return true;
			}
		}
		dfsvisited[src] = false;
		return false;
	}
}

/*
 * In pepcoding video, sir check if node is already visited after removing it
 * from queue
 */
/*
 * In striver logic , he checked during adding the neighbours. He checked if any
 * already visited node getting added or not except parent node.
 */
/* Below I have written striver logic, and not sumit sir logic */
