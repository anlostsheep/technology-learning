package com.lostsheep.technology.learning.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>MybatisRunApplicaton</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/26 1:29.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lostsheep.technology.learning.mybatis.mapper")
public class MybatisRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisRunApplication.class, args);
    }
}
