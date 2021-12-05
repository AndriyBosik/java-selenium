package com.example.automated.testing.page.object;

import com.example.automated.testing.config.SeleniumConfig;
import com.example.automated.testing.page.RozetkaHomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaHomePageObject {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();
    private final RozetkaHomePage page = new RozetkaHomePage();

    @Step("Open Rozetka Home Page")
    public void open() {
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Step("Type {searchQuery} text in search box")
    public void typeSearchQuery(String searchQuery) {
        page.getSearchField().sendKeys(searchQuery);
    }

    @Step("Click search button")
    public void startSearch() {
        page.getSearchButton().click();
    }

    @Step("Get page header")
    public String getPageHeader() {
        String text = page.getPageHeader().getText();
        return text.substring(1, text.length() - 1);
    }
    
    @Step("Wait for page to load")
    public void waitForPageToLoad() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("h1.catalog-heading")));
    }

    public String getFirstCatalogProductTitle() {
        return page.getFirstCatalogProductTitleElement().getText();
    }
}
