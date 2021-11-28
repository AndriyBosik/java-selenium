package com.example.automated.testing.pages;

import com.example.automated.testing.config.SeleniumConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaProductsListPage {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();

    @Step("Open Rozetka Products List Page")
    public void open() {
        driver.get("https://rozetka.com.ua/ua/pribory-nochnogo-videniya/c254834/");
    }

    @Step("Click small tiles button")
    public void clickSmallTiles() {
        driver.findElement(new By.ByCssSelector("[title='Мала плитка']")).click();
    }

    @Step("Click large tiles button")
    public void clickLargeIcons() {
        driver.findElement(new By.ByCssSelector("[title='Крупна плитка']")).click();
    }

    @Step("Check whatever tiles is small")
    public boolean isSmallTiles() {
        return driver.findElement(new By.ByCssSelector(".catalog-grid__cell")).getAttribute("class").contains("catalog-grid__cell_type_slim");
    }

    @Step("Click BUY PRODUCT button")
    public void buyProduct() {
        driver.findElement(new By.ByCssSelector(".goods-tile .buy-button")).click();
    }

    @Step("Click COMPARE PRODUCT button")
    public void addToComparisonList() {
        driver.findElement(new By.ByCssSelector(".goods-tile .compare-button")).click();
    }

    @Step("Get cart items count")
    public int getCartProductsCount() {
        return Integer.parseInt(driver.findElement(new By.ByCssSelector("button[opencart] span.counter")).getText().strip());
    }

    @Step("Get comparison items count")
    public int getComparisonListProductsCount() {
        return Integer.parseInt(driver.findElement(new By.ByCssSelector("rz-comparison span.counter")).getText().strip());
    }

    @Step("Get visible catalog products count")
    public int getVisibleCatalogProductsCount() {
        return driver.findElements(new By.ByCssSelector("ul.catalog-grid li")).size();
    }

    @Step("Click SHOW MORE button")
    public void clickShowMoreButton() {
        driver.findElement(new By.ByCssSelector("a.show-more")).click();
    }

    @Step("Wait catalog to load more items")
    public void waitToLoad() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("ul.preloader_type_element")));
    }

    @Step("Wait For Comparison List To Add Product")
    public void waitForComparisonListToAddProduct() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("rz-comparison span.counter")));
    }

    @Step("Wait For Cart To Add Product")
    public void waitForCartToAddProduct() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("button[opencart] span.counter")));
    }
}
