package com.example.automated.testing.pages;

import com.example.automated.testing.config.SeleniumConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaHomePage {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();

    @Step("Open Rozetka Home Page")
    public void open() {
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Step("Type {searchQuery} text in search box")
    public void typeSearchQuery(String searchQuery) {
        driver.findElement(new By.ByName("search")).sendKeys(searchQuery);
    }

    @Step("Click search button")
    public void startSearch() {
        driver.findElement(new By.ByCssSelector(".search-form .search-form__submit")).click();
    }

    @Step("Get page header")
    public String getPageHeader() {
        String text = driver.findElement(new By.ByCssSelector("h1.catalog-heading")).getText();
        return text.substring(1, text.length() - 1);
    }
    
    @Step("Wait for page to load")
    public void waitForPageToLoad() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("h1.catalog-heading")));
    }

    public String getFirstCatalogProductTitle() {
        return driver.findElement(new By.ByCssSelector("ul.catalog-grid li")).findElement(new By.ByCssSelector(".goods-tile__title")).getText();
    }
}
