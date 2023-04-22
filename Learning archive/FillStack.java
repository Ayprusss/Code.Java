public class FillStack {
    //implementation for recursion:


    public static void call(int i) {
        try {
            System.out.println("Depth: " + i);
            call(i + 1); // breaking recursive method usefulness rules
        } catch (Throwable e) {
            System.out.println("\n Error: " + e.getClass() + " at depth " + i);
        }
    }


    public static void main (String[] args) {
        call(0);
    }
}
