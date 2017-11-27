package fastway;

import java.util.Arrays;

public class Graph {
	static  int numOfNode = 5; 	//#of node that will be used.
	
	// node example --> never changed.
	static public final java.util.LinkedList<Node> nodearr 
								= new java.util.LinkedList<Node>() {{
		
			add(new Node(1, "A"));
			add(new Node(2, "B"));
			add(new Node(3, "C"));
			add(new Node(4, "D"));
			add(new Node(5, "E"));
			
	}};
	
	public static LinkedList[] cost;	//store final weight 
	private static int[] distance;     //store the distance(find fastest way)
	private static Node[] previous;
	//public Graph() {}	//default constructor
	
	public Graph(LinkedList[] list) {
		cost = list;	
		distance = new int[numOfNode+1];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new Node[numOfNode+1];
		
	}

	
	public void shortestway(String s, String e) {
		
		int sidx = findNodeIdx(s);
		int eidx = findNodeIdx(e);
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
		
		while(pq.getNumOfdata() != 0) {
			
			Pair pair = pq.PDequeue(); //pop a pair
			int index = pair.getNode().getIdx(); 	//index of node
			
			Pair tmpPair = new Pair(); //the pair that store element in list.
			
			cost[index].searchInitiallize(); //before search the list, initialize cur to 0
			
			while(cost[index].search(tmpPair)) { //if there is element
				int nodeidx = tmpPair.getNode().getIdx();
				int weight = tmpPair.getWeigth();
				
				if(distance[nodeidx] > distance[index] +weight) {
					distance[nodeidx] = distance[index] + weight;
					previous[nodeidx] = pair.getNode(); //set previous
					pq.PEnqueue(new Pair(tmpPair.getNode(), distance[nodeidx]));
				}
			}
			
			
		}
		
		showShortestPath(start, end, previous);
		previous = null; // delete dynamic allocation 
	}
	

	private void showShortestPath(Node start, Node end, Node[] previous) {
		while(true) {
			if(start.getIdx() == end.getIdx()) {
				System.out.println(start.getLName());
				break;
			}else {
				showShortestPath(start, previous[end.getIdx()], previous);
				System.out.println(end.getLName());
			}
		}
	}
	
	//if there is same node in node array, return index of that node. else, return -1
	public static int findNodeIdx(String str) {
		int num = 0;
		while(nodearr.size()>num) {
			if(nodearr.get(num).getLName().equals(str)) {
				return num;
			}
		}
		return -1;
	}
}
