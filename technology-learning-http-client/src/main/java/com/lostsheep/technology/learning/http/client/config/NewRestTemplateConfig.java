package com.lostsheep.technology.learning.http.client.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>NewRestTemplateConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/4 14:55.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Configuration
public class NewRestTemplateConfig {

    @Bean("poolRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate(requestFactory());
    }

    @Bean("httpRequestFactory")
    public ClientHttpRequestFactory requestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    @Bean("httpClient")
    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);

        // set the pool size
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(100);

        RequestConfig requestConfig = RequestConfig.custom()
                // socket connect time
                .setSocketTimeout(3000)
                // TCP connect time
                .setConnectTimeout(6000)
                // TCP request handle time
                .setConnectionRequestTimeout(100000)
                .build();

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }
}
