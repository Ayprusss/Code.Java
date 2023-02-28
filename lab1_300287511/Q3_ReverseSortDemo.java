
public class Q3_ReverseSortDemo {
    
    public static void main(String[] args) {
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'}; // characters have a hierarchy in system; certain characters have a greater value over other characters. think of A = 1 and z = 26
        reverseSort(unorderedLetters);
        for (int i = 0; i < unorderedLetters.length; i++) {
            System.out.println(unorderedLetters[i]);
        }
    }

    //method that sorts a char array into its reverse alphabetical order 
    public static void reverseSort(char[] values) { // Reverse means that it goes from greatest to smallest; 
        // your code here 

        int x, y, smallIndx; // iteration of integer variables to mmanipulate the list.
        char tempVal;

        for (x = 0; x < values.length - 1; x ++) { // iterating through the list until the second last index; going through the numbers in order to find the greatest index.
            smallIndx = x; // smallIndx calls for the smallest index through a forward order. 
            for (y = x + 1; y < values.length; y ++) { // y is called for the index at front; and goes through to scan and identify if the value ahead; also in forward order. 
                if (values[y] > values[smallIndx]) { // checking if the value of the scanned secion is greater than the first called for value. If it's greater, then the value is swapped with SmallIndx
                    smallIndx = y;
                }
            }

            tempVal = values[smallIndx]; // temporary value would be equal to the biggest character of the array.
            values[smallIndx] = values[x]; 
            values[x] = tempVal;
        }
            
    }
}
