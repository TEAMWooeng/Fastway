package fastway;

import java.util.Arrays;

public class Graph {
	static private int numOfNode = 10; 	//#of node that will be used.

	private static LinkedList[] cost;	//store final weight ( real time + distance)
	private int[] distance;     //store the distance(find fastest way)
	private Node[] previous;
	//public Graph() {}	//default constructor
	
	public Graph(LinkedList[] list, Node start) {
		cost = list;	//does it need deep copy?
		distance = new int[numOfNode+1];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new Node[numOfNode+1];
		
	}
	
	public void shortestway(Node start, Node end) {
		
		PriorityQueue pq = new PriorityQueue();
		pq.PEnqueue(new Pair(start, 0));	//enqueue starting node and distance 0
		distance[start.getIdx()] = 0;
		
		while(pq.getNumOfdata() != 0) {
			Pair pair = pq.PDequeue(); //pop a pair
			int index = pair.getNode().getIdx(); 	//index of node
			Pair tmpPair = new Pair();
			
			if(cost[index].search(tmpPair)) { //if there is element
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
