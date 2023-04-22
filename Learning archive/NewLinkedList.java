public class NewLinkedList<E> implements List<E> {
    

    //implementation of the LinkedList; this is a SinglyLinkedList; 

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;
    public NewLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }


    public int indexOf(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        Node<E> p = head;
        
        int count = 0;
        while (p.value != elem ) {
            p = p.next;
            if (count > size()) {
                return -1; 
            }
            count++;
        }
        return count;
    }

    
    public E set(E elem) { // do this later.
        return null;
    }

    public boolean contains(E elem) {

        int value = indexOf(elem);

        if (value == -1) { // value does not exist;
            return false;
        }
        else if (value <= size()) {
            return true;
        }

        return false;

    }

    public E get(int index) {
        
        Node<E> p = head;
        for (int i = 0; i < index; i ++) {
            p = p.next;
        }

        return p.value;
    }

    public void add(int index, E elem) {
        if (isEmpty()) {
            addFirst(elem);
        }
        Node<E> p = new Node<E>(elem, null);
        Node<E> marker = head;
        for (int i = 0; i < index - 1; i ++) {
            marker = marker.next;
        }
        marker.next = p.next;
        marker.next = p;
        size++;
    }

    public void add(E elem){ // assume it is adding to the back of the list
        if (isEmpty()) {
            addFirst(elem);
        }
        Node<E> p = new Node<E>(elem, null);

        Node<E> mark = head;

        while (mark.next != null) {
            mark = mark.next;
        }
        mark.next = p;

        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> p = head;
        E elem;
        int count = 0;
        while (count + 1 != index) {
            p = p.next;
            count++; // puts the head right before the element that would be removed.
        }

        elem = p.next.value;
        p.next.value = null;
        p.next = p.next.next;
        size--;
        return elem;
    }

    public boolean remove(E o) {

        if (o == null) {
            throw new NullPointerException();
        } 

        Node<E> p = head;
        while (p.next.value != o) {
            if (p.next == null) {
                return false;
            } else {
            p = p.next;
            }
        }

        size--;
        Node<E> remElem = p.next;
        p.next = p.next.next;
        return true;
        
     }

    public void addFirst(E o) {
        if (o == null) {
            throw new NullPointerException();
        }
        Node<E> p = new Node<E>(o, null);
        head = p;
    }
    
    
    public int lastIndexOf(E o) {
    int lastIndex = 0;
    int count = -1; 
    Node<E> p = head;
    
    if (o == null) {
        throw new NullPointerException();
    }

    while (count < size()) {
        p = p.next;
        if (p.value == o) {
            lastIndex = count + 1;
        }
        else {
            count++;
        }
    }

    return lastIndex;
    }

    
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }


    // functions to be implemented in the LinkedList class

}