package iotest.bio.streamtest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class TestFileReader {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("./file/gbk.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int b = 0;
        try {
            while ((b= Objects.requireNonNull(reader).read())!=-1){
                System.out.println((char)b);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
