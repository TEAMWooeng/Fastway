package fastway;

public class Sampleclass1 {

	public static void main(String[] args) {
		
		Node[] nodearr = new Node[Node.numOfNode+1];
		nodearr[1] = new Node(3, "location name","address");
		
		PriorityQueue pq = new PriorityQueue();	//make instance
		Pair p = new Pair(nodearr[1],10);
		
		pq.PEnqueue(p);
		
		//this line has problem 
		//Pair pop_p = pq.PDequeue();		
		//pop_p.showPair();
		
		System.out.println("complete");
	
	}

}
