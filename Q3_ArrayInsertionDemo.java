public class Q3_ArrayInsertionDemo {
    public static int[] InsertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
        //your code here
        int[] afterArray = new int[beforeArray.length + 1];

        afterArray[indexToInsert] = valueToInsert; // value inside the new list is now inserted with the wanted value.

        for (int a = 0; a < indexToInsert; a ++ ) { //forloop is made to only go up to the new value's index. By doing so, this avoids having to code new indexes or to find a complicated solution to append the values after the list
            afterArray[a] = beforeArray[a];
        }

        if (beforeArray.length > indexToInsert){ // length of the beforeArray is higher than the index; meaning that there are values that still need to be appended 
            for(int b = indexToInsert + 1; b < afterArray.length ; b ++) { // variable b is to pick up from the index position and end at the end of the after array. 
                afterArray[b] = beforeArray[b - 1];
            }

            return afterArray;
        }
        else {
            return afterArray;
        }
    }

    public static void main(String[] args) {
        int[] beforeArray = new int[]{1,5,4,7,9,6};
        
        int indexToInsert = 3;
        int valueToInsert = 15;
        
        System.out.println("Array before insertion:");
        for (int i = 0; i < beforeArray.length; i ++ ) {
            System.out.println(beforeArray[i]);
        }

        int[] endArray = InsertIntoArray(beforeArray, indexToInsert, valueToInsert);

        System.out.println("Array after insertion of " + valueToInsert +" at position " + indexToInsert);
        for (int j = 0; j < endArray.length; j ++) {
            System.out.println(endArray[j]);
        }
    }
}
//your code here