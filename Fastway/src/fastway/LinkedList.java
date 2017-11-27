package fastway;
import java.util.*;

public class LinkedList {
	//private Node head;
	private int size;
	private java.util.LinkedList<Pair> linkedlist = new java.util.LinkedList<Pair>();
	private int cur; // index of current element ( used to search list)
	
	//initialize
	public LinkedList() { 	//default constructor
		//head = null;
		size = 0;
		cur = 0;
	}
	
	public LinkedList(Pair start) { //constructor with start node
		//head  = start;
		linkedlist.add(start);
		size = 1;
		cur = 0;
	}
	
	public void Insert(Pair p) {
		linkedlist.add(p);
		size++;
	}
	
	public void Insert(String node, int weight) {
		linkedlist.add(new Pair(node, weight));
		size++;
	}
	
	public void delete(Pair x) {	//will not be used
		linkedlist.remove();
	}

	public void print() {  //print all element of list
		
		for(int i = 0; i<linkedlist.size(); i++) {
			linkedlist.get(i).showPair();
		}
	}
	
	//search method
	//before starting search, initialize cur to 0
	public void searchInitiallize() { 
		this.cur = 0;
	}
	
	public boolean search(Pair pair) { //search node
		
		if(this.cur >= size) { //when finish searching
			return false;
		}
		else {
			pair.setPair(linkedlist.get(cur).getNode(), linkedlist.get(cur).getWeigth());
			cur ++;
			return true;
		}
		
	}
}
