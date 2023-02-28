public class EscapeSequence {//how to include special characters into the string
    public static void main(String[] args) {
        String message = "Hello \"Anthony\" "; //if we want to add quotation marks to our string, since we are using them in java to identify the string, it causes problems/
            //using the backslash(\) before the quotation marks sets them as prefixes so that they would be ignored in the string
        
        
            //Important; backslash
        // i.e. you want to look for a directory search thingamajiggy;
            // c:\Windows\...
           // string message = "c:\"; """ //this is not good; java thinks that the backslash is trying to cut us away from the double quote; so the string never closes
            
           //to solve the problem:
           String message2 = "c:\\Windows\\...";
                //when printed out to see the actual terminal code; we would only see one backslash when printed.
                    // Thus; print = c:\Windows\...
            
            //backslash n: slices string into another line; new line.
            String message3 = "you are a \n beautiful man: ";
            //prints out like" you are a
                            // beautiful man:

            //backslash t: adds a tabbed space in between the string and its two different components
            String message4 = "my god I want to \t kiss you! and \"fuck\" you!!!";
            //prints out like: "my god I want to    kiss you!"
            
        System.out.println(message);
        System.out.println(message2);
        System.out.println(message3);
        System.out.println(message4);
    }
}
