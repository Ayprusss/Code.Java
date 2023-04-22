public interface Stack { // interface done without any generic; so no specified return type or kind of type.
    public abstract boolean isEmpty();
    public abstract void push(Object o);
    public abstract Object pop();
    public abstract Object peek();
}
