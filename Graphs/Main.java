package Graphs;

import java.util.*;

public class Main {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int e = sc.nextInt();
	int[][] edges = new int[n][n];

	for (int i = 0; i < e; i++) {
	    int sv = sc.nextInt();
	    int ev = sc.nextInt();

	    edges[sv][ev] = 1;
	    edges[ev][sv] = 1;
	}

	print(edges, 0);
    }

    public static void print(int[][] edges, int sv) {
	boolean[] visited = new boolean[edges.length];
	for (int i = 0; i < visited.length; i++) {
	    if (!visited[i]) {
		// printHelper(edges,i,visited);
		printBFS(edges,i,visited);
	    }
	}

    }

    public static void printBFS(int[][] edges, int sv, boolean[] visited) {
	Queue<Integer> q = new LinkedList<>();
	q.add(sv);
	visited[sv] = true;
	while (!q.isEmpty()) {
	    int size = q.size();
	    while (size-- > 0) {
		int curr = q.remove();
		System.out.print(curr +" ");
		
		for (int j = 0; j < edges.length; j++) {
		    if (edges[curr][j] != 0 && visited[j] == false) {
			q.add(j);
			visited[j] = true;

		    }
		}
	    }
	}
    }

    public static void printHelper(int[][] edges, int sv, boolean[] visited) {

	System.out.print(sv + " ");
	visited[sv] = true;
	for (int j = 0; j < edges.length; j++) {
	    if (edges[sv][j] != 0 && !visited[j]) {
		printHelper(edges, j, visited);
	    }
	}

    }
}
