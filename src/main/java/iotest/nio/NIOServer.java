package iotest.nio;

import org.springframework.expression.spel.ast.Selection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO的服务端
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        //创建selector
        Selector selector = Selector.open();
        //打开通道,并配置为非阻塞的
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        //将通道注册到selector上
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket serverSocket = socketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);
        serverSocket.bind(inetSocketAddress);

        while(true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();
                    // 服务器会为每个新连接创建一个 SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);
                    // 这个新连接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    SocketChannel socketChannel1 = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(socketChannel1));
                    socketChannel1.close();
                }
                iterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel channel) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while(true){
            buffer.clear();
            int read = channel.read(buffer);
            if(read==-1){
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for(int i=0;i<limit;i++){
                dst[i] = (char) buffer.get(i);
            }
            stringBuilder.append(dst);
            buffer.clear();
        }
        return stringBuilder.toString();
    }
}
