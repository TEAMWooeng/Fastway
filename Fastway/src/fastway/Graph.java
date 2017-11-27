package fastway;

import java.util.Arrays;

public class Graph {
	
	public enum MODE{SPEED, TIME};
	
	static  int numOfNode = 8; 	//#of node that will be used.
	
	// node example --> never changed.
	static public final java.util.LinkedList<String> Nodearr 
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
	private static double[] distance;     //store the distance(find fastest way)
	private static String[] previous;
	//public Graph() {}	//default constructor
	
	public Graph() {
		cost = null;	
		distance = new double[numOfNode+1];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new String[numOfNode+1];
		//initialize
		for(int i =0; i<=numOfNode; i++) {
			previous[i] = null;
		}
	}
	
	private void setCost(LinkedList[] list) {
		this.cost = list;
	}
	
	//dijkstra algorithm
	public void shortestway(MODE m, String s, String e) {
		LinkedList[] Cost = new LinkedList[numOfNode];
		for(int i = 0; i< numOfNode ; i++) {
			Cost[i] = new LinkedList();
		}
		
		Cost = Parsing.parse(m);
		this.setCost(Cost);
		PriorityQueue pq = new PriorityQueue(m);
		
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
