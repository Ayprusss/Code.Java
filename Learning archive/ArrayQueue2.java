public class ArrayQueue2<E> implements Queue2<E>{
    
    // implementation of a circular queue; 
    private E[] elems;

    private int front;
    private int rear;
    private static final int MAX_QUEUE_SIZE = 10;
    @SuppressWarnings("unchecked")
    public ArrayQueue2() {
        this.elems = (E[]) new Object[MAX_QUEUE_SIZE];
        this.front = 0;
        this.rear = 0;
    }
    

    public boolean isEmpty() {
        return front == rear;
    }

    private int size = 0;

    public void enqueue(E o) {
            rear ++;
            elems[rear] = o;
        if (rear == MAX_QUEUE_SIZE) { // implementation #1; use without the % modulo;
            rear = 0;
        }
        size ++;
    }

    public E dequeue() {
        E tmp = elems[front]; // implementation #1; use without the % modulo;
        elems[front] = null;
        if (front == MAX_QUEUE_SIZE) {
            front = 0; 
        } else {
            front++;
        }
        size--;
        return tmp;
    }

    public void enqueue2(E o) { // this is using the second implementation of a circular Queue; 
        elems[rear] = o;
        rear = (rear + 1) % MAX_QUEUE_SIZE;
        size++;
    }

    public E dequeue2() { // this is using the second implementation of a circular Queue;
        E tmp = elems[front];
        elems[front] = null;
        front = (front + 1) % MAX_QUEUE_SIZE;
        
        size--;
        return tmp;
    }

    public boolean isEmpty2() {
        // if we use the sentinal value of -1 represented in rear to show that the queue is empty.
        return rear == 0;
    }

    public boolean isFull() {
        return rear + 1 == front;
    }

    public E peek() {
        return elems[front];
    }
}
