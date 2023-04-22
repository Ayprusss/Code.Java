public class QueueTest {

    

    private NewQueue<String> queue = new NewQueue<String>();

    private String toString() {

        String message = "[";

        while (!queue.isEmpty()) {
            String l = queue.dequeue();
            message = message + l + ", ";
        }
        message = message + " ]";

        System.out.println(message);
    }

    public static void main(String[] args) {
        
    }
}
