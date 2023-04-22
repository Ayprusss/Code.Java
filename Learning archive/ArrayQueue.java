public class ArrayQueue<E> implements Queue2<E>{

    // implementation of a rear; first implementation of an ArrayQueue.
    private E[] elems;

    private int rear;

    @SuppressWarnings( "unchecked" )
    public ArrayQueue(int size) {
        this.elems =  (E[]) new Object[size];
        this.rear = -1;
    }
    public boolean isEmpty() {
        return rear == 0;
    }

    public void enqueue(E o) {
        rear ++;
        elems[rear] = o;
        
    }

    public E dequeue() {
        E tmp = elems[0];

        for (int i = 1; i < rear; i ++) {
            elems[i - 1] = elems[i];
        }
        rear --;

        return tmp;
    }
}
