package com.lostsheep.technology.learning.java8.constants;

/**
 * <b><code>RoleEnum</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/11
 *
 * @author lostsheep
 * @since technology-learning
 */
public enum RoleEnum implements NormalInterface {

    /**
     * admin
     */
    ROOT_ADMIN {
        @Override
        public String op() {
            return "admin";
        }
    },

    /**
     * level 1 admin
     */
    ROOT_ONE_ADMIN {
        @Override
        public String op() {
            return "one admin";
        }
    },

    /**
     * user
     */
    USER {
        @Override
        public String op() {
            return "user";
        }
    }
}

