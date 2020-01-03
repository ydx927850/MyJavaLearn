package iotest.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO服务端
 */
public class BIOServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        //接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(()->{
            while (true){
                //服务端一直监听客户端连接
                try {
                    //accept为阻塞方法，获取新的客户端连接,只有当上一个连接处理完断开后，服务端才可以获得新的客户端连接
                    Socket socket = serverSocket.accept();
                    //每一个连接都新建一个线程去处理，读取数据
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
