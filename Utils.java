/**
 * this class represents the required utilities to be used in the method of FindAndReplace.
 * <p>
 * 
 * @author  Anthony Le
 */

public class Utils {

    /** 
         * findAndReplace method is used to search for certain strings within an existing array, and return a brand new array with certain changes to the elements. These elements are observed in the other parameters; 
         * 
         * @param in; is the existing array of strings; this array is not to be changed at all.
         * 
         * @param what ; is the array with the strings that are to be replaced. The strings that will replace this string in the 'in' array are index-correspondent to the other array(with) ;
         * 
         * @param with; is the array that contains the strings that will replace the selected elements in the in list. These elements are index-correspondent to the 'what' array, so the elements within this list will replace the element that is corresponding to the same index. 
         * <p>
         * @return will return an array known as 'out' that is a copy of the in array with the necessary and included changes. 
         */

    public static String[] findAndReplace(String[] in, String[] what, String[] with) {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if t  he pre-conditions are satistified
        

        /** these sets of if statements are used to verify all the parameters to assure that not only are the lists not null, but the elements itself. Through a set of nested if and else statements, accompanied by a few for loops to check every element, this ultimately verifies the method can go through with the replacment.
         * if not, the Boolean valid will become false, and will ultimately return a null value.
         */
        if (in == null || what == null || with == null) {
            valid = false;
        } else {
            if (what.length != with.length) {
                valid = false; 
            }
            
            for (int a = 0; a < in.length; a ++) {
                if (in[a] == null) {
                    valid = false;
                }
            }
            for (int b = 0; b < what.length; b ++) {
                if (what[b] == null) {
                    valid = false;
                }
            }
            for (int c = 0; c < with.length; c ++) {
                if (with[c] == null) {
                    valid = false;
                }
            }
            // more or less 16 lines missing
        }

        /** 
         * <p>
         * if the valid boolean passes; the if statement will allow for a set of for loops and nested loops to go through to allow the copying of the new elements.
         * the first for loop is done to copy the in array into the out array, before any modifications to the out array are done. 
         * the nested loops help to manage and identify and 'with', 'out' 'what' loops. the first for loop accesses the string of the out array to help with the identification of the element.
         * the nested loop will then go through the 'what' list and would initialize a string variable to the second string. if the first string and the second string are equal to each other in value, the 'out' array is reinitialized with the new value, and a boolean marker is changed to true.
         * if the boolean marker turns to true; the change would be made, and when the second for loop breaks, an if statement will check if the boolean has been marked true, which will in turn, break the nested for loop.
         * <p>
         * this is done so that there are no double replacements. 
         * 
         * finally, the out list is returned. 
         */
        if (valid) {
            out = new String[in.length];
            for (int i = 0; i < in.length; i++) {
                out[i] = in[i]; // copying in array into out array.
                // more or less 10 lines missing
            }
            for (int j = 0; j < out.length; j ++) {
                String char1 = out[j];
                Boolean marker = false;
                for (int h = 0; h < what.length; h ++) {
                    String char2 = what[h];
                    if (char1.equals(char2)) {
                        out[j] = with[h];
                        marker = true;
                    }
                    if (marker) {
                        break;
                    }
                }
            }
        }
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}