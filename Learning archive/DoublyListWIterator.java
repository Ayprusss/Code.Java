import java.util.NoSuchElementException;


//This implementation both includes an inner and outer implementation of an iterator throught the linkedlist; 



public class DoublyListWIterator<E> implements List<E> {
    
    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> previous;

        private Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> current; // this is for the implementation without the inner class; but with this implementation, there can only exist one vairable


    public static class LinkedListIterator<T> implements Iterator<T> {
    
        private Node<T> current; // because of the private node current being inside the inner class; whenever the Iterattor() constructor method is called, it can have its own current Node; meaning we can have multiple iterators.

    
        private LinkedListIterator() 
            current = null;
        }
    
        public boolean hasNext() {
            return ((current == null && myList.head != null) // checking to see that if the current hasn't been appointed to the head of the list just yet, and that the LinkedList is not empty; thus, the head would not be equal to null.
             || (current != null && current.next != null)); // if not the first condition, we check to see whether or not the current is not equal to null while on the list, and that the next element for the iterator is not null; thus, verifies if the iterator is at the end of the list.
        }
    
        public T next() {
            if (current == null) {
                current = myList.head;
            } else {
                current = current.next;
            } 

            return current.value;
        }
    }
    public Iterator<E> iterator() { // constructor for a proper iterator to go through the list; need to practice this.
        return new LinkedListIterator<E>(this);
    }

    public DoublyListWIterator() { // make this implementation with a dummy node;
        head = new Node<E>(null, null, null);
        size = -1;
        head.next = head.previous = head;
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public E get(int index) {
        Node<E> p = head;
        for( int i = 0; i < index; i ++) {
            p = p.next;
        }

        return p.value;
    }

    public int size() {
        return size;
    }

    public int indexOf(E o) {
        Node<E> p = head;
        int count = -1;
        if (o == null) {
            throw new IllegalArgumentException();
        }
        while (p.next.value != o) {
            p = p.next;
            count++;
            if (p.next.value == null) {
                return -1;
            }
        }

        return count + 1;
    }

    public void add(E o) {
        Node<E> p = new Node<E>(o, null, null);
        if (isEmpty()) {
            head.next = p.previous;
            p.next = head.previous;
            size++;
        }
        else {
            Node<E> iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            iterator.next = p.previous;
            p.next = iterator.next.next;
            size++;
        }
    }

    public void add(int index, E o) {
        Node<E> p = new Node<E>(o, null, null);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = -1;

        Node<E> pointer = head;
        while (count != index) {
            pointer = pointer.next;
            count++;
        }
        p.next = pointer.previous;
        p.previous = pointer.previous.next;
        size ++;
    }

    public boolean contains(E o) {
        boolean marker = false;
        Node<E> p = head;

        while(p.next != head) {
            p = p.next;
            if(p.value == o) {
                marker = true;
                break;
            }
        }

        return marker;
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean remove(E o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public int lastIndexOf(E o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }


    @Override
    public E next() {
        if (current == null) {// current node has not set foot into the list itself; thus, we initiate it by making it equal to the head of the list;
            current = head;
        } else { // if it's not equal to null, that means that it's equal to another node that's on the list; so, we just move the current through the list;
            current = current.next; 
        } if (current == null) { // we check if there's an element on the list that is null. if that's the case, we've come into an error regarding the element cause we can't just return null.
            throw new NoSuchElementException();
        }
        return current.value;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    

}
