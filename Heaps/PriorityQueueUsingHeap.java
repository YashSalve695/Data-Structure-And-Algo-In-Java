package Heaps;

import java.util.*;
import java.io.*;

public class PriorityQueueUsingHeap {

	public static class PriorityQueue {
	    ArrayList<Integer> data;

	    public PriorityQueue() {
	      data = new ArrayList<>();
	    }

	    public void add(int val) {
	    	
	         data.add(val);
	         upheapify(data.size() - 1);
	    }
	    
	    private void upheapify(int index) {
	    	
	    	if(index == 0) {
	    		return;
	    	}
	    	
	    	int parentindex = (index - 1) / 2;
	    	if(data.get(index) < data.get(parentindex)) {
	    		swap(index, parentindex);
	    		upheapify(parentindex); /** RECURSIVE CALL */
	    	}
	    }
	    
	    private void swap(int i, int j) {
	    	
	    	int first = data.get(i);
	    	int last = data.get(j);
	    	
	    	data.set(i, last);
	    	data.set(j, first);
	    }

	    public int remove() {
	    	
	    	 if(this.size() == 0) {
		    	  System.out.println("Underflow");
		    	  return -1;
		      }
	    	 swap(0, data.size() - 1);
	    	 int val = data.remove(data.size() - 1);
	    	 
	    	 downheapify(0);
	    	 return val;
	    }
	    private void downheapify(int parentindex) {
	    	
	    	int min = parentindex;
	    	int leftindex = 2 * parentindex + 1;
	    	
	    	if(leftindex < data.size() && data.get(leftindex) < data.get(min)) {
	    		min = leftindex;
	    	}
	    	
	    	int rightindex = 2 * parentindex + 2;
	    	if(rightindex < data.size() && data.get(rightindex) < data.get(min)) {
	    		min = rightindex;
	    	}
	    	
	    	if(min != parentindex) {
	    		swap(parentindex, min);
	    		downheapify(min);
	    	}
	    }

	    public int peek() {
	    	
	      if(this.size() == 0) {
	    	  System.out.println("Underflow");
	    	  return -1;
	      }
	      return data.get(0);
	    }

	    public int size() {
	        return data.size();
	    }
	  }

	  public static void main(String[] args) throws Exception {
		  
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue qu = new PriorityQueue();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("add")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        qu.add(val);
	      } else if (str.startsWith("remove")) {
	        int val = qu.remove();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("peek")) {
	        int val = qu.peek();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("size")) {
	        System.out.println(qu.size());
	      }
	      str = br.readLine();
	    }
	  }
}
