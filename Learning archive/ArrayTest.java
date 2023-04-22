public class ArrayTest {
    private static ArrayQueue2<String> queue;
    
    

    public static void main(String[] args) {
        queue = new ArrayQueue2<String>();


        for (int i = 0; i < 9; i ++) {
            queue.enqueue2(Integer.toString(i));
        }

        for (int j = 0; j < 4; j ++) {
            queue.dequeue2();
        }

        for (int i = 0; i < 4; i ++) {
            queue.enqueue2(Integer.toString(i));
        }

        String msg = "Final Queue is: [ ";
        while (!queue.isEmpty()) {
            msg = msg + queue.dequeue() + ", ";
        }


        System.out.println(msg);
        System.out.println("Answer should be: [ 12, 13, 14, 15 ,16, 17, 18, 19, 20, 21, 22, 23, 24, 25]");
    }
}
