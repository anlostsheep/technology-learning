package com.lostsheep.technology.learning.java8.constants;

/**
 * <b><code>Singleton</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/11
 *
 * @author lostsheep
 * @since technology-learning
 */
public class Singleton {

    private Singleton() {
    }

    public enum SingleEnum {
        /**
         * 种子
         */
        SEED;

        private final Singleton singleton;

        SingleEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return SingleEnum.SEED.getInstance();
    }
}
