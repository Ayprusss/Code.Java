import java.util.*;

public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

    public int count(E fromElement, E toElement) {
        if (fromElement == null) { // special case already taken care of; if the fromElement is null; then then the method would return a 0; this is automatically done, so when it comes to the private method, no value of 0 will ever pass. 
            return 0;
        } else {
            int count = 0; // initialization of the int count; since there's no information that's inputed regarding the count, and because of the fact that; this instance variable meant to count for the recursive function of count;
            Node<E> pointer = this.head; // this as well to point to the lists head; we need a variable to be created to make sure to point to the head; since this SinglyLinkedList is not using a dummy node; so, pointing to the head will point to the first element.
                    // kinda redundant; because we're calling specifically for the node<E> and not for the iterator, it doesn't really help us to just specifically call for an iterator's node...

            return count(pointer,  fromElement, toElement, count);
        }
    }

    private int count(Node<E> p, E fromElement, E toElement, int count) { // private recursive method used to actually iterate (recursively) through the list. not too sure how I can implement the recursive method; BUT:
            //recursive methods call back on itself .
            // need to make sure the base cases are passed. 


            if (p.value == fromElement && p.next != null ) {
                fromElement = p.next.value;
                count++; // count of elements includes itself.
                /*if (p.value == toElement) {
                    return count;
                }*/
                if (p.value == toElement) { // this node's element is the same as the fromElement and toElement;
                    return count; 
                }else if (p.next.value == toElement ) { // checks ahead to see the next value is equal to the toElement.
                    return count + 1; 
                }else if (p.value != toElement && (p.next == null)) { // we are at the end of the list; the toElement cannot be found, so it doesn't exist; we just return the value.
                    return count + 1; 
                }
            }

            if (p.value != fromElement && p.next == null) { // element of fromElement is not in the list and the iterator made it to the end of the list.
                return 0;
            } else if (p.next == null) { // if the list is just at the end of the list in general; we make it so that it returns the count it has including an extra value. 
                return count + 1;
            }

        return count(p.next, fromElement, toElement, count);


        /*if (p.value == fromElement) { // maybe instead of returning constant methods and then returning zero at the end, I just return a single recursive method and just change the 
            fromElement = p.next.value; // just makes sure that this if statement is always triggered.
            count++;
            if (p.value == toElement) { // node is equal to the toElement; we return the OR; // this means that  the next value would be equal to null.
                return count ++;
            } else if (count == size() - 1) {
                return size();
            }
            else if (p.next.next == null && p.next.value == toElement) {
                count = count + 2;
                return count;
            }
            
        } */
        
            // we check the following cases:
                // if the node has reached the fromElement; in which we start counting:
                // if the node has reached the fromElement and the element isn't the ToElement; we continue counting until we find it otherwise. we go through the 
                
                // if the node hasn't reached the fromElement and is still searching; we simply just go through the list using the node itself.
                // also need to check if the pointer is null in the first place. I don't know how I can call for the list just yet.
            //ways we can appraoch this situation:
                // embedded if statements would be useful to make sure each condition is properly followed.
                //the use of a Boolean marker can be used to help make sure that the proper conditions are being followed.

    }
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next ) {
            this.value = value;
            this.next = next;
        }
        
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> currentIterator;

        public LinkedListIterator() {
            currentIterator = null;
        }

        public E next() {
            if(currentIterator == null) {
                currentIterator = head;
            } else {
                currentIterator = currentIterator.next;
            }
            if(currentIterator == null)
            throw new NoSuchElementException("Iterator at the end or list empty");
            return currentIterator.value;
        }

        public boolean hasNext(){
            if(currentIterator == null)
            return !isEmpty();
            else
            return (currentIterator.next != null);
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Iterator<E> nextIndex() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    private Node<E> head;
    private int size;
    private Node<E> tail;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E o) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>( o, null );
        if ( head == null ) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add( E o ) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>( o, null );
        if ( head == null ) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add( int pos, E o) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        if ( pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }


        if(pos == 0){
            addFirst( o );
        } else if(pos == size){
            add( o );
        } else  {

            Node<E> p = head;
            for(int i = 0; i < pos - 1; i++) {
                p = p.next;
            }

            p.next = new Node<E>( o, p.next );
            size++;
        }
    }

    public E removeFirst() {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        E savedValue = head.value;
        size--;
        if(size > 0){
            head = head.next;
        } else {
            head = tail = null;
        }
        return savedValue;
    }

    public E removeLast() {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        E savedValue= tail.value;

        if ( head.next == null ) {
            head = tail = null;
        } else {
            Node<E> p = head;
            while ( p.next != tail ) {
                p = p.next;
            }
            tail = p;
            tail.next = null;
        }
        size--;
        return savedValue;
    }


    public boolean remove( E o ) {

        if ( head == null )
        return false;

        if ( head.value.equals( o ) ) {
            removeFirst();
            return true;
        } else {
            Node<E> p = head;
            while ( p.next != null && ! p.next.value.equals( o ) ) {
                p = p.next;
            }
            if ( p.next == null ) {
                return false;
            } else {
                p.next = p.next.next;
                if(p.next == null) {
                    tail = p;
                }
                size--;
                return true;
            }
        }
    }

    public E get( int pos ) {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        if ( pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<E> p = head;

        for ( int i=0; i<pos; i++ ) {
            p = p.next;
        }

        return p.value;
    }


    public E remove( int pos ) {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        if ( pos < 0 || pos >= size ) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<E> toBeRemoved;

        if ( pos == 0 ) {
            return removeFirst();
        } else if (pos == size-1) {
            return removeLast();
        }
        else {
            Node<E> p = head;

            for ( int i=0; i<( pos-1); i++ ) {
                p = p.next;
            }
            toBeRemoved = p.next;
            p.next = p.next.next;
        }
        size--;
        return toBeRemoved.value;
    }


    public boolean equals(SinglyLinkedList<E> otherList){

        if((otherList == null) || (size != otherList.size()))
        return false;

        Node<E> thisCursor = head;
        Node<E> otherCursor = otherList.head;

        for(int i = 0; i < size; i++){
            if(!thisCursor.value.equals(otherCursor.value))
            return false;
            thisCursor = thisCursor.next;
            otherCursor = otherCursor.next;
        }

        return true;
    }




    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append("[");
        if(!isEmpty()){
            Node<E> cursor = head;
            res.append(cursor.value);
            while(cursor.next != null){
                cursor = cursor.next;
                res.append(" " + cursor.value);
            }
        }
        res.append("]");
        return res.toString();
    }
}
