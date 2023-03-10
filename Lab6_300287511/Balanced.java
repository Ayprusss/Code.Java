public class Balanced {
    
    public static boolean algo1( String s) {

        int curly = 0;
        int square = 0;
        int round = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            switch(c) {

            
            case '{':
                curly++;
                break;
            case '}':
                square --;
                break;
            case '[':
                square ++;
                break;
            case ']':
                square --;
                break;
            case '(' :
                round ++;
            case ')':
                round --;
            }
        }
        return curly == 0 && square == 0 && round == 0;

    }

    public static void main( String[] args ) {
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) );
        }
    }
}