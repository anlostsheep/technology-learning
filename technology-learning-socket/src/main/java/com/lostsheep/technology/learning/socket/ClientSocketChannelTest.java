package com.lostsheep.technology.learning.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * <b><code>ClientSocketChannelTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/16 17:52.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class ClientSocketChannelTest {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

            while (!socketChannel.finishConnect()) {
                Thread.yield();
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("往服务端发送：");

            String message = scanner.nextLine();
            ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes());
            while (writeBuffer.hasRemaining()) {
                socketChannel.write(writeBuffer);
            }

            System.out.println("服务端响应：");
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            while (socketChannel.isOpen() && socketChannel.read(readBuffer) != -1) {
                if (readBuffer.position() > 0) {
                    break;
                }
            }

            readBuffer.flip();
            byte[] content = new byte[readBuffer.limit()];
            readBuffer.get(content);

            String response = new String(content);
            System.out.println(response);

            scanner.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
