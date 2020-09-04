package com.lostsheep.technology.learning.http.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>Application</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/4 14:51.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.lostsheep.technology.learning.http.client")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
