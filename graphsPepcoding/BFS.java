package graphsPepcoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphsPepcoding.GraphMain.Edge;

public class BFS {
    static class Edge {
	int src;
	int nbr;
	int wt;

	Edge(int src, int nbr, int wt) {
	    this.src = src;
	    this.nbr = nbr;
	    this.wt = wt;
	}
    }

    static class Pair {
	int src;
	String psf;

	Pair(int src, String psf) {
	    this.src = src;
	    this.psf = psf;
	}
    }

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int vtces = Integer.parseInt(br.readLine());
	ArrayList<Edge>[] graph = new ArrayList[vtces];
	for (int i = 0; i < vtces; i++) {
	    graph[i] = new ArrayList<>();
	}

	int edges = Integer.parseInt(br.readLine());
	for (int i = 0; i < edges; i++) {
	    String[] parts = br.readLine().split(" ");
	    int v1 = Integer.parseInt(parts[0]);
	    int v2 = Integer.parseInt(parts[1]);
	    int wt = Integer.parseInt(parts[2]);
	    graph[v1].add(new Edge(v1, v2, wt));
	    graph[v2].add(new Edge(v2, v1, wt));
	}

	int src = Integer.parseInt(br.readLine());
	boolean[] visited = new boolean[vtces];
	bfs(graph, src, visited);

    }

    public static void bfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {
	Queue<Pair> q = new LinkedList<>();
	q.add(new Pair(src, src + ""));
	while (q.size() > 0) {
	    // REMOVE(R),MARK STAR(M*),WORK(W),ADD STAR(*) (IF ALREADY MARKED STAR I.E
	    // ALREADY VISITED THEN DO NOT WORK AND REMOVE AGAIN)
	    Pair p = q.remove();
	    if (visited[p.src] == true)
		continue;
	    if (visited[p.src] == false) {
		visited[p.src] = true;
		System.out.println(p.src + "@" + p.psf);
		for (Edge e : graph[p.src]) {
		    if (visited[e.nbr] == false) {
			q.add(new Pair(e.nbr, p.psf + e.nbr));
		    }
		}
	    }
	}

    }

}
