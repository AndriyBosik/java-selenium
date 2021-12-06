package com.example.automated.testing.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
    private static SeleniumConfig instance;

    private final WebDriver webDriver;

    private SeleniumConfig() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    public static SeleniumConfig getInstance() {
        if (instance == null) {
            instance = new SeleniumConfig();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
