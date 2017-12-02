package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 39; 	//#of node that will be used.
	
	// node example --> never changed.
	public static final java.util.LinkedList<String> Nodearr 
								= new java.util.LinkedList<String>() {{
									
									 add("논현역");
							         add("학동역");
							         add("서울세관");
							         add("교보타워사거리");
							         add("차병원");
							         add("경복아파트");
							         add("삼릉공원");
							         add("차관아파트");
							         add("코엑스");
							         add("강남역");
							         add("국기원앞");
							         add("역삼역");
							         add("르네상스호텔");
							         add("선릉역");
							         add("포스코사거리");
							         add("삼성역");
							         add("강남경찰서");
							         add("강남면허시험장");
							         add("우성아파트");
							         add("역삼초교");
							         add("구역삼세무서");
							         add("개나리아파트");
							         add("도성초교");
							         add("대치사거리");
							         add("휘문고교");
							         add("뱅뱅사거리");
							         add("싸리고개공원입구");
							         add("도곡1동주민센터");
							         add("영동세브란스");
							         add("한티역");
							         add("은마아파트입구");
							         add("대치동우성아파트");
							         add("양재역");
							         add("양재전화국");
							         add("매봉역");
							         add("매봉터널");
							         add("도곡역");
							         add("대치역");
							         add("학여울역");
			
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
