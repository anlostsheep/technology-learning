package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>Laptop</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public class Laptop {
    private String cpu;
    private String motherboard;
    private String graphic;
    private String os;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Laptop(String cpu, String motherboard, String graphic, String os) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.graphic = graphic;
        this.os = os;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", graphic='" + graphic + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    public static Laptop.Builder builder() {
        return new Laptop.Builder();
    }

    public static class Builder {
        private String cpu;
        private String motherboard;
        private String graphic;
        private String os;

        public Laptop.Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Laptop.Builder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Laptop.Builder graphic(String graphic) {
            this.graphic = graphic;
            return this;
        }

        public Laptop.Builder os(String os) {
            this.os = os;
            return this;
        }

        public Laptop build() {
            return new Laptop(cpu, motherboard, graphic, os);
        }
    }

    public static void main(String[] args) {
        Laptop build = Laptop.builder().cpu("i7-10710").build();
        System.out.println(build);
    }
}
