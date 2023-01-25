package graphsPepcoding;
import java.util.*;
public class PrimsBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution
	{
	    static class Edge implements Comparable<Edge>{
	        int u;  //parent
	        int v;  // current node
	        int wt;  // weight between u - > v
	        Edge(int u , int v , int wt){
	            this.u = u;
	            this.v = v;
	            this.wt = wt;
	        }
	        public int compareTo(Edge e){
	            return this.wt - e.wt;
	        }
	    }
	    
	    //Function to find sum of weights of edges of the Minimum Spanning Tree.
	    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> graph) 
	    {
	        boolean[] visited = new boolean[n];;
	        List<Edge> mst= new ArrayList<>();;
	        int sum = 0;  // Weight of minimum spanning tree.
	        PriorityQueue<Edge> pq = new PriorityQueue<>();
	        pq.add(new Edge(-1,0,0)); //For starting with a vertex we assume parent to be -1 and weight be 0 betweeen them.
	        while(!pq.isEmpty()){    
	            Edge e = pq.remove();
	            int u = e.u;
	            int v = e.v;
	            int wt = e.wt;
	            if(visited[v]) continue;  // If edge related to v is visited ,this means its minimum weight is already considered . (greedy) Therefore no need to visit
	            sum+=wt;
	            if(u!=-1){  //If parent is -1 then it is our assumption , therefore wont add in mst
	                mst.add(e);  //Adding the edge removed from pq in mst , because it has a minimum weight.
	            }
	            visited[v] = true;
	            for(ArrayList<Integer> nbr : graph.get(v)){
	                if(!visited[nbr.get(0)]){
	                    pq.add(new Edge(v,nbr.get(0),nbr.get(1)));  //Add all edges corresponding to minimum weight.
	                }
	            }
	        }
	        return sum;
	    }
	}	

}
