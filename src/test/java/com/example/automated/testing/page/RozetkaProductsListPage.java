package com.example.automated.testing.page;

import com.example.automated.testing.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RozetkaProductsListPage {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();

    public WebElement getSmallTilesButton() {
        return driver.findElement(new By.ByCssSelector("[title='Мала плитка']"));
    }

    public WebElement getLargeTilesButton() {
        return driver.findElement(new By.ByCssSelector("[title='Крупна плитка']"));
    }

    public WebElement getFirstCatalogItem() {
        return driver.findElement(new By.ByCssSelector(".catalog-grid__cell"));
    }

    public WebElement getFirstCatalogItemBuyButton() {
        return driver.findElement(new By.ByCssSelector(".goods-tile .buy-button"));
    }

    public WebElement getFirstCatalogItemCompareButton() {
        return driver.findElement(new By.ByCssSelector(".goods-tile .compare-button"));
    }

    public WebElement getCartCounter() {
        return driver.findElement(new By.ByCssSelector("button[opencart] span.counter"));
    }

    public WebElement getComparisonListCounter() {
        return driver.findElement(new By.ByCssSelector("rz-comparison span.counter"));
    }

    public List<WebElement> getProductsList() {
        return driver.findElements(new By.ByCssSelector("ul.catalog-grid li"));
    }

    public WebElement getShowMoreButton() {
        return driver.findElement(new By.ByCssSelector("a.show-more"));
    }
}
