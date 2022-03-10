package com.lostsheep.technology.learning.java8.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b><code>Student</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
@Data
@AllArgsConstructor
public class Student implements Cloneable {

    private String name;
    private Integer age;
    private Major major;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.major = (Major) major.clone();
        return student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
