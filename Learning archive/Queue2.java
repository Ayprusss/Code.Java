public interface Queue2<E> {
    //interface for Queue2 will be used for Generics; 
    public abstract boolean isEmpty();
    public abstract void enqueue(E o);
    public abstract Object dequeue();
}
