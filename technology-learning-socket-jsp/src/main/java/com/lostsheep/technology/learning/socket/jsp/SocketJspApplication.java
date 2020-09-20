package com.lostsheep.technology.learning.socket.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <b><code>SocketJspApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/18 13:52.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@EnableAsync
@SpringBootApplication
public class SocketJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketJspApplication.class, args);
    }
}
