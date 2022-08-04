package Graph;

import java.util.*;
import java.io.*;

public class FindPathInGraphUsinDFS {

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
		int dest = Integer.parseInt(br.readLine());
		
		boolean visited[] = new boolean[vtces];
		boolean res = has_Path(graph, src, dest, visited);
		 System.out.println(res);

		
	}
	private static boolean has_Path(ArrayList<Edge>[] graph, int source, 
			                        int destination, boolean visited[]) {
		
		if(source == destination) {
			return true;
			// If source is equal to destination return true;
		}
		/** Mark our src true first, so it will
		    not get into infinte loop */
		visited[source] = true;
		
		/** Now, visit each and every neighbour of source 
		    and search that destination by recursive call */
		 for(Edge edge : graph[source]) {
			 if(visited[edge.nbr] == false) {
	/** If and only if go in search in that neighbour if that source 
	 	nbr is marked false if not mark false don't visit that nbr */
			 boolean nbr_has_path = has_Path(graph, edge.nbr, destination, visited);
			 
			 if(nbr_has_path == true) {
			     return true;
	/** If that nbr has got our destination than return true or 		     
	    if it does not find that destination than return false at last */
			 }
		   }
		 }
		return false;
	}
	
	/** TIME - O|V| --> Because at max we are searching in each and every vertice */
	/** SPACE - O|V| --> Recursive Space */
	

}