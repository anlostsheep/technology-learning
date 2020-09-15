package com.lostsheep.technology.learning.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * <b><code>ClientSocketTest2</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/16 10:04.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class ClientSocketTest2 {

    public static void main(String[] args) {
        try {
            SocketChannel client = SocketChannel.open();
            client.connect(new InetSocketAddress("127.0.0.1", 9999));
            client.configureBlocking(false);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(line.getBytes().length);

                byteBuffer.put(line.getBytes());
                byteBuffer.flip();

                client.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
