public class Mystery { // example of implementation of a stack.
    
    public static void main (String[] args) {
        

        Stack<String> = new StackImplementation<String>();

        for (int i = 0; i < args.length(); i ++) {
            stack.push(args[i]);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
