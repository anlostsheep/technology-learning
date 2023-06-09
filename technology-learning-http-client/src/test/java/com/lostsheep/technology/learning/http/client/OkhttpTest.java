package com.lostsheep.technology.learning.http.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <b><code>OkhttpTest</code></b>
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
public class OkhttpTest {

    private final String url = "https://www.baidu.com/";

    @Test
    public void testGet() {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            log.info("{}", string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("userName", "zhangsan")
                .add("userPwd", "123456")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            log.info("{}", string);
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @Test
    public void testPost2() {
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
        RequestBody formBody = new FormBody.Builder()
                .add("username", "LH141310001")
                .add("password", "141310")
                .add("checkText", "7rc7")
                .add("checkCode", "7RC7")
                .add("token", "")
                .add("sms", "")
                .build();

        Request request = new Request.Builder()
                .url("https://b2b.chinalh.com/login.do")
                .post(formBody)
                .addHeader("Host", "b2b.chinalh.com")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Origin", "https://b2b.chinalh.com")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("Referer", "https://b2b.chinalh.com/login/")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .addHeader("Cookie", "JSESSIONID=D8CF742BC273618B44E07A8942923D31")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            log.info("{}", string);
        } catch (IOException e) {
            log.error("", e);
        }
    }

    @Test
    public void testPost4File() {
        OkHttpClient client = new OkHttpClient();
        File file = new File("/Users/lostsheep/Downloads/TTTTT.js");
        RequestBody fileBody = RequestBody.create(file, MediaType.parse("text/plain"));

        RequestBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userName", "zhangsan")
                .addFormDataPart("userPwd", "123456")
                .addFormDataPart("userFile", "TTTTT.js", fileBody)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            log.info("{}", string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost4Json() {
        String json = "{}";
        MediaType mediaType = MediaType.get("application/json;charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(json, mediaType);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            log.info("{}", string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet4File() {
        
    }
}
