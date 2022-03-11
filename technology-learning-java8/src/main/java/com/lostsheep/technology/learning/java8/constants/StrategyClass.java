package com.lostsheep.technology.learning.java8.constants;

/**
 * <b><code>StrategyClass</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/11
 *
 * @author lostsheep
 * @since technology-learning
 */
public class StrategyClass {

    public enum Calculator {

        /**
         * 加
         */
        ADDITION {
            @Override
            public Number execute(Integer x, Integer y) {
                return x + y;
            }
        },

        SUBTRACTION {
            @Override
            public Number execute(Integer x, Integer y) {
                return x - y;
            }
        },

        MULTIPLICATION {
            @Override
            public Number execute(Integer x, Integer y) {
                return x * y;
            }
        },


        DIVISION {
            @Override
            public Number execute(Integer x, Integer y) {
                return x / y;
            }
        };

        public abstract Number execute(Integer x, Integer y);
    }

    public static void main(String[] args) {
        Number addition = Calculator.ADDITION.execute(1, 2);
        System.out.println(addition);
        Number subtraction = Calculator.SUBTRACTION.execute(10, 9);
        System.out.println(subtraction);
        Number multiplication = Calculator.MULTIPLICATION.execute(11, 11);
        System.out.println(multiplication);
        Number division = Calculator.DIVISION.execute(11, 22);
        System.out.println(division);
    }
}
