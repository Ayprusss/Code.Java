public interface Queue {
    public abstract boolean isEmpty();
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
}
