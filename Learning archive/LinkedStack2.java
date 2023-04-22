public class LinkedStack2<T> implements Stack2<T> {
    
    //this implementation is used to implement a Stack with the use of Generics. 


    private static class Elem<T> {
        private T value;
        private Elem<T> next;
        private Elem<T> prev;

        private Elem(T value, Elem<T> next, Elem<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    
    private Elem<T> top;
    public LinkedStack2() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T object) {
        Elem<T> node = new Elem<T>(object, null, null);
        if (isEmpty()){
            top = node;
        } else {
            top.next = node;
            top.prev = top;
            top = top.next;
        }
    }

    public T pop() {
        T elem = top.value;
        top = top.prev;
        return elem;
    }


    public T peek() {
        return top.value;
    }

    
}
