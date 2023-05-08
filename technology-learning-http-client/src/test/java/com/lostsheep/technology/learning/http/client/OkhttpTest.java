package com.lostsheep.technology.learning.http.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

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
