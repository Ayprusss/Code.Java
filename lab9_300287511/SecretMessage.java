import java.io.*;

public class SecretMessage {

    public static void encrypt( String inputFile, String outputFile, int key ) throws IOException, FileNotFoundException {

        InputStreamReader input = null;
		OutputStreamWriter out = null;
        
        File insertFile = new File(inputFile);
        InputStream f = new FileInputStream(insertFile);
        input = new InputStreamReader(f);


        BufferedReader lineRead = new BufferedReader(input);
        char[] buffer = new char[256];
        
        int capacity = 0;
        lineRead.read(buffer);
        input.close();
        for (int b = 0; b < buffer.length; b ++) {
            if (buffer[b] != '\u0000') {
                capacity ++;
            }
        }
        int[] vals = new int[capacity];

        for (int a = 0; a < capacity; a ++) {
            vals[a] = Integer.valueOf(buffer[a]) + key;
        }

        String message = new String("");

        for (int c = 0; c < capacity; c ++) {
            message = message + Character.valueOf((char) vals[c]);
        }

        System.out.println(message);
        out = new OutputStreamWriter(new FileOutputStream(outputFile));

        out.write(message);

        out.close();
    }
    
	
	public static void decrypt( String inputFile, String outputFile, int key ) throws IOException, FileNotFoundException {
        
        InputStreamReader input = null;
		OutputStreamWriter out = null;
        
        File insertFile = new File(inputFile);
        InputStream f = new FileInputStream(insertFile);
        input = new InputStreamReader(f);

        BufferedReader lineRead = new BufferedReader(input);
        char[] buffer = new char[256];

        int capacity = 0;
        lineRead.read(buffer);
        input.close();
        for (int b = 0; b < buffer.length; b ++) {
            if (buffer[b] != '\u0000') {
                capacity ++;
            }
        }
        int[] vals = new int[capacity];
        
        for (int a = 0; a < capacity; a ++) {
            vals[a] = Integer.valueOf(buffer[a]) - key;
        }

        String message = new String("");

        for (int c = 0; c < capacity; c ++) {
            message = message + Character.valueOf((char) vals[c]);
        }

        System.out.println(message);
        out = new OutputStreamWriter(new FileOutputStream(outputFile));

        out.write(message);

        out.close();


    }

    public static void main( String[] args ) {

        if ( args.length != 4 ) {
            System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
        }

		if(args[0].equals("encrypt")){

		
            try {
                encrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
		}
		else if(args[0].equals("decrypt")){

		
            try {
                decrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
        }
		else{
			System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
		}
        
    }
}