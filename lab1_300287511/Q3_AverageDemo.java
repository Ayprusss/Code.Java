public class Q3_AverageDemo {
    public static void main(String[] args) {
        double[] valuesArray;
        valuesArray = new double[]{100.0, 34.0, 72.0, 56.0, 82.0, 67.0, 94.0};
        System.out.println("The average is: " + calculateAverage(valuesArray));
    }

    //method that calculates the average of the numbers in an array
    public static double calculateAverage(double[] values) {
        double result;

        double sum = 0.0; // double variable in order to find the total sum of the array. Helps 
        for (int i = 0; i < values.length; i ++) { // for looop to pass through and iterate all values within the array. this is to be added to the sum variable.
            sum = sum + values[i];  //calling back to ITI 1120 and python; this method allows for the sum variable to add the values from the array. by calling for the sum twice, this means that the original value is being added with a new value. 
        }

        result = sum / values.length; // since it's the average, the function simply divides it by the number of values within the valuesArray. this is done by calling for values.length
        return result;
    }
}
