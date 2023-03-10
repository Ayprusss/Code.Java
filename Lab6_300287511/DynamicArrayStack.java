public class DynamicArrayStack<E>  implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement
    private int capacity;

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {

        if (capacity > DEFAULT_INC) {
            elems = (E[]) new Object[capacity];
        }
        else {
            elems = (E[]) new Object[DEFAULT_INC];
        }
        
        top = 0;
        this.capacity = capacity;
        // Your code here.
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
        E[] temp;
        if (top == elems.length - 25) {
            int oldLen = elems.length;
            capacity =  capacity - DEFAULT_INC;
            temp = (E[]) new Object[capacity];

            for (int a = 0; a < oldLen; a ++) {
                temp[a] = elems[a];
            }

            elems = (E[]) new Object[capacity];

            for (int b = 0; b < oldLen - 1; b ++) {
                elems[b] = temp[b];
            }
        }


        E element = elems[--top];

        elems[top] = null;

        return element;
        // Your code here.
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        E[] temp;
        if (top == capacity) {

            int oldLen = elems.length;
            capacity = capacity + DEFAULT_INC;
            temp = (E[]) new Object[capacity];
            
            for (int a = 0; a < oldLen - 1; a ++) {
                temp[a] = elems[a];
            }

            elems = (E[]) new Object[capacity];

            for (int b = 0; b < oldLen - 1; b ++) {
                elems[b] = temp[b];
            }

        }
        

        elems[top ++] = element;

        // Your code here.
    }

    public void clear() {
        while (!isEmpty()) {
            pop(); 
        }
        // Your code here.
    }

    
}
