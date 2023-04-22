public class SinglyLinkedList<E> implements List<E> {



    private static class Node<T> { // static nested class that is used to create the nodes; these are used in the list.
        ..... // look over ijmplementation again later.
        private E value;
        private Node<E> next;
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }   


    private Node<E> head; //istance variable/


    public SinglyLinkedList() {
        head = null; //same thing as Queues and STacks; they take this instance variable of head and instantiate it to be null
    }

    public int size() { // counts how many items are in the list itself.
        int size = 0;
        Node<E> p = head; //making a cursor of type Node be equal to the head which will iterate through the list. (head contents) no manipulation of the head itself
        while ([ !=null]) {
            p = p.next;
            size ++;
        }
    }

    public boolean IsEmpty() {
        return head == null; // one line check that verifies if that head is null; meaning it has no elements.
    }

    public void AddFirst(E o ) { // in this case; head exists, but there isn't any implementation of head at the moment.
    //basicall ythe same as doing the push method on a stack. Pushes to the front of the head.
        Node<E> newNode = new Node<E>(o , null);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head; 
            head = newNode;
        }

        // just adds a new element to the front of the list instead of the last;
        // very beginning of the list.

    }

    public void add (E o) {
        // implementation to add an element to the back of the list. back of the head.
        // because there isn't a rear node to identify the last element like a queue; implementation is a basic enqueue() method'

        if ( o == null) {
            throw new NulllPointerException();
        }


        Node<E> newNode = new Node<E>(o, null);

        if (head == null) {
            head = newNode; // makes it so the NewNode is the first element; takes out the special case that the head is null (list is null)/
        } else {
            Node<E> p = head; // instantiation of node variable to cover the list (head)
            while (p.next !- null) {    // p variable will iterate through the whole list (head); we check if the next element of the list is null or not. if it isnt: we iterate; if it is/
                p = p.next;    // we make p which has the value of the p.next; meaning that the p moves through the list in the while loop.
            }
            p.next = newNode; // until the list.next is null; then we make p,next = to newNode.
        }


    }



    public E removeFirst() {
        if (isEmpty()) { // checks whether or not the list is empety in the first place. 
            throw new Exception();
        }

        E savedVaue = head.value;

        Node<E> first = head; 

        head = head.next;

        first.next = null;
        first.value = null; // memort SCRUBBING; not ENTIRELY NEEDED

        return savedValue;
    }


    public E removeLast() { // additional pre-conditions ar necessary in this case.
        if (isEmpty()) {
            throw new Exception();
        }
        // to actually remove the last element of the head; we will have to iterate through the list until we get to the last element to make it null
        // cursor cannot go all the way to end; MAJOR ISSUE; cursor has to go to the second last. the element before the element to be removed.
        // SPECIAL CASES.
        Node<E> p = head; 
        while (p.next.next != null) { // we check two elements ahead to see if it's null. that means that two elements ahead would be the last element.
            p = p.next; // this puts us one element behind the end/ p.next is the element to be null
        }
        res = p.next.value; // this is equal to the next node's value.
        p.next = null; // nullifying this element.
    }



public E removeLast() {

    if (isEmpty()) {
        throw new Exception(); // exception thrown if the list is empty in the first place/
    }
    E savedValue; // initialization of the value that will be saved;

    if (head.next == null) { // if the next element is null, meaning that there is only one element within the list;
        savedValue = head.value; // we make the first element of the head the savedValue
        head = null;    //memory Scrub it
    }

    else { // if the list is longer than that.
        Node<E> p = head; // creation of second variable to iterate through list
        while (p.next.next != null) { // while value after the other is not null
            p = p.next; // make the iteration variable go through the list by makign it equal to the next part of the node.
        }
        // when the while loop stops; you'r at the second last element; 
        Node<E> last = p.next; // this would be the last element of the ist.
        savedValue = last.value; // taking its value for memory scrubbing
        last.value = null; // making it null
        p.next = null;  // more memory scrubbing

    }

    return savedValue;

}

public boolean remove (E o ) {
    // this access elements by content.
    // returns true if o was succesfully removed and false otherwise.
    // giving an outlne of an implementation

    // 1. traversing the list

    // 2. Stopping criteria?

    // 3. removal/

    // idea of throwing exceptions in a boolean function would not make sense; just make it return false instantly. 
    if (head == null) {
        return false; 
    }

    if ( head.value.equals(o)) {// you have to check the head to see if it's equal to the desired element to be removed. Eventhough it's the first element of the list seen here. SPECIAL CASE>
        head = head.next;  // why make it equal to head.next? is that to make it null; thus forgetting about the value in general?


        // by not calling for that element; you allow for the JVM and its garbage disposal to do god's work. you don't have to!
        return true;
    }

    else {
        Node<E> p = head; // instantiation of variable to iterate throug hlist.

        while (p.next != null && !p.next.value.equals(o)) { // the next value is not null and the next value is not equal to the desired element.
            p = p.next; //iteration through the enext elements.
        }

        if (p.next == null ) // we weren't able to find the endxt element.
        return false;
        else {
            p.next = p.next.next // why this??? is this to again make it null?? // 

            // by not calling for that element; you allow for the JVM and its garbage disposal to do god's work. you don't have to!
            return true;
        }
    }
}

public E get (int pos) {
    if (isEmpty()) {
        throw new IllegalStateException();
    }
    if (pos < 0) {
        throw new IndexOutOfBoundsExceptino();
    }

    Node<E> p = head;

    for (int i = 0; i < pos; i ++ ) {
        p= p.next;
        if (p == null) { // if the element is null; you throw an exception in. 
            throw new InexOutOfBoundsException(pos);
        }
    }
    return p.value; //simple implementation to iterate through the list and to return the element
}

}