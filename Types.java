import java.util.Date;

public class Types {
    // to learmn with vairables and constants, primitive and reference types, casting, numbers strings and arrays and reading input
    //first; variables/
    public static void main(String[] args) {
        int age = 30, temperature = 20; // can declare a variable on the same line but it ugly; nice to just declare on seperate lines
        age = 35; 
        int myAge = 30;
        int herAge = myAge;
        System.out.println(herAge);


        byte age = 30;
        int viewsCount = 123_456_789; //like the commas in docs, we can use underscores for every three digits
        long viewCount = 3_123_456_789L; // suffix of 'L' placed at the end of a Long value. Java automatically identifies anything as an integer, so L distinguishes that it's different. (it's a long)
        float price = 10.99F; //just like representing a number as a long, we add a F suffix to identity a flaot
        char letter = 'A'; // only represents one character; string would represent a word or sentence
        boolean isEligible = false;
        //primitive types:
            //stores different values
            //byte, short, int, long, float, double, char, boolean
        // reference types:
            //stores complex objects:
                //data, mail messages.
            
            byte age = 30;
            //for a reference type...
            Date now = new Date();
            now.getTime();
            System.out.println(now); // will print the time of the machine. 
        
    }
}

//primitive types: