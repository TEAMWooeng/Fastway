package fastway;

public class Sampleclass1 {
	
	public static void main(String[] args) {
		LinkedList[] cost = new LinkedList[Graph.numOfNode+1];
		for(int i= 1; i<= Graph.numOfNode; i++) {
			cost[i] = new LinkedList();
		}
	    cost[1].insert(new Pair(2, "sangdo station",5));
	    cost[1].insert(new Pair(3, "seoul univ.",10));
	    cost[1].Insert(new Node(4, "soongsil univ"), 12 );
	    
	    cost[1].searchInitiallize();
	    for(int i =1; i<=3; i++) {
	    	Pair pair = new Pair();
	    	cost[1].search(pair);
	    	
	    }
	}

}
