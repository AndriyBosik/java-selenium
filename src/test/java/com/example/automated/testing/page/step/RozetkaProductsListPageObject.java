package com.example.automated.testing.page.step;

import com.example.automated.testing.config.SeleniumConfig;
import com.example.automated.testing.page.RozetkaProductsListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaProductsListPageObject {
    private final WebDriver driver = SeleniumConfig.getInstance().getWebDriver();
    private final RozetkaProductsListPage page = new RozetkaProductsListPage();

    @Step("Open Rozetka Products List Page")
    public void open() {
        driver.get("https://rozetka.com.ua/ua/pribory-nochnogo-videniya/c254834/");
    }

    @Step("Click small tiles button")
    public void clickSmallTiles() {
        page.getSmallTilesButton().click();
    }

    @Step("Click large tiles button")
    public void clickLargeIcons() {
        page.getLargeTilesButton().click();
    }

    @Step("Check whatever tiles is small")
    public boolean isSmallTiles() {
        return page.getFirstCatalogItem().getAttribute("class").contains("catalog-grid__cell_type_slim");
    }

    @Step("Click BUY PRODUCT button")
    public void buyProduct() {
        page.getFirstCatalogItemBuyButton().click();
    }

    @Step("Click COMPARE PRODUCT button")
    public void addToComparisonList() {
        page.getFirstCatalogItemCompareButton().click();
    }

    @Step("Get cart items count")
    public int getCartProductsCount() {
        return Integer.parseInt(page.getCartCounter().getText().strip());
    }

    @Step("Get comparison items count")
    public int getComparisonListProductsCount() {
        return Integer.parseInt(page.getComparisonListCounter().getText().strip());
    }

    @Step("Get visible catalog products count")
    public int getVisibleCatalogProductsCount() {
        return page.getProductsList().size();
    }

    @Step("Click SHOW MORE button")
    public void clickShowMoreButton() {
        page.getShowMoreButton().click();
    }

    @Step("Wait catalog to load more items")
    public void waitToLoad() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
