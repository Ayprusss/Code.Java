import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

import java.io.*;


public class TestL9SecretMessage
{

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    private static String testInputFileName = "testInFile.txt";
    private static String testOutputFileName = "testOutFile.txt";
    
    
    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for SecretMessage (out of a possible 6.0): " + grade);

        System.out.println(TestUtils.DIV);

    }
    
    @After
    public void cleanUp() throws IOException {
        new File(testInputFileName).delete();
        File outfile = new File(testOutputFileName); 
        if (outfile.exists()) {
            outfile.delete();
        }
    }
    
    @Test
    public void testEncryptSecretMessageKey1() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Test the first secret message ?");
            outputStreamWriter.close();
            SecretMessage.encrypt(testInputFileName, testOutputFileName, 1);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Encrypt with key 1", "Uftu!uif!gjstu!tfdsfu!nfttbhf!@", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testEncryptSecretMessageKey1");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    @Test
    public void testEncryptSecretMessageKey3() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Using Java 8 is fun!");
            outputStreamWriter.close();
            SecretMessage.encrypt(testInputFileName, testOutputFileName, 3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Encrypt with key 3", "Xvlqj#Mdyd#;#lv#ixq$", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testEncryptSecretMessageKey3");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    @Test
    public void testEncryptSecretMessageKey5() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Encapsulation, Abstraction, Inheritance, Polymorphism");
            outputStreamWriter.close();
            SecretMessage.encrypt(testInputFileName, testOutputFileName, 5);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Encrypt key 5: Encapsulation, Abstraction, Inheritance, Polymorphism", "Jshfuxzqfynts1%Fgxywfhynts1%Nsmjwnyfshj1%Utq~rtwumnxr", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testEncryptSecretMessageKey5");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    @Test
    public void testDecryptSecretMessageKey2() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Mggr\"ecno\"cpf\"ycuj\"{qwt\"jcpfu");
            outputStreamWriter.close();
            SecretMessage.decrypt(testInputFileName, testOutputFileName, 2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Decrypt key 2", "Keep calm and wash your hands", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testDecryptSecretMessageKey2");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    @Test
    public void testDecryptSecretMessageKey4() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Irgv}txih$wigvix$qiwweki>$neze$mw$e{iwsqi");
            outputStreamWriter.close();
            SecretMessage.decrypt(testInputFileName, testOutputFileName, 4);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Decrypt with key 4", "Encrypted secret message: java is awesome", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println(TestUtils.EXCEPTION_DELIM);
            System.out.println("Exception thrown in test method testDecryptSecretMessageKey4");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    @Test
    public void testDecryptSecretMessageKey6() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(testInputFileName));
            outputStreamWriter.write("Ju&tuz&omtuxk&znk&}gxtotmy&ot&\u007fu{x&lkkjhgiq&lorky");
            outputStreamWriter.close();
            SecretMessage.decrypt(testInputFileName, testOutputFileName, 6);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(testOutputFileName)));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            assertEquals("Decrypt with key 6", "Do not ignore the warnings in your feedback files", line);
            grade += 1;
        } catch(UnsupportedOperationException e){
            fail(e.toString());
        } catch (Exception ex) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Exception thrown in test method testDecryptSecretMessageKey6");
            ex.printStackTrace();
            fail(ex.toString());
        }
    }
    
    public static void main(String[] array) {
        TestUtils.runClass(TestL9SecretMessage.class);
    }
    
}

