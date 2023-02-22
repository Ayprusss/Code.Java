public class Arithmetic extends AbstractSeries {

    private int a = 0;
    private int b = 1; 
    // instance variables

    public double next() {
        a = a + b;
        b = b + 1;

        return a;
        // implement the method
    }
}