public class IfDemo {
    public static void main(String[] args) {
        int i = 1;
        while (i < 11) {
            if ( i%2 == 0) {
                System.out.println(i + "is Even");
            }
            else {
                System.out.println(i + "is Odd");                
            }
        i ++;
        }
    }
}