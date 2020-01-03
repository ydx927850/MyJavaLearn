package iotest.bio.streamtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("./file/test.txt");
            outputStream = new FileOutputStream("./file/out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int b=0;
        try {
            assert inputStream != null;
            assert outputStream != null;
            while ((b=inputStream.read()) != -1) {
                outputStream.write(b);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
