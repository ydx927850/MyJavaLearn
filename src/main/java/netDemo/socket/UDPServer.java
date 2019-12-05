package netDemo.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        //UDP 使用的socket
        DatagramSocket datagramSocket = new DatagramSocket(65001);
        byte[] rev = new byte[1024];
        DatagramPacket revPacket = new DatagramPacket(rev,rev.length);
        //接收信息
        datagramSocket.receive(revPacket);
        String content = new String(revPacket.getData(),0,revPacket.getLength());
        System.out.println(content);
        //响应客户端
        byte[] sentContent = String.valueOf(content.length()).getBytes();
        DatagramPacket sentPacket = new DatagramPacket(sentContent,sentContent.length,revPacket.getAddress(),revPacket.getPort());
        datagramSocket.send(sentPacket);
    }
}
