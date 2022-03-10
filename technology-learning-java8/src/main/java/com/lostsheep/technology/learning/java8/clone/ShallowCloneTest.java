package com.lostsheep.technology.learning.java8.clone;

/**
 * <b><code>ShallowCloneTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
public class ShallowCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Major major = new Major("信息与计算科学", 201501);
        Student student = new Student("张三", 21, major);
        System.out.println(student);

        Student cloneStu = (Student) student.clone();
        System.out.println(cloneStu);
        System.out.println(student.equals(cloneStu));
        cloneStu.setName("李四");
        cloneStu.setAge(22);
        System.out.println(cloneStu);

        major.setMajorName("数学");
        major.setMajorId(201502);
        System.out.println(student);
        System.out.println(cloneStu);
    }
}
