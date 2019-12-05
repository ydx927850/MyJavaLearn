package netDemo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.chrono.IsoEra;

public class CalculateLength extends Thread{
    private Socket socket;

    public CalculateLength(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取输入输出流
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            //通过输入流读取信息，输入到控制台上
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String content = new String(bytes,0,length);
            System.out.println(content);
            //向客户端回复信息
            outputStream.write(String.valueOf(content.length()).getBytes());
            //关闭输入输出流、socket
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
