public class NewQueue<E> implements Queue2<E> {
    

    private static class Node<E> {
        Node<E> next;
        E value;

        private Node(E value, Node<E> next) {
            this.next = next;
            this.value = value;
        }
    }

    private Node<E> front;
    private Node<E> rear;


    public NewQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == rear;
    }


    public void enqueue(E o) {
        Node<E> temp = new Node<E>(o, null);
        if (isEmpty()) {

            front = rear = temp;
        }
        else {
            rear.next = temp;
            rear = rear.next;
        }
    }

    public E dequeue() {

        if (isEmpty()) {
            return null;
        }
        E temp = front.value;
        front = front.next;
        return temp;
    }

}