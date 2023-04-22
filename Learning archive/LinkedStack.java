public class LinkedStack implements Stack {


    //this Stack implementation is done with the use of a LinkedStack.

    private static class Elem {
        private Object value;
        private Elem next;

        private  Elem(Object value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }
    private Elem top;

    public LinkedStack() {
        top = new Elem(null, null);
    }
    //private variables; 
    
    public boolean isEmpty() {
        return top == null;
    }
    public void push (Object o) {
        Elem p = new Elem(o, top);

        top = p;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.value;
    }

    public Object pop() {
        Object p = top.value;
        top.value = null;
        top = top.next;
        return p;
    }


    public String toString() {
        String res = "[";
        
        if (top != null) {
            Elem p = top;

            res = res + p.value.toString();
            p = p.next;

            while (p != null) {
                res = res + p.value.toString();

                p = p.next;
            }
        }

        res = res + "]";
        return res;
    }

}


