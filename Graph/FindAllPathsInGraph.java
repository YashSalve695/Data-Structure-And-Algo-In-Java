package Graph;

import java.util.*;
import java.io.*;

public class FindAllPathsInGraph {

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

	
	private static void Find_all_paths(ArrayList<Edge> graph[], int source,
			                           int des, boolean visited[], String path) {
		
		if(source == des) {
			System.out.println(path);
			return;
		}
		
		visited[source] = true;
		
		for(Edge edge : graph[source]) {
			if(visited[edge.nbr] == false) {
				Find_all_paths(graph, edge.nbr, des, visited, path + edge.nbr);
			}
		}
		visited[source] = false;
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
	      //String ans = "";
	      
	      Find_all_paths(graph, src, dest, visited, src + "");

	     
	   }


	}
/**
7 --> Vertices
8 --> Edges
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0 --> source
6 --> destination

*/
