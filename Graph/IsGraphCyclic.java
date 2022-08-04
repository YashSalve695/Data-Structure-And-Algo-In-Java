package Graph;

import java.util.*;

import Graph.IsGraphCyclic.Pair;

import java.io.*;

public class IsGraphCyclic {

	 static class Edge {
	      int src; // vertice
	      int nbr; // neighbour
	      int wt; // weight

	      Edge(int src, int nbr, int wt) {
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }
	
	 /** This class will store each vertice and path */
	 public static class Pair {
		 
		 int src;
		 String psf; // Path_so_far
		 
		 public Pair(int src, String psf) {
			
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

	      boolean visited[] = new boolean[vtces];
	       
	      for(int v = 0; v < vtces; v++) {
	    	  if(visited[v] == false) {
	    		  
	    		  boolean cyclic = Is_cyclic(graph, v, visited);
	    		  
	    		  if(cyclic) {
	    			  System.out.println(true);
	    			  return;
	    		  }
	    	  }
	      }
	      System.out.println(false);
	   }
	   
	   
	   
	   
	   /** FUNCTION TO KNOW IF GRAPH IS CYCLIC OR NOT */
	   private static boolean Is_cyclic(ArrayList<Edge> graph[], int src, boolean visited[]) {
		   
		   /** BFS , So we use Queue */
		   /** Technique --> REMOVE -> MARK -> PRINT -> ADD NEIGHBOUR */ /** IMP */
		   
		   ArrayDeque<Pair> queue = new ArrayDeque<>();
		   queue.add(new Pair(src, src + " "));
		   
		   while(queue.size() > 0) {
			   
			   Pair remove = queue.removeFirst(); /** REMOVE
			   
			   /**  If visited src is true then, there is cyclic */
			   if(visited[remove.src] == true) {
				   return true;
			   }
			   
			   visited[remove.src] = true; /** MARK */
			   
			   for(Edge edge : graph[src]) { /** ADD NEIGHBOUR */
				   if(visited[edge.nbr] == false) {
					   queue.add(new Pair(edge.nbr, remove.psf + edge.nbr));
				   }
			   }
		   }
		   return false;
	   }
	   
	}

/**
 
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
  
 */
  