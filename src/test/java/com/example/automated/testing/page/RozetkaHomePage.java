package com.example.automated.testing.page;

import com.example.automated.testing.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaHomePage {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();

    public WebElement getSearchField() {
        return driver.findElement(new By.ByName("search"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(new By.ByCssSelector(".search-form .search-form__submit"));
    }

    public WebElement getPageHeader() {
        return driver.findElement(new By.ByCssSelector("h1.catalog-heading"));
    }

    public WebElement getFirstCatalogProductTitleElement() {
        return driver.findElement(new By.ByCssSelector("ul.catalog-grid li")).findElement(new By.ByCssSelector(".goods-tile__title"));
    }
}
