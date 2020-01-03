package iotest.bio.streamtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流，可以把字节输入流转换为字符输入流
 * demo：键盘输入转换为字符输出
 */
public class TestInputStreamReader {
    public static void main(String[] args) {
        try{
            //把键盘输入转换为字符输入
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            //把普通的reader包装为BufferReader
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                if ("exit".equals(line)){
                    System.exit(1);
                }
                System.out.println("输出内容："+line);
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
