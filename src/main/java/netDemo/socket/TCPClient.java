package netDemo.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        //创建socket，指定发送地址
        Socket socket = new Socket("127.0.0.1",65000);
        //创建输入输出流，发送并接收信息
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());
        //接收应答
        byte[] rev = new byte[1024];
        int read = inputStream.read(rev);
        String content = new String(rev,0,read);
        System.out.println(content);
        //关闭资源
        inputStream.close();
        outputStream.close();
        socket.close();
    }

}
