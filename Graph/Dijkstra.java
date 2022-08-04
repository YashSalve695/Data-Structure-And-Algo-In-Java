package Graph;

import java.util.*;
import java.io.*;

public class Dijkstra {

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
	
	/** This class will store the vertex path_so_far and its total weight */
	public static class Pair implements Comparable<Pair>{
		
		int v;
		String psf;
		int weight;
		
		Pair(int v, String psf, int weight){
			this.v = v;
			this.psf = psf;
			this.weight = weight;
		}

		public int compareTo(Pair o) {
			return this.weight - o.weight;
		}
	}
	
	/** TIME --> O(V +ElogV)
	    SPACE --> O(V + E)*/
	/** ALGO --> REMOVE -> MARK -> WORK(PRINT) -> ADD_NBR */ //(IMP)
	public static void dijsktra(ArrayList<Edge> graph[], int src, int vertices) {
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, src + "", 0));
		/** Initially it will add given src , path and weight */
		
		/** Make boolean array of total vertices in graph */
		boolean visited[] = new boolean[vertices];
		
		/** Loop will run till there are elements in PQ*/
		while(pq.size() > 0) {
			
			/** Remove the pair having lowest in terms of weight */
			Pair remove = pq.remove();
			
			/** If that pair is already visited then continue */
			if(visited[remove.v] == true) {
				continue;
			}
			
			/** If that pair is not visited, then first mark it true,
			    And print its path */
			visited[remove.v] = true;
			System.out.println(remove.v + " via " + remove.psf + " @ " + remove.weight);
			
			/** And add its neighbour */
			for(Edge e : graph[remove.v]) {
				if(visited[e.nbr] == false) {
					pq.add(new Pair(e.nbr, remove.psf + e.nbr, remove.weight + e.wt));
				}
			}
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
	      
	      
	      dijsktra(graph, src, vtces);
	      
	   }
	}



/**
 
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0

OUTPUT
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30
  
 */
