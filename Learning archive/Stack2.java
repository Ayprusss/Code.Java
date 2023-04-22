public interface Stack2<E>  { // this is using a generic; so the class would call for the stack at a specified type.


    public abstract boolean isEmpty();
    public abstract void push(E elem);
    public abstract E pop();
    public abstract E peek();
}
