package Graph;

import java.util.*;

public class ArticulationPoint {
	
	static int parent[];
	static int discover[];
	static int low[];
	static boolean visited[];
	static boolean Ap[];
	//static int time;
	
	  static int time = 0;

	  private static void AP_Bridges(ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, int[] parent,
	                                 boolean[] Apoint, boolean[] visited, int src) {
	    disc[src] = low[src] = ++time;
	    int counter = 0;
	    visited[src] = true;
	    for (int e = 0; e < graph.get(src).size(); e++) {
	      int nbr = graph.get(src).get(e);
	      if (parent[src] == nbr) {
	        continue;
	        
	      } else if (visited[nbr] == true) {
	        low[src] = Math.min(low[src], disc[nbr]);
	        
	      } else {
	    	  
	        parent[nbr] = src;
	        AP_Bridges(graph, disc, low, parent, Apoint, visited, nbr);
	        low[src] = Math.min(low[src], low[nbr]);
	        
	        if (parent[src] == -1) {
	          counter++;
	          if (counter >= 2) {
	            Apoint[src] = true;
	          }
	        } else {
	          if (low[nbr] >= disc[src]) {
	            Apoint[src] = true;
	          }
	        }

	      }
	    }
	  }

	  public static void main(String[] args) {
	   
	    Scanner scn = new Scanner(System.in);


	    int v = scn.nextInt();
	    int e = scn.nextInt();
	    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	    for (int i = 0; i < v; i++) {
	      g.add(new ArrayList<>());
	    }
	    for (int i = 0; i < e; i++) {
	      int v1 = scn.nextInt();
	      int v2 = scn.nextInt();
	      
	      g.get(v1 - 1).add(v2 - 1);
	      g.get(v2 - 1).add(v1 - 1);
	    }

	    boolean A_point[] = new boolean[v];
	    int[] parent = new int[v];
	    parent[0] = -1;
	    AP_Bridges(g, new int[v], new int[v], parent, A_point, new boolean[v], 0);
	    int count = 0;
	    for (int i = 0; i < v; i++) {
	      if (A_point[i]) {
	        count++;
	      }
	    }
	    System.out.println(count);



	  }

	}



/**
5 5
1 2
1 3
3 2
3 4
5 4

2
 
 */
 
	                                