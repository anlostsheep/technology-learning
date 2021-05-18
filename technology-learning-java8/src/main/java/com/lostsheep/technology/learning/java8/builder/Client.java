package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>Client</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public class Client {

    public static void main(String[] args) {
        Builder laptopBuilder = new LenovoLaptopBuilder();
        Director director = new Director(laptopBuilder);
        Computer lenovo = director.construct("i5-9850H", "asus", "nvidia");
        Builder macLaptopBuilder = new MacLaptopBuilder();
        Director director2 = new Director(macLaptopBuilder);
        Computer mac = director2.construct("i5-9300", "apple", "intel");
        System.out.println(lenovo);
        System.out.println(mac);
    }
}
