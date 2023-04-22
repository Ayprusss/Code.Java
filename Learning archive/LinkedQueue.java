public class LinkedQueue<T> implements Queue2<T> {

    //Queue implmentation with the use of Linked Elements; Linked nodes.

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;

        }
    }

    private Elem<T> front; // or rear?
    private Elem<T> rear;

    public LinkedQueue(T value, Elem<T> next) {
        front = rear = new Elem<T>(value, next);
    }
    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(T o) {
        Elem<T> temp;
        if (isEmpty()) {
            temp = new Elem<T>(o, null);
            front = rear = temp;
        }
        else {
            temp = new Elem<T>(o, null);
            rear.next = temp;
            rear = temp;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        else {
            T temp = front.value;
            front.value = null;
            front = front.next;
            return temp;

        }
    }
    
}
