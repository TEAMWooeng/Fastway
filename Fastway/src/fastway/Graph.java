package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 39; 	//#of node that will be used.
	private static int numofstage;
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
	
	
	public static final String[][] Latlong = {
			//please input Latlong here
			{"논현역","37.511069","127.021361"},
			{"학동역","37.513935","127.030729"},
			{"서울세관","37.515358","127.035354"},
			{"교보타워사거리","37.504439","127.024511"},
			{"차병원","37.507273","127.033868"},
			{"경복아파트","37.508666","127.038516"},
			{"삼릉공원","37.510252","127.043863"}, 
			{"차관아파트","37.513003","127.053263"}, 
			{"코엑스","37.514211","127.060213"},
			{"강남역","37.497930","127.027617"},
			{"국기원앞","37.498969","127.031021"},
			{"역삼역","37.500759","127.036904"},
			{"르네상스호텔","37.502605","127.042758"}, 
			{"선릉역","37.504477","127.049011"}, 
			{"포스코사거리","37.506847","127.056626"},
			{"삼성역","37.508875","127.063146"},
			{"강남경찰서","37.509940","127.067372"},
			{"강남면허시험장","37.507082","127.067512"},
			{"우성아파트","37.492981","127.029952"},
			{"역삼초교","37.494045","127.033410"},
			{"구역삼세무서","37.495830","127.039234"},
			{"개나리아파트","37.498458","127.044679"},
			{"도성초교","37.500531","127.050840"},
			{"대치사거리","37.503282","127.058600"}, 
			{"휘문고교","37.505212","127.065065"},
			{"뱅뱅사거리","37.489539","127.031611"}, 
			{"싸리고개공원입구","37.491110","127.036746"},
			{"도곡1동주민센터","37.492340","127.040883"},
			{"영동세브란스","37.494187","127.046703"},
			{"한티역","37.496353","127.052869"}, 
			{"은미아파트입구","37.498908","127.060881"},
			{"대치동우성아파트","37.500989","127.067439"},
			{"양재역","37.484522","127.034060"},
			{"양재전화국","37.485563","127.041351"},
			{"매봉역","37.486980","127.046848"},
			{"매봉터널","37.488371","127.049855"},
			{"도곡역","37.490877","127.055378"},
			{"대치역","37.494463","127.063190"},
			{"학여울역","37.496495","127.069863"}
	};
									
	public static LinkedList[] cost;	//store final weight 
	private static double[] distance;   //store the distance(find fastest way)
	private static String[] previous;
	
	//constructor
	public Graph() {
		numofstage = 0;
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
		
		numofstage = 0; //store # of stage
		showShortestPath(sidx, eidx, previous);	//show the root on console
		
		String[][] latlong = new String[numofstage][3];	// make string -> html argument
		
		int cnt = 0;
		int idx = eidx;
		
		while(true) {
			
			latlong[cnt][0] = "'"+Latlong[idx][0]+"'";
			latlong[cnt][1] = Latlong[idx][1];
			latlong[cnt][2] = Latlong[idx][2];
		
			if(previous[idx].equals(""))
				break;
			cnt++;
			idx = findNodeIdx(previous[idx]);
		}
		
		System.out.println();
		
		ShowMap.showload(latlong);
	}
	
	//show the root
	private static void showShortestPath(int sidx, int eidx, String[] previous) {
		
		//print path
		if(sidx == eidx && previous[sidx].equals("")) {
			System.out.print(Nodearr.get(sidx));
			numofstage++;
			return;
		}else {
			showShortestPath(sidx, Graph.findNodeIdx(previous[eidx]), previous);
			System.out.print("-"+Nodearr.get(eidx));
			numofstage++;
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
