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
	private int[] distance;     //store the distance(find fastest way)
	private Node[] previous;
	//public Graph() {}	//default constructor
	
	public Graph(LinkedList[] list) {
		cost = list;	
		distance = new int[numOfNode+1];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new Node[numOfNode+1];
		
	}

	
	public void shortestway(Node start, Node end) {
		
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
		
		
		
		
		
		
		
	}
}
