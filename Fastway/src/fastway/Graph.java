package fastway;

import java.util.Arrays;

public class Graph {
	static  int numOfNode = 5; 	//#of node that will be used.
	
	// node example --> never changed.
	static public final java.util.LinkedList<String> Nodearr 
								= new java.util.LinkedList<String>() {{
			add("A");
			add("B");
			add("C");
			add("D");
			add("E");
			
	}};
	
	
	public static LinkedList[] cost;	//store final weight 
	private static int[] distance;     //store the distance(find fastest way)
	private static String[] previous;
	//public Graph() {}	//default constructor
	
	public Graph(LinkedList[] list) {
		cost = list;	
		distance = new int[numOfNode+1];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new String[numOfNode+1];
		//initialize
		for(int i =0; i<=numOfNode; i++) {
			previous[i] = null;
		}
	}

	public void shortestway(String s, String e) {
		
		PriorityQueue pq = new PriorityQueue();
		int sidx = Graph.findNodeIdx(s);
		int eidx = Graph.findNodeIdx(e);
		
		distance[sidx] = 0;
		previous[sidx] = ""; 
		pq.PEnqueue(new Pair(s,0));
	
		while(!pq.HIsEmpty()) {
			Pair upperPair = pq.PDequeue();
			int upperidx = Graph.findNodeIdx(upperPair.getNode());
			
			cost[upperidx].searchInitiallize();
			Pair tmpPair = new Pair();
			while(cost[upperidx].search(tmpPair)) {
				
				int tmpidx = Graph.findNodeIdx(tmpPair.getNode());
				
				if(distance[tmpidx]>distance[upperidx]+tmpPair.getWeigth()) {
					distance[tmpidx] = distance[upperidx]+tmpPair.getWeigth();
					previous[tmpidx] = upperPair.getNode();
					pq.PEnqueue(new Pair(tmpPair.getNode(), distance[tmpidx]));	
				}
			}
			
		}
		
		showShortestPath(sidx, eidx, previous);
		System.out.println();
	}
	

	private static void showShortestPath(int sidx, int eidx, String[] previous) {
		
		if(sidx == eidx && previous[sidx].equals("")) {
			System.out.print(Nodearr.get(sidx));
			return;
		}else {
			showShortestPath(sidx, Graph.findNodeIdx(previous[eidx]), previous);
			System.out.print("-"+Nodearr.get(eidx));
		}
		
	}
	
	//if there is same node in node array, return index of that node. else, return -1
	public static int findNodeIdx(String str) {
		int num = 0;
		while(Nodearr.size()>num) {
			if(Nodearr.get(num).equals(str)) {
				return num;
			}
			num++;
		}
		return -1;
	}
}
