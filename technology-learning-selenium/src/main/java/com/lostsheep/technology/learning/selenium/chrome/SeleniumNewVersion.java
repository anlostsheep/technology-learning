package com.lostsheep.technology.learning.selenium.chrome;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * <b><code>SeleniumNewVersion</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/12.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class SeleniumNewVersion {
    public static void main(String[] args) throws IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setBinary("/Users/lostsheep/Downloads/Google Chrome.app/Contents/MacOS/Google Chrome");
        System.setProperty("webdriver.chrome.driver", "/Users/lostsheep/Downloads/chromedriver");

        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        Map<String, Object> cdpCmd = new HashMap<>(1);
        String jsContent = IOUtils.toString(new FileInputStream("/Users/lostsheep/Downloads/stealth.min.js"), StandardCharsets.UTF_8);
        cdpCmd.put("source", jsContent);
        chromeDriver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", cdpCmd);

        try {
            // Navigate to Url
            chromeDriver.get("https://brandhube.meituan.com/gxt/download/overview");

            Thread.sleep(10 * 6 * 1000);
            log.info("流程结束...");
        } catch (InterruptedException e) {
            log.error("程序异常", e);
        } finally {
            chromeDriver.quit();
        }
    }
}
