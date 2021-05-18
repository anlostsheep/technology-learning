package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>Builder</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public abstract class Builder {

    /**
     * setupCPU
     * @param cpu
     */
    public abstract void cpu(String cpu);

    /**
     * setupMotherboard
     * @param motherboard
     */
    public abstract void motherboard(String motherboard);

    /**
     * setupGraphic
     * @param graphic
     */
    public abstract void graphic(String graphic);

    /**
     * setOS
     */
    public abstract void os();

    /**
     * build
     * @return
     */
    public abstract Computer build();
}
