package Graph;

import java.util.*;
import java.io.*;

public class ConnectCitiesWithMinCost {
	
	/**
	  
	 There are n cities and there are roads in between some of the cities. 
	 Somehow all the roads are damaged simultaneously. We have to repair the roads to 
	 connect the cities again. There is a fixed cost to repair a particular road. 
	 Find out the minimum cost to connect all the cities by repairing roads.
	 
7 vertice
8 edges
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8

38
      
      */
	 static class Edge implements Comparable<Edge> {
		    int v; /** vertice */
		    int wt;/** weight */

		    Edge(int nbr, int wt) {
		      this.v = nbr;
		      this.wt = wt;
		    }

		    public int compareTo(Edge o) {
		      return this.wt - o.wt;
		    }
		  }

		  public static void main(String[] args) throws Exception {
			  
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int vtces = Integer.parseInt(br.readLine());
		    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		    for (int i = 0; i < vtces; i++) {
		      graph.add(new ArrayList<>());
		    }

		    int edges = Integer.parseInt(br.readLine());
		    for (int i = 0; i < edges; i++) {
		      String[] parts = br.readLine().split(" ");
		      int v1 = Integer.parseInt(parts[0]); //vertice
		      int v2 = Integer.parseInt(parts[1]); //nbr
		      int wt = Integer.parseInt(parts[2]); // weight
		      graph.get(v1).add(new Edge(v2, wt));
		      graph.get(v2).add(new Edge(v1, wt));
		    }
  
		  int ans = 0;
		  
		  PriorityQueue<Edge> pq = new PriorityQueue<>();
		  pq.add(new Edge(0, ans));
		  boolean visited[] = new boolean[vtces];
		  
		  while(pq.size() > 0) {
			  
			  Edge remove = pq.remove();
			/** Vertice having small weight will remove */  
			  
			  if(visited[remove.v] == true) {
				  continue;
		   /** if that vertice is already visited than, move forward*/		  
			  }
			  
			  visited[remove.v] = true;
		/** If that vertice is not visited, than mark it true */	  
			  
			  ans += remove.wt;
		/** add that min weight in our ans */	  
			  
			  ArrayList<Edge> nbrs = graph.get(remove.v);
			   for(Edge nbr : nbrs) {
				   if(visited[nbr.v] == false) {
					   pq.add(nbr);
				    }
		/** Now, add their unvisited nbr only */		   
			   }
		  }
           System.out.println(ans);
		  }

		}
