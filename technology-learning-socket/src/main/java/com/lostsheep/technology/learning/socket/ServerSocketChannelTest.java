package com.lostsheep.technology.learning.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * <b><code>ServerSocketChannelTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/16 9:53.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class ServerSocketChannelTest {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel != null) {
                    System.out.println("new connection coming...");
                    
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (socketChannel.read(byteBuffer) != -1) {
                        byteBuffer.flip();
                        System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                        byteBuffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
