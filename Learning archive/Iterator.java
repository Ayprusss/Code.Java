/**
* An iterator for lists that allows the programmer to traverse the
* list.
*/
public interface Iterator<E> {
    
    /**
* Returns the next element in the list. This method may be called
* repeatedly to iterate through the list.
*
* @return the next element in the list.
* @exception NoSuchElementException if the iteration has no next element.
*/
    public abstract E next();

    
    /**
* Returns <tt>true</tt> if this list iterator has more elements when
* traversing the list in the forward direction. (In other words, returns
* <tt>true</tt> if <tt>next</tt> would return an element rather than
* throwing an exception.)
*
* @return <tt>true</tt> if the list iterator has more elements when
* traversing the list in the forward direction.

*/
public abstract boolean hasNext();
}
