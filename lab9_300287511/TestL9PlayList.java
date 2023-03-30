import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

import java.io.*;

public class TestL9PlayList {


    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested


    private static double grade = 0.0;

    private static String testInputFileName = "testInFile.txt";
    private static String testOutputFileName = "testOutFile.txt";

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for PlayList (out of a possible 4.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @After
    public void cleanUp() throws IOException{
        new File(testInputFileName).delete();
        File outfile = new File(testOutputFileName); 
        if (outfile.exists()) {
            outfile.delete();
        }
    }

    @Test
    public void testGetSongsFromFile2(){
        try{
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            out.write("Is There Anybody Out There?:Pink Floyd:The Wall\nMosh:Eminem:Encore\n");
            out.close();

            PlayList result = PlayList.getSongsFromFile(testInputFileName);

            Song song = new Song("Is There Anybody Out There?", "Pink Floyd", "The Wall");
            Song song2 = new Song("Mosh", "Eminem", "Encore");
            PlayList expected = new PlayList();
            expected.addSong(song);
            expected.addSong(song2);

            String failMsg = "PlayList GetSongsFromFile with two song. Expected:\n" + expected.toString();
            failMsg += "; Actual:\n" + result.toString();

            assertTrue(failMsg, expected.equals(result));
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testGetSongsFromFileMultiple(){
        try{
            String fileSongs = "";
            for(int i = 0; i < 10; i++){
                fileSongs += "Song" + i + ":" + "Artist" + i + ":" + "Album" + i + "\n";
            }

            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            out.write(fileSongs);
            out.close();

            PlayList result = PlayList.getSongsFromFile(testInputFileName);
            PlayList expected = new PlayList();
            for(int i = 0; i < 10; i++){
                Song song = new Song("Song" + i, "Artist" + i, "Album" + i);
                expected.addSong(song);
            }

            String failMsg = "PlayList GetSongsFromFile with multiple songs. Expected:\n" + expected.toString();
            failMsg += "; Actual:\n" + result.toString();

            assertTrue(failMsg, expected.equals(result));
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception e){
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testGetSongsFromFileMultiple");
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testWriteOneSongToFile(){
        try{

            Song song = new Song("A Dream Within A Dream", "Alan Parsons Project", "Tales Of Mystery & Imagination");

            PlayList playlist = new PlayList();
            playlist.addSong(song);

            playlist.writeSongsToFile(testOutputFileName);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));

            String line = bufferedReader.readLine();
            if(line != null){
                if(!song.toString().equals(line)){
                    String expected = "Expected: " + song.toString() + " Actual: " + line;
                    fail("Different song written to file. " + expected);
                }
            }else{
                fail("No line in the output file.");
            }
            grade += 1;
            bufferedReader.close();
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception e){
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testWriteMultipleSongsToFile");
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testWriteMultipleSongsToFile(){
        try{

            PlayList playlist = new PlayList();
            for(int i = 0; i < 10; i++){
                Song song = new Song("Song" + i, "Artist" + i, "Album" + i);
                playlist.addSong(song);
            }

            playlist.writeSongsToFile(testOutputFileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));

            String line = bufferedReader.readLine();
            for(int i = 0; i < 10; i ++){
                if(line != null){
                    Song song = new Song("Song" + i, "Artist" + i, "Album" + i);
                    if(!song.toString().equals(line)){
                        String expected = "Expected: " + song.toString() + " Actual: " + line;
                        fail("Different songs at line " + (i+1) + "." + expected);
                    }
                    line = bufferedReader.readLine();
                }else{
                    fail("Not enough songs read from file. Read only " + (i+1) + " lines");
                }
            }

            grade += 1;
            bufferedReader.close();
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception e){
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testWriteMultipleSongsToFile");
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public static void main(String[] args) {
        TestUtils.runClass(TestL9PlayList.class);
    }

}
