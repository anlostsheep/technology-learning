package com.lostsheep.technology.learning.http.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>OriginalRestTemplate</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/4 14:48.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Configuration
public class OriginalRestTemplateConfig {


    @Bean("oleRestTemplate")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(6000);
        return new RestTemplate(factory);
    }

}
