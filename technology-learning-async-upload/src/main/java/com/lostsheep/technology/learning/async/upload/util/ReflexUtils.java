package com.lostsheep.technology.learning.async.upload.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <b><code>ReflexUtils</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class ReflexUtils {

    public static String splitFlag = ",\\\\";

    public static <T> List<T> initializationObjs(String source, Class<T> clazz) {
        String[] arrays = source.split(splitFlag);
        return Arrays.stream(arrays)
                .map(a -> {
                    String trimClassReference = a.trim();
                    Class<T> aClass;
                    try {
                        aClass = (Class<T>) Class.forName(trimClassReference);
                    } catch (ClassNotFoundException e) {
                        log.error("初始化[{}]反射类异常, namespace: {}", clazz.getSimpleName(), a, e);
                        return null;
                    }

                    Constructor<?>[] dct = aClass.getDeclaredConstructors();
                    Constructor<?> ct = Arrays.stream(dct)
                            .filter(d -> {
                                Parameter[] parameters = d.getParameters();
                                return Objects.isNull(parameters) || parameters.length == 0;
                            })
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException(a + " 的无参构造方法被覆盖且没有被声明!"));

                    T t;
                    try {
                        t = (T) ct.newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        log.error("初始化反射对象异常!", e);
                        return null;
                    }

                    return t;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
