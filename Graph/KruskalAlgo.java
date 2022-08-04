package Graph;

import java.util.*;
import java.io.*;

public class KruskalAlgo {
	
	
	/**
    
    There are n vertices and there are edges in between some of the vertices. 
    Find the sum  of edge weight of minimum spanning tree.
    
7 
8
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
	public static void main(String[] args) throws Exception {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int v = Integer.parseInt(br.readLine());
	    int e = Integer.parseInt(br.readLine());

	    int[][] edges = new int[e][3];
	    for (int i = 0; i < e; i++) {
	      String[] st = br.readLine().split(" ");
	      edges[i][0] = Integer.parseInt(st[0]);
	      edges[i][1] = Integer.parseInt(st[1]);
	      edges[i][2] = Integer.parseInt(st[2]);
	    }

	    System.out.println(Kruskal_Algo(v, edges));
	  }

	  static int[] parent;
	  static int[] rank;

	  /** pair  */
	  public static class Pair implements Comparable<Pair> {
	    int u; // vertex
	    int v; // edge
	    int wt; // weight

	    Pair(int u, int v, int wt) {
	      this.u = u;
	      this.v = v;
	      this.wt = wt;
	    }

	    public int compareTo(Pair o) {
	      return this.wt - o.wt;
	    }
	  }

	  public static int Kruskal_Algo(int n, int[][] Edges) {
	   
		  Pair[] edges = new Pair[Edges.length];

	    for (int i = 0; i < Edges.length; i++) {
	      int u = Edges[i][0];
	      int v = Edges[i][1];
	      int wt = Edges[i][2];
	      edges[i] = new Pair(u, v, wt);
	    }

	    int ans = 0;
	    Arrays.sort(edges);
	    parent = new int[n + 1];
	    rank = new int[n + 1];

	    for (int i = 0; i < parent.length; i++) {
	      parent[i] = i;
	      rank[i] = 1;
	    }

	    for (int i = 0; i < edges.length; i++) {
	    	
	      int u = edges[i].u; // vert
	      int v = edges[i].v; // edge
	      int wt = edges[i].wt; // weight

	      boolean flag = union(u, v);
	      if (flag == false) {
	        ans += wt;
	      }
	    }

	    return ans;

	  }

	  public static int find(int x) {
		  
	    if (parent[x] == x) {
	      return x;
	    }
	    int temp = find(parent[x]);
	    parent[x] = temp;
	    return temp;
	  }

	  public static boolean union(int x, int y) {
		  
	    int leader_x = find(x);
	    int leader_y = find(y);

	    if (leader_x == leader_y) {
	      return true;
	    }

	    if (rank[leader_x] > rank[leader_y]) {
	      parent[leader_y] = leader_x;
	      
	    } else if (rank[leader_x] < rank[leader_y]) {
	      parent[leader_x] = leader_y;
	      
	    } else {
	      parent[leader_x] = leader_y;
	      rank[leader_y]++;
	    }

	    return false;
	  }
	}

	                                