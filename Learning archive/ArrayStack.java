public class ArrayStack implements Stack {
    
    // implementation using TOP as the first empty cell of the arrayStack.



    //private variables

    private Object[] arrayStack;
    private int top; 


    public ArrayStack(int capacity) {
        this.arrayStack = new Object[capacity]; // would change depending on what elements you want to store within the stack itself. if it's Strings, you can cast String[] onto the new Object[capacity]. or int[]; double[]. Anything you want.
        this.top = 0;   // also may change depending on how you want to use top. if you want it to represent the first element of the array; then you make it (-1). If you want to make it represent the first empty cell of the array; you make it (0).

    }


    public Object peek() {

        if (isEmpty()) {
            return null;
        }
        return arrayStack[top - 1]; // implementation also differs when you want to implement top differently.
        // return arrayStack[top]; this implementation would be used if you're making top the first empty cell of the array.
    }

    public boolean isEmpty() {
        return (top == 0); //again; difference in implementation; it's either the top represents the top or bottom of the stack. And again, it would matter on how you want top to represent.
        //again; if it's for the first empty cell; return (top == 0);
        // if it's for the first element; return (top == -1);
    }

    public Object pop() {
        Object tmp = arrayStack[--top];
        arrayStack[top] = null;// used to scrub the memory
        return tmp; // by doing top--; you decrement top AND you return the element at the index of top--. This helps to save time. Any other implementation would ask for otherwise.
    }

    public Object push(Object o) {
        arrayStack[top++] = o; // implementation again changes depending on how you want to implement this. 
        top ++;

        return null; // idk why it doesn't allow me to make the push() method null; cause I don't think you're supposed to return anything???
    }

}
