package fastway;

class Pair{   
   
   private String location;
   private double weight;
   
   public Pair() {
	   location = "empty";
	   weight = 0;
   } //default constructor
   
   public Pair(String lname, double weigth) {
	   location = lname;
	   this.weight = weigth;
   }
   
   public double getWeigth() {
      return this.weight;
   }
   
   public String getNode() {
	   return location;
   }
   public void showPair() {
      System.out.println("location: "+location+" , weight : "+weight);
   }
   
   public void setPair(String lname , double weight) {
	   location = lname;
	   this.weight = weight;
   }
}

