package com.lostsheep.technology.learning.selenium.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * <b><code>WebDriverFactory</code></b>
 * <p/>
 * WebDriver 工厂
 * <p/>
 * <b>Creation Time:</b> 2021/5/18
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
public interface WebDriverFactory { 

    /**
     * 实例化 webDriver
     *
     * @param driverPath  path
     * @param browserType browser
     * @return {@link WebDriver}
     */
    WebDriver newInstance(String driverPath, String browserType);
}
