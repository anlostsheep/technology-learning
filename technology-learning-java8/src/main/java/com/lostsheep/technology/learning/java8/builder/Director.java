package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>Director</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Computer construct(String cpu, String motherboard, String graphic) {
        builder.cpu(cpu);
        builder.motherboard(motherboard);
        builder.graphic(graphic);
        builder.os();
        return builder.build();
    }
}
