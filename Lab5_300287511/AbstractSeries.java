public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        double [] takeArray = new double[k];
        
        for (int a = 0; a < k; a ++) {
            takeArray[a] = next();
        }
        return takeArray;
        
    }
}