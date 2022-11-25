package graphsPepcoding;
import java.util.*;
public class printShortestPathUsingDjikstraByMemoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] arr = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
         System.out.println(shortestPath(5,6,arr));
	}
	
	 static String shortestPath;
	    static class Node{
	        int value;
	        int wt;
	        Node(int val , int w){
	            value = val;
	            wt = w;
	        }
	    }
	    
	    static class Pair implements Comparable<Pair>{
	        int dist;
	        int nodeValue;
	        Pair(int dist , int nodeValue){
	            this.dist = dist;
	            this.nodeValue = nodeValue;
	            
	        }
	        
	        public int compareTo(Pair p) {return this.dist - p.dist;}
	    }
	    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
	        // code here
	        List<List<Node>> graph = new ArrayList<>();
	        for(int i =0  ; i <=n ; i++) graph.add(new ArrayList<>());
	        for(int[] row : edges){
	            int u = row[0];
	            int v = row[1];
	            int wt = row[2];
	            graph.get(u).add(new Node(v,wt));
	            graph.get(v).add(new Node(u,wt));
	        }
	        shortestPath ="";
	        int[] dist = new int[n+1];
	        int[] parent = new int[n+1];
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        for(int i = 1 ; i<=n ; i++) parent[i] = i;
	        dist[0] = -1;
	        dist[1] = 0;
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(0,1));
	        while(!pq.isEmpty()){
	            Pair p = pq.remove();
	            int distance = p.dist;
	            int nodeValue = p.nodeValue;
	           
	            for(Node nbr : graph.get(nodeValue)){
	                if(dist[nbr.value]>distance + nbr.wt){
	                    dist[nbr.value] = distance +nbr.wt;
	                    parent[nbr.value] = nodeValue;
	                    pq.add(new Pair(dist[nbr.value],nbr.value));
	                }
	            }
	        }
	        
	        int nodeValue = n;
	        List<Integer> ans = new ArrayList<>();
	        if(dist[nodeValue]==Integer.MAX_VALUE){
	            ans.add(-1);
	            return ans;
	        }
	        while(parent[nodeValue]!=nodeValue) {
	        	ans.add(0, nodeValue);
	        	nodeValue = parent[nodeValue];
	        }
	        ans.add(0,1);
	        return ans;
	    }

}
