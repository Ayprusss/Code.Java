import java.util.Scanner;

public class Q6 {
    
    public static void main(String[] args) {

        double[] classMarks;
        classMarks = new double[10];
        
        Scanner scanMark = new Scanner(System.in);
        for (int i = 0; i < 10; i ++) {
            System.out.print("What is student no." + (i + 1) +"'s mark?: ");
            double myMark = scanMark.nextDouble();
            classMarks[i] = myMark;
    
        }

        scanMark.close();

        double average = calculateAverage(classMarks);
        System.out.println("The class average is: " + average + ".");
        
    
        double median = calculateMedian(classMarks);
        System.out.println("the class median is: " + median + ".");

        int numOfFailed = calculateNumberFailed(classMarks);
        
        if(numOfFailed > 0){
            System.out.println(numOfFailed+" students have failed the class");
        }
        else {
            System.out.println("no one failed the class.");
        }

        int numOfPassed = calculateNumberPassed(classMarks);
        if(numOfPassed > 0) {
            System.out.println(numOfPassed+" students have passed the class");
        }
        else {
            System.out.println("no one passed the class.");
        }
    }

    public static double calculateAverage(double[] notes) {
        double sum = 0.0;
        for (int a = 0; a < notes.length; a ++) {
            sum = sum + notes[a];
        }

        double average;
        average = sum / notes.length;
        return average;
    }

    public static double calculateMedian(double[] notes) {
         //shows that the list of marks is even
        
        int num1 = (notes.length/2) - 1;//find value one above; since there are ten marks, there's no definite median, so you grab the value one before that
        int num2 = (notes.length/2) + 1;// '' and the one after that

        double median = (notes[num1] + notes[num2]) / 2;// sum of them and divide them by 2

        return median;
    }

    public static int calculateNumberFailed(double[] notes) {// for loop to look through each mark/
        int count = 0;
        for (int a = 0; a < 10; a ++) {
            double mark = notes[a];// if the mark is less than 50, a counter comes up. A student failed the class
            if (mark < 50){
                count ++;
            }

        }
        return count;
    }

    public static int calculateNumberPassed(double[] notes) {
        int count = 0;
        for (int a = 0; a < 10; a ++) {// for loop to look through each mark/
            double mark = notes[a];
            if (mark > 50) {// if the mark is more than 50, a counter comes up. A student passed the class
                count ++;
            }

        }
        return count;
    }
}

