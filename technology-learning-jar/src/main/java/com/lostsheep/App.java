package com.lostsheep;

import com.lostsheep.technology.learning.java8.builder.Laptop;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 * @author lostsheep
 */
@Slf4j
public class App {
    
    public static void main(String[] args) throws InterruptedException {
        log.info("Hello World! Manifest!");
        Laptop laptop = Laptop.builder().cpu("10700").build();
        log.info("{}", laptop);
        
        
        Thread.sleep(8000);
        log.info("线程完成");
    }
}
