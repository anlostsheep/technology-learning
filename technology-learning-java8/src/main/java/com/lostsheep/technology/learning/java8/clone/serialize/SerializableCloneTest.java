package com.lostsheep.technology.learning.java8.clone.serialize;

/**
 * <b><code>SerializableCloneTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
public class SerializableCloneTest {

    public static void main(String[] args) {
        Class aClass = new Class("信息与计算科学", 48);
        Teacher teacher = new Teacher("风火", 50, aClass);
        System.out.println(teacher);

        Teacher cloneTeacher = teacher.clone();
        System.out.println(cloneTeacher);

        System.out.println(teacher == cloneTeacher);

        aClass.setName("数学");

        System.out.println(teacher);
        System.out.println(cloneTeacher);
    }
}
