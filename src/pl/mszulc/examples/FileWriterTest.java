package pl.mszulc.examples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: tomek
 * Date: 1/7/12
 */
public class FileWriterTest {

    private String filePath;

    public FileWriterTest(String filePath) {
        this.filePath = filePath;
    }

    public void doWriteToFile(String testString) {

        FileWriter fstream;
        try {
            fstream = new FileWriter(filePath);
            BufferedWriter out = new BufferedWriter(fstream);
            for (int i = 0; i < 20; i++) {
                System.out.println(String.format("I'm the bold %s thread and I write text %s to a file! Timestamp %s ",
                        Thread.currentThread().getName(), testString, new Date().getTime()));

                out.write(testString + "\n");
                out.flush();
                //Thread.sleep(1000);

            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

    }


}