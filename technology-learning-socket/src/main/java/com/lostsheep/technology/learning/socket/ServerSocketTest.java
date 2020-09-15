package com.lostsheep.technology.learning.socket;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <b><code>ServerSocketTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/15 23:20.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            int processors = Runtime.getRuntime().availableProcessors();

            ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
            ThreadFactory threadFactory = threadFactoryBuilder.setDaemon(true)
                    .setNameFormat("demo-pool-%d")
                    .setUncaughtExceptionHandler((t, e) -> System.out.println(e))
                    .build();

            ThreadPoolExecutor executor = new ThreadPoolExecutor(processors,
                    2 * processors + 1,
                    60,
                    TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(100),
                    threadFactory,
                    new ThreadPoolExecutor.AbortPolicy());

            while (true) {
                Socket clientSocket = serverSocket.accept();

                Runnable runnable = () -> {
                    BufferedReader bufferedReader;
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("客户端发送:" + line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                executor.submit(runnable);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
