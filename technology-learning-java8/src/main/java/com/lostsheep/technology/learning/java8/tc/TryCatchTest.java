package com.lostsheep.technology.learning.java8.tc;

/**
 * <b><code>TryCatchTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/16
 *
 * @author dengzhen
 * @since technology-learning
 */
public class TryCatchTest {

    public static void main(String[] args) {
        int i = returnTryExec();
        System.out.println(i);
        int j = returnCatchExec();
        System.out.println(j);
        exitTryExec();
        exitCatchExec();

    }

    public static int returnTryExec() {
        try {
            return 0;
        } catch (Exception e) {

        } finally {
            System.out.println("finally returnTryExec");
            return -1;
        }
    }

    public static int returnCatchExec() {
        try {

        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("finally returnCatchExec");
            return -1;
        }
    }

    public static void exitTryExec() {
        try {
            System.exit(0);
        } catch (Exception e) {

        } finally {
            System.out.println("finally exitTryExec");
        }
    }

    public static void exitCatchExec() {
        try {
            // throw new RuntimeException("exception throw");
        } catch (Exception e) {
            System.exit(0);
        } finally {
            System.out.println("finally exitCatchExec");
        }
    }
}
