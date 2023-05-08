package com.lostsheep.technology.learning.http.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * <b><code>OkhttpConfigTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/21.
 *
 * @author dengzhen
 * @since technology-learning
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OkhttpConfigTest {

    @Test
    public void testConnection() {
        OkHttpClient client = new OkHttpClient.Builder()
                // 连接超时时间(socket 连接)
                .connectTimeout(5, TimeUnit.SECONDS)
                // 读取超时时间
                .readTimeout(10, TimeUnit.SECONDS)
                // 写入超时时间
                .writeTimeout(10, TimeUnit.SECONDS)
                // 重试
                .retryOnConnectionFailure(true)
                .build();
    }

    public static void main(String[] args) {
        int i = -1 << 29;
        int c = i | 0;
        int CAPACITY = (1 << 29) - 1;
        System.out.println(CAPACITY);

        int ca = c & CAPACITY;
        System.out.println(ca);
    }
}
