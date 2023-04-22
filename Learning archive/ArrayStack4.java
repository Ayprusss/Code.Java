public class ArrayStack4<E> implements Stack2<E> {
    

    //private variables

    private E[] arrayStack;
    private int top;

    @SuppressWarnings( "unchecked");
    public ArrayStack4() {
        this.arrayStack = (E[]) new Object[69];

        this.top = 0; 
    }


    @SuppressWarnings( "unchecked" );
    public ArrayStack4(int capacity) {
        this.arrayStack = (E[]) new Object[capacity];
        this.top = 0;
    }
}
