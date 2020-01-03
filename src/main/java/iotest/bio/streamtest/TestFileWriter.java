package iotest.bio.streamtest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("./file/chinatest.txt");
            writer = new FileWriter("./file/out.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int b=0;
        try {
            assert reader != null;
            assert writer != null;
            while ((b=reader.read()) != -1) {
                writer.write((char) b);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
