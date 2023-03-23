public class FullStackException extends IllegalStateException {
    
    public FullStackException(int capacity) {
        super("the array selected is full and cannot be pushed any further than the array's capacity of " + capacity);
    }
}
