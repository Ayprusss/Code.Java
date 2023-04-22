public class ArrayStack2 implements Stack {
    

    //this implementation uses the top (instance vairble) as the first element in the stack.


    //private instance variables
    private Object[] arrayStack;
    private int top;
    private static final int DEFAULT_CAPACITY = 100;



    public ArrayStack2() {
        this.arrayStack = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public ArrayStack2(int capacity) {
        this.arrayStack = new Object[capacity];
        this.top = -1;
    }


    public Object peek() {
        return arrayStack[top];
    }

    public Object push(Object o) {
        arrayStack[top] = o;
        top ++;

        return null;
    }

    public Object pop() {
        Object tmp = arrayStack[top];
        arrayStack[top] = null;

        top --;

        return tmp;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
