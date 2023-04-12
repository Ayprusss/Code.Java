import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null, null, null); // dummy node!
        head.prev = head.next = head;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {


        //private variables
        private Node<E> current = head;
        private int index = 0; // used to count the index of the SinglyLinkedList;
        // since we are calling for the index of the element when we next() is called; the value of the index has to be one ahead of the actual head itself.
        //therefore, we start the index off at 0; even though the Node<E> current is at the head dummy node which makes the index -1;
            // if nextIndex was called; then we call for the index of the Node ahead of the current;

        public boolean hasNext() {
            return (current.next != head);
        }

        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index ++;
            current = current.next;
            
            return current.value;
        }

        public int nextIndex() {
            if ((!hasNext()) && (index - 1 == size())) { // if curent.next == head; we're at the end of the line; also if the index - 1 (which goes to the position of the current node) is equal to the size; then we reset the index for it to go back
            //to the lists' starting position.
                index = 0;
            }
            return index;
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public Iterator<E> iterator(int nextIndex) {
        if (nextIndex >= size()) {
            throw new IndexOutOfBoundsException("index is out of bounds.");
        }
        Iterator<E> listIte = new LinkedListIterator();

        int i = 0;
        while (i < nextIndex) {
            listIte.next();
            i ++;
        }

        return listIte;
    }

    public Iterator<E> iterator(Iterator<E> other) {

        Iterator<E> listIte = other;   
        
        return listIte;
    }

    public int size() {
        return size;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.value;
    }

    public void addFirst(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> second = head.next;

        head.next = new Node<E>(elem, head, second);
        second.prev = head.next;

        size++;
    }

    public void add(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> before = head.prev, after = head;

        before.next = new Node<E>(elem, before, after);
        after.prev = before.next;

        size++;
    }
    
}
