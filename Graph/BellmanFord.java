package Graph;

import java.util.*;
import java.io.*;

public class BellmanFord {
	
	/**
     
   You are given 2 integers N and M , N is the number of vertices, M is the number of edges. 
   You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a 
   vertex bi and wi respresents the weight of that edge.
   
   Your task is to find the shortest path from source vertex (vertex number 1) to all 
   other vertices.

5 5
1 2 5
1 3 2
3 4 1
1 4 6
3 5 5

5 2 3 7 
     
     
     */
	 public static void main(String[] args) {
		 
		    Scanner scn = new Scanner(System.in);
		    
		    int n = scn.nextInt();
		    int m = scn.nextInt();
		    int[][] matrix = new int[m][3];
		    for (int i = 0; i < m; i++) {
		    	
		      int u = scn.nextInt();
		      int v = scn.nextInt();
		      int w = scn.nextInt();
		      matrix[i][0] = u - 1;
		      matrix[i][1] = v - 1;
		      matrix[i][2] = w;
		    }
		    
		    
		    int[] path = new int[n];
		    Arrays.fill(path, Integer.MAX_VALUE);
		  /** Fill the path array with infinity */  
		    path[0] = 0;
		    for(int i = 0; i < path.length; i++) {
		    	System.out.print(path[i] + " ");
		    }
		  /** At zero position in array keep 0*/  
		    scn.close();
		    
		    for (int i = 0; i < n - 1; i++) {
		    /** Now, iterate till v - 1 edges*/
		    	
		      for (int j = 0; j < m; j++) {
		        int u = matrix[j][0];
		        int v = matrix[j][1];
		        int w = matrix[j][2];
		     /** Now take out vertice, edges and weight */   
		        
		        if (path[u] == Integer.MAX_VALUE) {
		          continue;
		        }
		     /** If the value of vertice in path is infinity than continue
		         because infinity + infinity is always infinity */   
		        
		        if (path[u] + w < path[v]) {
		          path[v] = path[u] + w;
		        }
		     /** Now, the value in path is not infinity than update 
		         the values in the path */   
		      }
		    }
		    for (int i = 1; i < path.length; i++) {
		      if (path[i] == Integer.MAX_VALUE)
		      {
		        System.out.print("1000000000" + " " );
		    /** If values in path is infinity than return 10^9*/    
		      }
		      else {
		        System.out.print(path[i] + " " );
		      }
		    }
		  }
		}