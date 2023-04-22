public class DoublyLinkedList<E> implements List<E>{
	
	private static class Node<T> {
		private T value;
		private Node<T> previous;
		private Node<T> next;
		private Node( T value, Node<T> previous, Node<T> next ) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}
	
	
	private Node<E> head;
	private int size;
	
	
	public DoublyLinkedList(){
		head = new Node<E> ( null, null, null );
		head.previous = head.next = head;
		size = 0;
	}
	
	
	public void add( int index, E elem ) {
		Node<E> p = getNode(index);
		Node<E> newNode = new Node<E>(elem, p.previous, p);
		p.previous = newNode;
		newNode.previous.next = newNode;
		size++;
	}
	
	public  void add( E elem ){
		head.previous = head.previous.next = new Node<E>(elem, head.previous, head);
		size++;
	}

	public E remove( int index ) {
		Node<E> p = getNode(index);
		p.previous.next = p.next;
		p.next.previous = p.previous;
		size--;
		return p.value;
	}
	
	public boolean remove( E o ) {
		Node<E> p = getFirstNode(o);
		if ( p == null )
			return false;
		p.previous.next = p.next;
		p.next.previous = p.previous;
		size--;
		return true;
	}
	
	public E get( int index ) {
		return getNode(index).value;
	}
	
	public E set( int index, E element ) {
		getNode(index).value = element;
		return element;
	}
	
	public int indexOf( E o ) {
		int index = 0;
		Node<E> p = head.next;
		while ( p != head ){
			if ( ( p.value == null && o == null ) || ( p.value != null && p.value.equals(o) ) )
				return index;
			p = p.next;
			index++;
		}
		return -1;
	}
	
	public int lastIndexOf( E o ) {
		int index = size-1;
		Node<E> p = head.previous;
		while ( p != head ){
			if ( ( p.value == null && o == null ) || ( p.value != null && p.value.equals(o) ) )
				return index;
			p = p.previous;
			index--;
		}
		return -1;
	}
	
	public boolean contains( E o ) {
		return getFirstNode(o) != null;
	}
	
	public Node<E> getNode( int index ){
		if ( index < 0 || index >= size )
			throw new IndexOutOfBoundsException();
		Node<E> p;
		if ( index < size / 2 ){
			p = head.next;
			for (int i = 0; i < index; i++)
				p = p.next;
		}
		else{
			p = head.previous;
			for (int i = size-1; i > index; i--)
				p = p.previous;
		}
		return p;
	}
	
	public Node<E> getFirstNode( E o ){
		Node<E> p = head.next;
		while ( p != head ){
			if ( ( p.value == null && o == null ) || ( p.value != null && p.value.equals(o) ) )
				return p;
			p = p.next;
		}
		return null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean equals( Object o ) {
		if ( o == null )
			return false;
		if ( !( o instanceof DoublyLinkedList ) )
			return false;
		@SuppressWarnings("unchecked")
		DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
		if ( this.size() != other.size() )
			return false;
		for( 
			Node<E> p = this.head.next, q = other.head.next;
			p != this.head;
			p = p.next, q = q.next
		) {
			if ( p.value == null && q.value != null )
				return false;
			if ( !p.value.equals(q.value) )
				return false;
		}
		return true;
	}
	
	public String toString() {
		if ( size == 0 )
			return "[]";
		if ( size == 1 )
			return "[" + head.next.value + "]";
		String result = "[" + head.next.value;
		Node<E> p = head.next.next;
		while( p != head ){
			result += ", " + p.value;
			p = p.next;
		}
		return result + "]";
	}
	
}