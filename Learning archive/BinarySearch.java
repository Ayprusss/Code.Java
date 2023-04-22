public class BinarySearch {
    

    //implmentation for a binary Serach with the use of recursion.

    public static int binarySearch(int value, int[] array) { // non-recursive public method
        System.out.println("Calling binSearch(" + value + ", array; lo: 0, hi : " + (array.length - 1) + ")");
        return binSearch(value, array, 0, array.length - 1);

    }
    public static int binSearch(int value, int[] array, int lo, int hi) { // recursive private method;

        //base case: value not found;

        if (lo > hi) {
            return -1;
        }

        //Base case; value is found;
        int middle = (lo + hi) / 2; //int division btw; no decimal. whole numbers
        System.out.println("middle is: " + middle);

        if (value == array[middle]) {
            return middle;
        }

        //general case;

        int newLo, newHi;

        if (value < array[middle]) {
            newLo = lo;
            newHi = middle - 1;
        } else {
            newLo = middle + 1;
            newHi = hi;
        }

        System.out.println("Calling binSearch(" + value + ", array; lo: " + newLo + ", hi : " + newHi + ")");
        return binSearch(value, array, newLo, newHi);
    }


    public static void main(String[] args) {
        int[] array = {1, 3,10,20,25,50,55,60,70,80,90,95,100};
        int index = binarySearch(3, array);
        System.out.println("index reeturned is: " + index);


        System.out.println("----------------");


        index = binarySearch(3, array);

        System.out.println("Index return is: " + index);
    }
}
