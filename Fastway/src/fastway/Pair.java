package fastway;


class Pair{   
   
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
      System.out.print("weight : "+this.weight);
   }
}


class Node {
   
   //static final int numOfNode = 10;   //setting #of Nodes(const variable) --> move to main class
   private int idxnum;   //index in array
   //private Node next;
   private String location_name;
   
   public Node() {} //default constructor
   
   public Node(int idxnum){ //constructor
      this.idxnum = idxnum;
      this.location_name = "location : "+this.idxnum;
   }
   
   public Node(int n, String lname) {//constructor
      this.idxnum = n;
      this.location_name = lname;
   }

   public void showNInfo() { //showing information of node.
      System.out.println("location name: "+this.location_name);
   }
   
   public String getLName() {//get location name
      return this.location_name;
   }
   
   public void setLname(String location_name) {
	   this.location_name = location_name;
   }
   
   public int getIdx() {//get index in array
      return this.idxnum;
   }
   
   public void setIdx(int idxnum) {
	   this.idxnum = idxnum;
   }
   /*
   public Node getNext() {
	   return next;
   }

   public void setNext(Node next) {
	   this.next = next;
   }*/
   
}
