package com.lostsheep.technology.learning.http.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>RestTemplateController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/4 15:27.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@RestController
public class RestTemplateController {

    private final RestTemplate restTemplate;

    public RestTemplateController(@Qualifier("poolRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/rest/{company}/{order}")
    public String poolRestTemplateTest(@PathVariable("company") String company,
                                       @PathVariable("order") String order) {
        String url = "http://www.kuaidi100.com/query?type={0}&postid={1}";

        ResponseEntity<String> resultEntity = restTemplate.getForEntity(url, String.class, company, order);
        String body = resultEntity.getBody();
        log.info("{}", body);

        return body;
    }
}
