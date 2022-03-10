package com.lostsheep.technology.learning.java8.clone.serialize;

import lombok.*;

import java.io.*;

/**
 * <b><code>Teacher</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher implements Serializable {

    private String name;
    private Integer age;
    private Class aClass;

    @Override
    public Teacher clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Teacher) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new Teacher();
    }
}
