public class Strings {
    public static void main(String[] args) {
        String message = new String("Hello World!"); // this method is actually redundant in Java; there is a better and more efficient way to use this. You don't need to initialize it like with the new function; it's an exception for a reference type.
        String message2 = "Hello World"; //Strings are reference types in Java; they are not primitive types so they are a more complex variable than anything. but they can be initialized more like a primitive type.
        System.out.println(message);// hello world is a string; more specifically is a string literal. the string has a value

        // you can concantenate or join in a string with another with the plus sign:
        String message3 = "Hello World" + "!!";
            //string is a class; has many functions that we can grab using the dot(.) operator 
        message.endsWith("!!"); //used to determine if a string ends with a certain character or strings of characters. 
            //returns a boolean value.
        
            message.startsWith(); // checks if the string itself starts with a certain character or string of characters.
            message.length(); //determines how long the string is based on its characters
            message.indexOf("H"); //returns the index or position of a character at which exists in the string itself. if it DNE, then java will return -1.
            message.replace("!", "*"); // has two arguments, first one identifies what we want to be replaced, and the second argument determines what we want to replace the first argument.
                    //technically; the "!" is a parameter, the "*" is an argument
                // this function does not modify the string itself, it makes a new copy of the string.
                    //STRINGS ARE IMMUTABLE; NO MATTER WHAT IT WILL NEVER AFFECT OR CHANGE AND ORIGINAL.

            message.toLowerCase(); // changes all characters in a string to lower case
            message.toUpperCase(); // changes all characters in a string to upper case
            message.trim(); // basically cuts out any white spaces in a message. if there are any spaces between the messages, they will all get cut. This is only before the string itself; doesn't affect the strings in between

    }
}
