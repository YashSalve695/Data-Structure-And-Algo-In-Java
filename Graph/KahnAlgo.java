package Graph;

import java.io.*;
import java.util.*;

public class KahnAlgo {
	
	
	
	/**
	 
	 coding offers total of n courses labelled from 0 to n-1.

    Some courses may have prerequisites. you have been given m pairs ai,bi. 
    where 1 pair means you must take the course bi before the course ai.

    Given the total number of courses numCourses and a list of the prerequisite pairs, 
    return the ordering of courses you should take to finish all courses. 
    If it is impossible to finish all courses print -1.
    
4 4
1 0
2 0
3 1
3 2

0 1 2 3 4
	 
	 */
	
	public static int[] findOrder(int numCourses, ArrayList<ArrayList<Integer>> graph) {

		int[] ans = new int[numCourses];
		int[] indegree = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			for (int nbrs : graph.get(i)) {
				indegree[nbrs]++;
			}
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.addLast(i);
		/** if the degree of the val is 0 than add the queue */		
			}
		}

		int idx = 0;
		while (queue.size() > 0) {
			int rem = queue.removeFirst();
			ans[idx] = rem;
			idx++;

			for (int nbrs : graph.get(rem)) {
				indegree[nbrs]--;
				if (indegree[nbrs] == 0) {
					queue.addLast(nbrs);
				}
			}
		}

		if (idx == numCourses) {
			return ans;
		} else {
			return new int[] { -1 };
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] prerequisites = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			prerequisites[i][0] = Integer.parseInt(st[0]);
			prerequisites[i][1] = Integer.parseInt(st[1]);
		}
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][0];
			int v = prerequisites[i][1];

			graph.get(v).add(u);
		}
		

		int[] ans = findOrder(n, graph);

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}
}

                            