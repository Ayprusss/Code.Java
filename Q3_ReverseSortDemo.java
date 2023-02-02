

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



        int x, y, smallIndx;
        char tempVal;

        for (x = 0; x < values.length - 1; x ++) {
            smallIndx = x;
            for (y = x + 1; y < values.length; y ++) {
                if (values[y] > values[smallIndx]) {
                    smallIndx = y;
                }
            }

            tempVal = values[smallIndx];
            values[smallIndx] = values[x];
            values[x] = tempVal;
        }
        /*Arrays.sort(values);

        int j = 0;
        char[] tempList;
        tempList = new char[values.length];

        for (int i = values.length -1 ; i > -1; i--) { // basically putting in a double- for loop going two ways. one going up and the main one going down; basically, the main for loop calls for the values in reverse order while the other for loop helps give the index for the temporary list.
            tempList[j] = values[i]; 
            j ++;
        } // by doing so; the tempList has the characters in reverse, but in the tempList, it's ordered in a forward way.  [a,b,m,u,z]
//                                                                                                                         [0,1,2,3,4]
        for(int b = 0; b < values.length; b ++) {  //Now, all that needs to be done is to alter the original list. Using the original list and a for loop, the original list can now insert the new characters in the reverse sorted order.
            values[b] = tempList[b];               // Since the tempList now goes in a forward order; one for loop is all that's needed.
        }
        //for DEBUG:   
        System.out.println(Arrays.toString(values)); */
            
    }
}
