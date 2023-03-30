/**
 * @author Marcel Turcotte, Universite d'Ottawa/University of Ottawa
 */

public class Run {

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "*Name: Anthony Le                                          *" );
        System.out.println( "*Student ID: 300287511                                     *" );
        System.out.println( "*Course Code and lab section: ITI 1121 B-02; lab C-02.     *" );
        System.out.println( "*                                                          *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void main( String[] args ) {

        if ( args.length != 2 ) {
            System.err.println( "Usage: java Run infile outfile" );
            System.exit( 1 );
        }

        displayStudentInfo();

        PlayListManager manager = new PlayListManager( args[ 0 ], args[ 1 ] );
        manager.copySongListFromFileToFile();
    }
}
