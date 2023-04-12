package com.lostsheep.technology.learning.java8.reflection;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * <b><code>ImplementClassReflection</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/4/12.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ImplementClassReflection {

    /**
     * 获取某个类的实现类
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public static List<Class<?>> getAllAssignedClass(Class<?> clazz) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        List<Class<?>> clazzList = getClasses(clazz);
        for (Class<?> c : clazzList) {
            if (clazz.isAssignableFrom(c) && !clazz.equals(c)) {
                classes.add(c);
            }
        }

        return classes;
    }

    public static List<Class<?>> getClasses(Class<?> clazz) throws Exception {
        String packageName = clazz.getPackage().getName();
        String pathName = packageName.replace('.', '/');
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(pathName);

        assert url != null;
        File classloaderFile = new File(url.getFile());
        return getClasses(classloaderFile, packageName);
    }

    /**
     * 根据路径获取
     *
     * @param dir
     * @param packageName
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClasses(File dir, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!dir.exists()) {
            return classes;
        }

        File[] nonNullFiles = Objects.requireNonNull(dir.listFiles());
        for (File f : nonNullFiles) {
            if (f.isDirectory()) {
                classes.addAll(getClasses(f, packageName + "." + f.getName()));
            }

            String name = f.getName();
            if (name.endsWith(".class")) {
                classes.add(Class.forName(packageName + "." + name.substring(0, name.length() - 6)));
            }
        }

        return classes;
    }

    /**
     * 动态获取，根据反射，比如获取 xx.xx.xx.xx.Action 这个所有的实现类。 xx.xx.xx.xx 表示包名 Action 为接口名或者类名
     *
     * @param classPackageAndName
     * @return
     * @throws Exception
     */
    public static List<Class<?>> getAllActionSubClass(String classPackageAndName) throws Exception {
        Field field;
        Vector<?> v;
        Class<?> cls;

        List<Class<?>> allSubclass = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> classOfClassLoader = classLoader.getClass();
        cls = Class.forName(classPackageAndName);
        while (classOfClassLoader != ClassLoader.class) {
            classOfClassLoader = classOfClassLoader.getSuperclass();
        }

        field = classOfClassLoader.getDeclaredField("classes");
        field.setAccessible(true);
        v = (Vector<?>) field.get(classLoader);
        for (Object o : v) {
            Class<?> c = (Class<?>) o;
            if (cls.isAssignableFrom(c) && !cls.equals(c)) {
                allSubclass.add(c);
            }
        }

        return allSubclass;
    }

    public static void main(String[] args) throws Exception {
        Class<AbstractReflection> abstractReflectionClass = AbstractReflection.class;
        List<Class<?>> classList = getAllAssignedClass(abstractReflectionClass);
        classList.forEach(c -> System.out.println(c.getName()));
    }
}
