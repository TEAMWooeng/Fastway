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

	/*
	public void shortestway(String s, String e) {
		
		//find node array index
		int sidx = 0, eidx = 0;
		int num =0;
		while(nodearr.size() > num) {
			if(nodearr.get(num).getLName().equals(s)) {
				sidx = num;
				break;
			}
				num++;
		}
		
		num = 0;
		while(nodearr.size() >num) {
			if(nodearr.get(num).getLName().equals(e)) {
				eidx = num;
				break;
			}
			num++;
		}
		
		//check error
		if(sidx == -1 || eidx == -1) {
			System.out.println("Error");
			return;
		}
		
		Node start = Graph.nodearr.get(sidx);
		Node end = Graph.nodearr.get(eidx);
		
		
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		PriorityQueue pq = new PriorityQueue(); //pq initialize
		
		pq.PEnqueue(new Pair(start, 0));	//enqueue starting node and distance 0
		distance[start.getIdx()] = 0;
		previous[start.getIdx()] = start;
		while(pq.getNumOfdata() != 0) {
			
			Pair pair = pq.PDequeue(); //pop a pair
			int index = pair.getNode().getIdx(); 	//index of node
			
			cost[index].searchInitiallize(); //before search the list, initialize cur to 0
			
			Pair tmpPair = new Pair(); //the pair that store element in list.
			while(cost[index].search(tmpPair)) { //if there is element
				//tmpPair.showPair();
				int nodeidx = tmpPair.getNode().getIdx();
				int weight = tmpPair.getWeigth();
				
				if(distance[nodeidx] > distance[index] +weight) {
					distance[nodeidx] = distance[index] + weight;
					previous[nodeidx] = pair.getNode(); //set previous
					pq.PEnqueue(new Pair(tmpPair.getNode(), distance[nodeidx]));
				}
			}
			
			
		}
		
		
		//showShortestPath(start, end, previous);
		previous = null; // delete dynamic allocation 
	
	}
	
*/
	
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
