package fastway;

public class Pair{
	
	private Node n;
	private int weight;
	
	public Pair() {} //default constructor
	
	public Pair( Node n, int weight){ //constructor
		this.n =n;
		this.weight = weight;
	}
	
	public Node getNode() {
		return this.n;
	}
	public int getWeigth() {
		return this.weight;
	}
	public void showPair() {
		this.n.showNInfo();
		System.out.println("weight : "+this.weight);
	}
	
	//initialize node -> where? 
	public static Node[] node_setting() {
		Node[] nodearr = new Node[Node.numOfNode+1];
		for(int i = 1; i<= Node.numOfNode; i++) {
			nodearr[i] = new Node(i);
		}
		return nodearr;
	}
}


class Node {
	
	static final int numOfNode = 10;	//setting #of Nodes(const variable)
	private int idxnum;	//index in array
	private String location_name;
	private String address;
	public Node() {} //default constructor
	
	public Node(int n ){ //constructor
		this.idxnum = n;
		this.location_name = "location : "+this.idxnum;
		this.address = "address : "+this.idxnum;
	}
	
	public Node(int n, String lname, String address) {//constructor
		this.idxnum = n;
		this.location_name = lname;
		this.address = address;
	}

	public void showNInfo() { //showing information of node.
		System.out.println("location name: "+this.location_name);
		System.out.println("Address: "+ this.address);
	}
	
	public String getLName() {//get location name
		return this.location_name;
	}
	
	public int getIdx() {//get index in array
		return this.idxnum;
	}
	
	public String getAddress() {
		return this.address;
	}
	
}