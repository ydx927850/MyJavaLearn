package netDemo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建socket，绑定监听端口
        ServerSocket serverSocket = new ServerSocket(65000);
        //死循环，一直监听
        while(true){
            Socket socket = serverSocket.accept();
            //接收客户端消息后，执行业务
            new CalculateLength(socket).start();
        }
    }
}
