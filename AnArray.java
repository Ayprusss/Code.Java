import java.util.Arrays;

public class AnArray {
    public static void main(String[] args) {
        int[] arrayToPrint = populateArray(10);
        System.out.println(Arrays.toString(arrayToPrint));
        for(int i = 0; i < arrayToPrint.length; i ++){
            System.out.println("index:" + i + "; value at index: " + arrayToPrint[i]);
        }
    }

    //method to populate array with the index of the element * 100

    public static int[] populateArray(int size) {
        int[] anArray;
        anArray = new int[size];
        for(int i = 0; i < anArray.length; i ++){
            anArray[i] = i * 100;
        }
        return anArray;
    
    }
}
