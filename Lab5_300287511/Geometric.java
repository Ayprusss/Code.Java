
public class Geometric extends AbstractSeries {

    private double b = 0.0;
    // instance variables
    private double c = 0.0;
    public double next() {
        b = b + (1/(Math.pow(2.0, c)));
        c = c + 1;
        return b;
        // implement the method

    }
}