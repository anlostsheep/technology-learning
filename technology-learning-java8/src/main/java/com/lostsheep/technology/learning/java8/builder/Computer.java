package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>Computer</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public class Computer {
    
    private String cpu;
    private String motherboard;
    private String graphic;
    private String os;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", graphic='" + graphic + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
