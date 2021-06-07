package com.lostsheep.technology.learning.http.client.okhttp;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <b><code>OkHttpController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/6/2
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
@Slf4j
@RestController
@RequestMapping("/okhttp")
public class OkHttpController {

    @GetMapping("/news")
    public ResponseEntity<String> getNews(String url) {
        AtomicReference<String> result = new AtomicReference<>();

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(6000L, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                log.error("请求 url:{} 失败", call.request().url(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                result.set(Objects.requireNonNull(response.body()).string());
            }
        });

        return ResponseEntity.ok(result.get());
    }

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build();

        Response response = client.newCall(request).execute();
        String result = response.body().string();
        log.info("{}", result);
    }
}
