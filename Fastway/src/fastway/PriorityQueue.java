package fastway;


//make sample pair class.
class Pair{
	
	private Node n;
	private int weight;
	
	public Pair() {} //default constructor
	
	public Pair( Node n, int wieght){ //constructor
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
		//this.n.showNInfo();
		System.out.println("weight : "+this.weight);
	}
	
}



public class PriorityQueue extends Heap {
	
	public PriorityQueue(){}// constructor
	
	public boolean PQIsEmpty() {
		return HIsEmpty();
	}
	public void PEnqueue(Pair p) {
		HInsert(p);
	}
	
	public Pair PDequeue() {
		return	HDelete();
	}
	
}



class Heap{
	
	final static int HEAPMAX = 100; //#of pair that can inserted in array
	private static int numOfData;
	
	static Pair[] heapArr; 
	
	//priority compare function.
	//if p1 has higher priorities , return true else return false
	//Pair the has smaller weight has higher priority
	private boolean PriorityComp(Pair p1, Pair p2) {
		if(p1.getWeigth() < p2.getWeigth())
			return true;
		return false;
	}
	
	
	public Heap(){ //constructor
		numOfData = 0;
		heapArr = new Pair[HEAPMAX];
	}
	
	public boolean HIsEmpty() {
		if(numOfData == 0)
			return true;
		return false;
	}
	

	//find index of parent, child pair in the heap.
	private int GetParentIDX(int idx) { return idx/2; }
	private int GetLChildIDX(int idx) { return idx*2; }
	private int GetRChildIDX(int idx) { return idx*2+1;}
	
	
	// find pair that has higher priority between two childen pair
	int getHiPriChildIDX(int idx) {
		//if it has no child pair
		if(GetLChildIDX(idx)>numOfData) return 0; // heap[0] has no element
		//if it has one child pair
		else if(GetLChildIDX(idx) == numOfData)
			return GetLChildIDX(idx);
		else {
			//if left child has higher priority
			if(PriorityComp(heapArr[GetLChildIDX(idx)], heapArr[GetRChildIDX(idx)])) {
				return GetLChildIDX(idx);
			}else {
				return GetRChildIDX(idx);
			}
		}
	}

	public void HInsert(Pair p) {
		int idx = numOfData+1;
		
		while(idx != 1) {
			//if p has higher priority
			if(PriorityComp(p, heapArr[GetParentIDX(idx)])) {
				heapArr[idx] = heapArr[GetParentIDX(idx)];
				idx= GetParentIDX(idx); //swap with parent pair
			}else {
				break;
			}
			
			numOfData ++;
			heapArr[idx] = p;
		}
	}
	
	//has to be fixed.
	public Pair HDelete() {
		int parentIdx = 1; // root idx
		int childIdx;
		
		Pair return_data = heapArr[1]; //pop
		Pair last_data = heapArr[numOfData]; //last child data
		
		while((childIdx = getHiPriChildIDX(parentIdx)) != 0) {
			
			if(PriorityComp(last_data, heapArr[childIdx]))
				break;
			else {
				heapArr[parentIdx] = heapArr[childIdx];
				parentIdx = childIdx;
			}
		}
		
		heapArr[parentIdx] = last_data;
		numOfData --;
		
		return return_data;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}