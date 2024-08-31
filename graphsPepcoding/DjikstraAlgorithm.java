package graphsPepcoding;
//Graph is undirected weighted. Node is added in graph. Pair is added in priorityQueue. Node Toh graph bnane ke liye bnate h, usme nodes lagane ke liye.
//Pair humlog prirotiy Queue mei daalne ke liye bnate hai.
import java.util.*;
public class DjikstraAlgorithm {
	static class Node{
		int val;
		int wt;
		Node(int val, int wt){this.val = val; this.wt = wt;}
	}
	
	static class Pair implements Comparable<Pair>{
		int dist;
		int val;
		Pair(int dist, int val){this.dist = dist; this.val = val;} // It should be dist so we can differentiate with wt and dist.
		public int compareTo(Pair p) {
			return this.dist - p.dist;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] arr = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		 int n = 7;
		 int src = 0;
		 int dest = n-1;
		 int[] minDistWithEachNode = djikstra(n,src,dest,arr);
		 djikstraUsingVisited(n,src,dest,arr);
		 for(int i = 0 ; i < minDistWithEachNode.length ;i++) {
			 System.out.println("Min distance of src "+src+" with node "+i+" is "+minDistWithEachNode[i]);
		 }
	}
	
	// Djikstra Using Dist Array
	public static int[] djikstra(int n ,int src, int dest , int[][] edges) {
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
		for(int[] row: edges) {
			int u = row[0];
			int v = row[1];
			int wt = row[2];
			graph.get(u).add(new Node(v,wt));
			graph.get(v).add(new Node(u,wt));
		}
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		PriorityQueue<Pair> pq  = new PriorityQueue<>();
		pq.add(new Pair(0,src));
		while(!pq.isEmpty()) {
			Pair p = pq.remove();
			int distance = p.dist;
			int nodeValue = p.val;
			for(Node nbr : graph.get(nodeValue)) {
				if((dist[nbr.val]> distance + nbr.wt) && distance != Integer.MAX_VALUE) {
					dist[nbr.val] = distance + nbr.wt;
					pq.add(new Pair(dist[nbr.val],nbr.val));
				}
			}
		}
		return dist;
	}
	// Djikstra Without Dist array and only using visited array.
	public static void djikstraUsingVisited(int n , int src, int dest, int[][] edges) {
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
		for(int[] row: edges) {
			int u = row[0];
			int v = row[1];
			int wt = row[2];
			graph.get(u).add(new Node(v,wt));
			graph.get(v).add(new Node(u,wt));
		}
		
		boolean[] visited = new boolean[n];
		
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, src));
		
		while(pq.size() > 0) {
			Pair rem = pq.remove();
			if(visited[rem.val] == true) {
				continue;
			}
			
			// Here rem.dist will tell us the shortest path to rem.nodeValue. We can do whatever we want with it.
			if(rem.val == dest) {
				System.out.println(rem.dist);
				// return rem.dist as this will be the  minimum distance to dest from src. Or Do something with it.
			}
			
			visited[rem.val] = true;
			
			for(Node nbr : graph.get(rem.val)) {
				if(visited[nbr.val] == false) {
					pq.add(new Pair(rem.dist + nbr.wt, nbr.val));
				}
			}
			
		}
	}
	
	public static int[] djikstraForDAG(int n, int src, int dest, int[][] edges) {
		// There is no use of dest for now.
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
		for(int[] row: edges) {
			int u = row[0];
			int v = row[1];
			int wt = row[2];
			graph.get(u).add(new Node(v,wt));
		}
		int[] dist = new int[n];
		boolean[] vis = new boolean[n]; // Required for topo sort;
		Stack<Integer> stack = new Stack<>(); // Stack Cannot store node. Because Node have NODE_WT that need a respective parent.
		for (int i = 0; i < n; i++) {
		      if (vis[i] == false) {
		        topoSort(i, graph, stack, vis);
		      }
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		while(!stack.isEmpty()) {
			Integer rem  = stack.pop();
			for(Node nbr : graph.get(rem)) {	
				if((dist[nbr.val] > dist[rem] + nbr.wt) && dist[rem] != Integer.MAX_VALUE) {
					// This second check is added because since toposort disturbs the ordering , 
					//it is possible we pop the node whose distance still needs to be calculated.
					// In earlier cases we used to visit parent then its childs.(From Queue / PriorityQueue)
					// Here we topo sorted so ordering in the stack got changed hence we dont know if a node is removed then next nodes are its child or not.
					dist[nbr.val] = dist[rem] + nbr.wt;
				}
			}
		}
		
		return dist;
	}
	
	public static void topoSort(int curr, List<List<Node>> graph, Stack<Integer> stack, boolean[] visited) {
		if(visited[curr]) return;
		visited[curr] = true;
		for(Node nbr : graph.get(curr)) {
			if(visited[nbr.val] == false) {
				topoSort(nbr.val, graph, stack, visited);
			}
		}
		stack.add(curr);
	}


	

}

//Time complexity for djikstraForDAG is O( N + M ) where N is no of nodes and m is no of edges

// Time complexity for djikstraWithDist is O(V+E)logV

// Time complexity for djikstraUsingVisited is 


///////  IN GRAPH NODE, NODE_WT DENOTES weight OF EDGE BETWEEN THE RESPECTIVE INDEX(PARENT) AND NODE_VALUE. 
////// IN PRIORITY QUEUE PAIR, PAIR_WT DENOTES THE SHORTEST DISTANCE ENCOUNTERED FOR PAIR. PAIR_VALUE DENOTES THE VALUE WE ARE TALKING ABOUT.

//Therefore three simple steps for djikstra ( When doing it with Dist array):
//	1) Create node{value,wt} , pair{dist,nodeValue}, graph, distance array , priorityQueue<Pair>
//	2) Add pair for src node and Start Iteration. Remove from top and iterate neighbours of the top. 
//  3)If distance to reach top + wt of nbr is less than already marked distance of nbr, then update the distance
//      and add new Pair of {newDist,nbrValue} to priorityQueue.
//      
//      return distance array pq once its empty.


