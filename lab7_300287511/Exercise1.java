import java.io.IOException;

public class Exercise1 {

    public static void throwException(int exceptionNumber) throws Exception{
        if(exceptionNumber==1){
            throw new Exception();
        }
        if(exceptionNumber==2){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(exceptionNumber==3){
            throw new IOException();
        }
        if(exceptionNumber==4){
            throw new IllegalArgumentException();
        }
        if(exceptionNumber==5){
            throw new NullPointerException();
        }
    }

    /*
        Returns the name of the exception thrown by the method throwException.
        Method that handles the exceptions thrown by the throwException method.
        
        @param exceptionNumber
        @return The exception name or "NoException" if no exception was caught.
     */
    public static String catchException(int exceptionNumber){
        try{
            throwException(exceptionNumber);
        }
        

        catch (NullPointerException e) {
            String error = new String("NullPointerException");
            System.out.println("the exception type is: "+ error + " the exceptionNumber is: " + exceptionNumber);
            return "NullPointerException";
        }
        catch (IllegalArgumentException e) {
            String error = new String("IllegalArgumentException");
            System.out.println("the exception type is: "+ error + " the exceptionNumber is: " + exceptionNumber);
            return "IllegalArgumentException";
        }
        catch (IOException e) {
            String error = new String("IOException");
            System.out.println("the exception is: "+ error + " the ExceptionNumber is: " + exceptionNumber);
            return "IOException";
        }
        catch (ArrayIndexOutOfBoundsException e) {
            String error = new String("ArrayIndexOutOfBoundsException");
            System.out.println("the exception type is: "+ error + " the exceptionNumber is: " + exceptionNumber);
            return "ArrayIndexOutOfBoundsException";
        }

        catch (Exception e) {
            String error = new String("Exception");
            System.out.println("the exception type is: "+ error + " the exceptionNumber is: " + exceptionNumber);
            return "Exception";
        }
        // YOUR CODE HERE
        return "NoException";
    }

    public static void main(String[] args) {
        int exceptionNumber=(int)(Math.random()*5) + 1;
        String exceptionName = catchException(exceptionNumber);
        System.out.println("Exception number: " + exceptionNumber);
        System.out.println("Exception name: " + exceptionName);
    }

}