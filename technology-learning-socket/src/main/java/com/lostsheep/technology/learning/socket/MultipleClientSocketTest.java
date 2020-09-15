package com.lostsheep.technology.learning.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * <b><code>MutipleClienSocketTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/16 00:24.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class MultipleClientSocketTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();

                bufferedWriter.write(line);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
