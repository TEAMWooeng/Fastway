package fastway;

public class Node {
	static final int numOfNode = 10;	//setting #of Nodes(const variable)
	private int idxnum;	//idx in array
	private String location_name;
	private String address;
	public Node() {} //default constructor
	
	public Node(int n ){ //default constructor
		this.idxnum = n;
		this.location_name = "location : "+this.idxnum;
		this.address = "address : "+this.idxnum;
	}
	
	public Node(String lname, String address) {//constructor
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
	public int getIdx() {//get idx in array
		return this.idxnum;
	}
	public String getAddress() {
		return this.address;
	}
	
	public static void  setting(Node[] n) { //make nodes
		
		n = new Node[numOfNode];
		for(int i = 0; i<numOfNode; i++) {
		n[i] = new  Node(i);
		}
	}
}


