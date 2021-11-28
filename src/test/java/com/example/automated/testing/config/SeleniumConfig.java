package com.example.automated.testing.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
    private static SeleniumConfig instance;

    private final WebDriver webDriver;

    private SeleniumConfig() {
        System.setProperty("webdriver.chrome.driver", "/home/andrii/Data/Drivers/ChromeDriver/chromedriver");
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
