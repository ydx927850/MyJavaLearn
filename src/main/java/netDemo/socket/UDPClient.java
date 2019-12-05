package netDemo.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        //客户端向服务端发送数据
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] sent = "hello world".getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(sent,sent.length,inetAddress,65001);
        datagramSocket.send(packet);
        //接收信息
        byte[] data = new byte[1024];
        //新建接收信息的packet
        DatagramPacket revPacket = new DatagramPacket(data,data.length);
        datagramSocket.receive(revPacket);
        String content = new String(revPacket.getData(),0,revPacket.getLength());
        System.out.println(content);
    }
}
