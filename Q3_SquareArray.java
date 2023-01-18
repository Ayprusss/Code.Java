public class Q3_SquareArray{

    public static int[] createArray(int size) {
        int[] mainArray;
        mainArray = new int[size];
        for(int i = 0; i < mainArray.length; i ++){
            mainArray[i] = i * i;
        }
        return mainArray;
    }

    public static void main (String[] args) {
        //write code here

        int [] arrayToPrint = createArray(13);

        for(int j = 0; j < arrayToPrint.length; j ++) {
            System.out.println("the square of " + j + " is:" + arrayToPrint[j]);
        }
    }
}