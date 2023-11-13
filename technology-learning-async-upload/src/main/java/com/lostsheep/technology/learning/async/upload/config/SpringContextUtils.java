package com.lostsheep.technology.learning.async.upload.config;

import org.springframework.context.ApplicationContext;

/**
 * <b><code>SpringContextUtils</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class SpringContextUtils {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringContextUtils.applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static Object getBean(Class<?> requiredType) {
        return getApplicationContext().getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
