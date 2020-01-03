package iotest.bio.streamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节流读中文会乱码
 */
public class TestFileInputStream {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./file/test.txt");
//            inputStream = new FileInputStream("./file/chinatest.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int b = 0;
        try{
            assert inputStream != null;
            while ((b = inputStream.read())!=-1){
                System.out.println((char)b);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
