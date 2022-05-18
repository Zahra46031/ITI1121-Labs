public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
    	if(capacity < DEFAULT_INC) {
            elems = (E[]) new Object[DEFAULT_INC];
        }
        else {
        	elems =(E[]) new Object[capacity];
        }
        top = 0;
        
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        E saved = elems[--top];

        elems[top] = null;

        if (this.getCapacity()-top >= DEFAULT_INC) {
            E[] temp = (E[]) new Object[this.getCapacity() - DEFAULT_INC];

            for (int i = 0; i < this.top; i++) {
                temp[i] = elems[i];
            }

            elems = temp;
        }

        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push(E element) {
        if (top>=this.getCapacity()) {
            E[] temp = (E[]) new Object[this.getCapacity() + DEFAULT_INC];

            for (int i = 0; i<this.top; i++) {
                temp[i] = elems[i];
            }
            elems = temp;
        }
        elems[top++] = element;
    
    }

    @SuppressWarnings( "unchecked" )
    public void clear() {
    	elems = (E[]) new Object[DEFAULT_INC];
    	top = 0;
    }

}