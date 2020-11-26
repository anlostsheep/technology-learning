package com.lostsheep.technology.learning.java8.hutool;

import cn.hutool.log.level.Level;

/**
 * <b><code>SpecificLogger</code></b>
 * <p/>
 * Description
 * <p/>
 *
 * @author lostsheep
 * @date 2020/11/13
 */
public class SpecificLogger extends AbstractLogger {

    public void testLog() {
        log.log(Level.INFO, "some info");
    }
}
