public class ITIStringBuffer {


    private SinglyLinkedList<String> bufferList; // private instance variable for the StringBuffer.
    // we already know that we're messing with strings, so it should be ok to automatically have it for Strings

    //private String finalMessage;// potentially using this as the private variable


    public ITIStringBuffer() {
        this.bufferList = new SinglyLinkedList<String>();


        //throw new UnsupportedOperationException( "replace with your implementation" );
    }

    public ITIStringBuffer(String  firstString) {

        this.bufferList = new SinglyLinkedList<String>();

        this.bufferList.addFirst(firstString);
        // adding in the first element into the list. 
        //throw new UnsupportedOperationException( "replace with your implementation" );
    }

    public void append(String nextString) {
        
        this.bufferList.add(nextString);
        //throw new UnsupportedOperationException( "replace with your implementation" );
    }

    public String toString(){

        int stringLen = 0;

        
        // for the toString(); I simply followed the instructions of how a String would 
        for (String s: bufferList) { // this implementation is instructed to be used in order to optimize the code.
                stringLen += s.length();
                //any other implementation; like using get(s) would up the time complexity to O(n^2);
                    //that will drop marks; don't do that!!!!!
        }

        char[] finalChars = new char[stringLen];

        int m = 0;
        for (String a: bufferList) {
            char[] tempArray = a.toCharArray();

            System.arraycopy(tempArray, 0, finalChars, m, tempArray.length);
            m += tempArray.length;
        }

        String finalString = new String(finalChars);

        return finalString;
        //throw new UnsupportedOperationException( "replace with your implementation" );
    }

}