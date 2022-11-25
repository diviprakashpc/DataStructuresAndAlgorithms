package graphsPepcoding;
import java.util.*;
public class NoWaysToReachDestinationWithMinimalDistaance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] arr = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
         System.out.println(ways(7,arr));
	}
	
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
	    public static int ways(int n, int edges[][]) {
	        // code here
	        List<List<Node>> graph = new ArrayList<>();
	        for(int i =0  ; i <n ; i++) graph.add(new ArrayList<>());
	        for(int[] row : edges){
	            int u = row[0];
	            int v = row[1];
	            int wt = row[2];
	            graph.get(u).add(new Node(v,wt));
	            graph.get(v).add(new Node(u,wt));
	        }
	        int[] dist = new int[n];
	        int[] ways = new int[n];
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        for(int i = 0 ; i<n ; i++) ways[i] = 0;
	        ways[0] = 1;
	        dist[0] = 0;
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(0,0));
	        while(!pq.isEmpty()){
	            Pair p = pq.remove();
	            int distance = p.dist;
	            int nodeValue = p.nodeValue;
	           
	            for(Node nbr : graph.get(nodeValue)){
	                if(dist[nbr.value]>distance + nbr.wt){
	                    dist[nbr.value] = distance +nbr.wt;
	                    ways[nbr.value] = ways[nodeValue];
	                    pq.add(new Pair(dist[nbr.value],nbr.value));
	                }
	                else if(dist[nbr.value]==distance+nbr.wt) {
	                	ways[nbr.value] = ways[nbr.value] + ways[nodeValue];
	                }
	            }
	        }
	     
	        return ways[n-1];
	    }

}
