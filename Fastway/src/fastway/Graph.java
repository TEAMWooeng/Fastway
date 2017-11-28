package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 8; 	//#of node that will be used.
	
	// node example --> never changed.
	public static final java.util.LinkedList<String> Nodearr 
								= new java.util.LinkedList<String>() {{
			add("노들역");
			add("노량진역");
			add("상도터널");
			add("상도역");
			add("노량진삼거리");
			add("장승배기");
			add("상도대림아파트");
			add("신상도초교");
	}};
	
	
	public static LinkedList[] cost;	//store final weight 
	private static double[] distance;   //store the distance(find fastest way)
	private static String[] previous;
	
	//constructor
	public Graph() {
		cost = null; //initialize when call shortestway method	
		distance = new double[numOfNode];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new String[numOfNode];
		//initialize
		for(int i =0; i<numOfNode; i++) {
			previous[i] = null;
		}
	}
	

	
	//dijkstra algorithm
	public void shortestway(MODE m, String s, String e) {
		//initialize cost variable in graph
		this.setCost(Parsing.parse(m));
		PriorityQueue pq = new PriorityQueue(m);
		
		int sidx = Graph.findNodeIdx(s);
		int eidx = Graph.findNodeIdx(e);
		
		//Staring node initialize
		distance[sidx] = 0;
		previous[sidx] = ""; 
		pq.PEnqueue(new Pair(s,0));
		
		//Start dijkstra algorithm
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
	
	private void setCost(LinkedList[] list) {
		cost = list;
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
