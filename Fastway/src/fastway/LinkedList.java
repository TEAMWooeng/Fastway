package fastway;
import java.util.*;

public class LinkedList {
	private Node head;
	private int size;
	private java.util.LinkedList<Pair> linkedlist = new java.util.LinkedList<Pair>();
	private int cur; // index of current element ( used to search list)
	
	//initialize
	public LinkedList() { 	//default constructor
		head = null;
		size = 0;
		cur = 0;
	}
	
	public LinkedList(Node start) { //constructor with start node
		head  = start;
		size = 1;
		cur = 0;
	}
	
	public void insert(Pair p) {
		linkedlist.add(p);
		size++;
	}
	
	public void Insert(Node n, int weight) {
		Pair newPair = new Pair(n, weight);
		linkedlist.add(newPair);
		size++;
	}
	
	public void delete(Pair x) {	//will not be used
		linkedlist.remove();
	}

	public void print() {  //print all element of list
		head.showNInfo();
		System.out.print(":");
		for(int i = 0; i<linkedlist.size(); i++) {
			linkedlist.get(i).showPair();
		}
	}
	
	public void searchInitiallize() { //before starting search, initialize cur to 0
		this.cur = 0;
	}
	
	public boolean search(Pair p) { //search node
		
		if(this.cur >= size) { //when finish searching
			return false;
		}
		else {
			p = this.linkedlist.get(cur);
			cur ++;
			p.showPair();
			return true;
		}
		/*
		Iterator<Pair> iterator = linkedlist.iterator(); // create iterator
		if(iterator.hasNext()) {			 // if exists next Pair, put it into p and return true
			p = (Pair) iterator.next();
			p.showPair();
			return true;
		}
		else
			return false;
			
			*/
	}
}
