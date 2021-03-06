package com.lostsheep.technology.learning.java8.builder;

/**
 * <b><code>HpLeptopBuilder</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/3/16
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public class MacLaptopBuilder extends Builder{

    private Computer computer = new Computer(); 
    
    @Override
    public void cpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void motherboard(String motherboard) {
        computer.setMotherboard(motherboard);
    }

    @Override
    public void graphic(String graphic) {
        computer.setGraphic(graphic);
    }

    @Override
    public void os() {
        computer.setOs("MacOS");
    }

    @Override
    public Computer build() {
        return computer;
    }
}
