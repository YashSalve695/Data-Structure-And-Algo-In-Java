package Graph;

import java.util.*;
import java.io.*;

public class BusRoutes {
	
	
	/**
	 
	 You are given an array routes representing bus routes where routes[i] 
	 is a bus route that the ith bus repeats forever.

    For example, if routes[1] = [1, 5, 7], this means that the 1st bus travels in 
    the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

    You will start at the bus stop source (You are not on any bus initially), 
    and you want to go to the bus stop target. You can travel between bus stops by buses only.
    
    Return the least number of buses you must take to travel from source to target. 
    Return -1 if it is not possible.
    
2
3
1 2 7
3 6 7
1 6

2
	 
	 */
	
	 public static int numBusesToDestination(int[][] routes, int S, int T) {

		 int n = routes.length;
		 
		 HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		  for(int i = 0; i < n; i++) {
			  for(int j = 0; j < routes[i].length; j++) {
				  int bus_stop_no = routes[i][j];
				  
				  ArrayList<Integer> bus_no = map.getOrDefault(bus_stop_no, new ArrayList<>());
				  
				  bus_no.get(i);
				  map.put(bus_stop_no, bus_no);
			  }
		  }
		 LinkedList<Integer> queue = new LinkedList<>();
		 HashSet<Integer> bus_stop_vis = new HashSet<>();
		 HashSet<Integer> bus_no_vis = new HashSet<>();
		 
		 int level = 0;
		 
		 queue.addLast(S);
		 bus_stop_vis.add(S);
		 
		 while(queue.size() > 0) {
			 
			 int size = queue.size();
			 level++;
			 
			 while(size-- > 0) {
				 
				 int remove = queue.removeFirst();
				 
				 if(remove == T) {
					 return level;
				 }
				 
				 ArrayList<Integer> buses = map.get(remove);
				 
				 for(int bus : buses) {
					 if(bus_no_vis.contains(bus) == true) {
						 continue;
					 }
					 
					 int arr[] = routes[bus];
					  for(int bustop : arr) {
						  if(bus_stop_vis.contains(bustop) == true) {
							  continue;
						  }
						  queue.addLast(bustop);
						  bus_stop_vis.add(bustop);
					  }
					  bus_no_vis.add(bus);
					 
				 }
			 }
		 }
		 return -1;
	  }

	 public static void main(String[] args) throws NumberFormatException, IOException {
		 
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n = Integer.parseInt(br.readLine());
		    int m = Integer.parseInt(br.readLine());

		    int[][] arr = new int[n][m];

		    for (int i = 0; i < n; i++) {
		      String[] st = br.readLine().split(" ");
		      for (int j = 0; j < m; j++) {
		        arr[i][j] = Integer.parseInt(st[j]);
		      }
		    }

		    String[] st1 = br.readLine().split(" ");
		    int src = Integer.parseInt(st1[0]);
		    int dest = Integer.parseInt(st1[1]);
		    System.out.println(numBusesToDestination(arr, src, dest));

		  }

		 
		}
