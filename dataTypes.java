import java.awt.*;

public class dataTypes {
    
    public static void main(String[] args) {
        byte x= 1;
        byte y = x;
        x = 2; 
        System.out.println(y); // x and y are independent of each other. y keeps the value of x when it was copied. If there was a change to x, y wouldn't be affected

        Point point1 = new Point(1,1);
        Point point2 = point1; // due to the referencing and the use of the Point class, the values stay the same. if point1 is changed, point2 will also change.

        point1.x = 3; // calling class point1; looking for x value. 
        point1.y = 5;

        System.out.println(point2);
    }
}
