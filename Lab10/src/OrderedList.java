import java.util.NoSuchElementException;

public class OrderedList<E extends Comparable<E>> implements OrderedStructure{

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {
      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;
    private int size;
    private Node tail;

    // Representation of the empty list.

    public OrderedList() {
        head = tail = null;
        size = 0;
    }

    // Calculates the size of the list

    public int size() {
    	Node  p = head;
		int size = 0;
		while(p != null) {
			size++;
			p = p.next;
		}
		return size;
    }


    public Object get( int pos ) {
    	if(pos < 0 || pos > this.size())
    		throw new IndexOutOfBoundsException();
        Node j = head;
        for(int i = 0; i<pos; i++) {
        	j = j.next;
        }
        return j.value;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
    	 if(o == null) {
             throw new IllegalArgumentException();
         } 
         if (head == null) {
             head = new Node(o, null, null);  
             return true;
         }
         if (head.value.compareTo(o) >= 0) { 
         	Node newNode = new Node(o, null, head);
             newNode.next.previous = newNode; 
             head = newNode; 
             return true;
         }  
         else { 
        	 Node cursor; 
             cursor = head; 
             while (cursor.next != null &&  cursor.next.value.compareTo(o) < 0) {  
            	 cursor = cursor.next; 
             }
             Node newNode = new Node(o, null, cursor.next);
             if (cursor.next != null)  
                 newNode.next.previous = newNode;  

             cursor.next = newNode;  
             newNode.previous = cursor; 
             return true;
         }    	
    	
    	 }
    	

    //Removes one item from the position pos.

    public void remove( int pos ) {
    	Node remove;
		if(head == null)
			throw new IndexOutOfBoundsException();
		if(pos<0 || pos >= this.size())
			throw new IndexOutOfBoundsException();
		if(pos == 0) {
			remove = head;
			head = head.next;
		}
		else {
			Node p = head;
			for(int i = 0; i<pos-1; i++) {
				p = p.next;
			}
			remove = p.next;
			p.next = p.next.next;
		}
		
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
    	Node cursor;
    	Node p = other.head;
    	Node j = head;
    	while(p != null) {
    		if (j == null) {
    	        j = new Node(p.value, null, null); 
    	        p = p.next;
    	    }
    	    else if (j.value.compareTo(p.value) >= 0)  { 
    	    	Node newNode = new Node(p.value, null, head);
    	        newNode.next.previous = newNode; 
    	        j = newNode; 
    	        p = p.next;
    	    } 
    	    else  { 
    	    	cursor = j; 
    	        while (cursor.next != null && cursor.next.value.compareTo(p.value) < 0) {  
    	        	cursor = cursor.next; 
    	        }
    	        Node newNode = new Node(p.value, null, cursor.next);

    	        if (cursor.next != null)  
    	            newNode.next.previous = newNode;  

    	        cursor.next = newNode;  
    	        newNode.previous = cursor; 
    	        p = p.next;
    	    }    	
    	}
    }  

	
}