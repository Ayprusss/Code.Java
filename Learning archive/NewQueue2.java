public class NewQueue2<E> implements Queue2<E>{
    

    private static class Node<E> {
        private Node<E> next;
        private E value;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public NewQueue2() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(E o) {
        Node<E> elem = new Node<E>(o, null);
        if (isEmpty()) {
            head = tail = elem;
        } else {
            tail.next = elem;
            tail = elem;
        }
    }

    public E dequeue() {
        E elem = null;
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            elem = head.value;
            head = head.next;

        }

        return elem;
    }
}
