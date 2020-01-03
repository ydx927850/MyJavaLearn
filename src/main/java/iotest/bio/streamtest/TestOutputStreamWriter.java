package iotest.bio.streamtest;

import java.io.*;

/**
 * 把字节输出流转换为字符输出流
 * demo:把GBK编码的文件转问UTF-8编码的输出
 */
public class TestOutputStreamWriter {
    public static void main(String[] args) {
        String srcFile = "./file/gbk.txt";
        String desFile = "./file/utf8.txt";
        try{
            //按照GBK编码读原来的文件，转换输入流
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(srcFile),"GBK");
            //转换输出流，默认UTF-8编码
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(desFile));
            int len;
            char[] data = new char[1024];
            while((len = inputStreamReader.read(data))!=-1){
                outputStreamWriter.write(data,0,len);
            }
            inputStreamReader.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
