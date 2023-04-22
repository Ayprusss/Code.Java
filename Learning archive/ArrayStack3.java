public class ArrayStack3 implements Stack {
    

    //this implementation uses the bottom implementation of an ArrayStack; 

    //private variables

    private Object[] arrayStack;
    private int bottom;

    private static final int DEFAULT_CAPACITY = 100;
    public ArrayStack3() {
        this.arrayStack = new Object[DEFAULT_CAPACITY];
        this.bottom = 0; // represents the bottom element of the stack; top element is at the index 0.
    }

    public boolean isEmpty() {

        return bottom == 0;
    }

    public Object peek() {
        return arrayStack[0];
    }

    public Object pop() {
        Object tmp = arrayStack[0];

        for (int a = 1; a < bottom; a ++) {

            arrayStack[a - 1] = arrayStack[a];
        }

        return tmp;
    }

    public Object push(Object o) {
        for (int a = 0; a < bottom; a ++) {
            Object tmp = arrayStack[a + 1];
            arrayStack[a + 1] = arrayStack[a];
        }


        return null;
    }


}
