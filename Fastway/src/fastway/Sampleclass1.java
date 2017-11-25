package fastway;

public class Sampleclass1 {
	
	public static void main(String[] args) {
		LinkedList[] cost = new LinkedList[Graph.numOfNode+1];
		for(int i = 1; i <= Graph.numOfNode; i++) {
			cost[i] = new LinkedList();
			cost[i].Insert(new Node(i), i);
			cost[i].Insert(new Node(i+1), i+1);
		}
		Graph g = new Graph(cost);
		for(int i = 1; i<Graph.numOfNode; i++) {
			Pair p =g.cost[i].linkedlist.pop();
			p.showPair();
		}
	}

}
