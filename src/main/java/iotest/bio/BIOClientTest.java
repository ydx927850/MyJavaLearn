package iotest.bio;

import java.io.IOError;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * BIO客户端
 */
public class BIOClientTest {
    public static void main(String[] args) {
        new Thread(()->{
            try{
                Socket socket = new Socket("127.0.0.1",3333);
                while(true){
                    try {
                        socket.getOutputStream().write((new Date() + "hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}
