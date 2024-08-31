package graphsPepcoding;
//Graph is undirected weighted. Node is added in graph. Pair is added in priorityQueue. Node Toh graph bnane ke liye bnate h, usme nodes lagane ke liye.
//Pair humlog prirotiy Queue mei daalne ke liye bnate hai.
import java.util.*;
public class DjikstraAlgorithm {
	static class Node{
		int value;
		int wt;
		Node(int value, int wt){this.value = value; this.wt = wt;}
	}
	
	static class Pair implements Comparable<Pair>{
		int dist;
		int nodeValue;
		Pair(int dist, int nodeValue){this.dist = dist; this.nodeValue = nodeValue;}
		public int compareTo(Pair p) {return this.dist - p.dist;}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] arr = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		 int n = 7;
		 int src = 0;
		 int dest = n-1;
		 int[] minDistWithEachNode = djikstra(n,src,dest,arr);
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
			int nodeValue = p.nodeValue;
			for(Node nbr : graph.get(nodeValue)) {
				if(dist[nbr.value]> distance + nbr.wt) {
					dist[nbr.value] = distance + nbr.wt;
					pq.add(new Pair(dist[nbr.value],nbr.value));
				}
			}
		}
		return dist;
	}
	// Djikstra Without Dist array and only using visited array.
	public void djikstraUsingVisited(int n , int src, int dest, int[][] edges) {
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
		
		visited[src] = true;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, src));
		
		while(pq.size() > 0) {
			Pair rem = pq.remove();
			if(visited[rem.nodeValue] == true) {
				continue;
			}
			
			// Here rem.dist will tell us the shortest path to rem.nodeValue. We can do whatever we want with it.
			if(rem.nodeValue == dest) {
				// return rem.dist as this will be the  minimum distance to dest from src. Or Do something with it.
			}
			
			visited[rem.nodeValue] = true;
			
			for(Node nbr : graph.get(rem.nodeValue)) {
				if(visited[nbr.value] == false) {
					pq.add(new Pair(rem.dist + nbr.wt, nbr.value));
				}
			}
			
		}
	}

}


///////  IN GRAPH NODE, NODE_WT DENOTES weight OF EDGE BETWEEN THE RESPECTIVE INDEX(PARENT) AND NODE_VALUE. 
////// IN PRIORITY QUEUE PAIR, PAIR_WT DENOTES THE SHORTEST DISTANCE ENCOUNTERED FOR PAIR. PAIR_VALUE DENOTES THE VALUE WE ARE TALKING ABOUT.

//Therefore three simple steps for djikstra ( When doing it with Dist array):
//	1) Create node{value,wt} , pair{dist,nodeValue}, graph, distance array , priorityQueue<Pair>
//	2) Add pair for src node and Start Iteration. Remove from top and iterate neighbours of the top. 
//  3)If distance to reach top + wt of nbr is less than already marked distance of nbr, then update the distance
//      and add new Pair of {newDist,nbrValue} to priorityQueue.
//      
//      return distance array pq once its empty.


