package com.example.automated.testing.tests;

import com.example.automated.testing.page.step.RozetkaProductsListPageObject;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Rozetka Products List Page")
public class RozetkaProductsListPageTest {
    private final RozetkaProductsListPageObject rozetkaProductsListPageObject = new RozetkaProductsListPageObject();

    @Test
    @DisplayName("Should show products in large tiles")
    public void shouldShowLargeTiles() {
        rozetkaProductsListPageObject.open();
        rozetkaProductsListPageObject.clickLargeIcons();
        assertFalse(rozetkaProductsListPageObject.isSmallTiles());
    }

    @Test
    @DisplayName("Should show products in small tiles")
    public void shouldShowSmallTiles() {
        rozetkaProductsListPageObject.open();
        rozetkaProductsListPageObject.clickSmallTiles();
        assertTrue(rozetkaProductsListPageObject.isSmallTiles());
    }

    @Test
    @DisplayName("Should add product to cart")
    public void shouldAddProductToCart() {
        rozetkaProductsListPageObject.open();
        rozetkaProductsListPageObject.buyProduct();
        rozetkaProductsListPageObject.waitForCartToAddProduct();
        assertEquals(1, rozetkaProductsListPageObject.getCartProductsCount());
    }

    @Test
    @DisplayName("Should add product to comparison list")
    public void shouldAddProductToComparisonList() {
        rozetkaProductsListPageObject.open();
        rozetkaProductsListPageObject.addToComparisonList();
        rozetkaProductsListPageObject.waitForComparisonListToAddProduct();
        assertEquals(1, rozetkaProductsListPageObject.getComparisonListProductsCount());
    }

    @Test
    @DisplayName("Should load more products")
    public void shouldLoadMoreProducts() {
        rozetkaProductsListPageObject.open();
        int currentCount = rozetkaProductsListPageObject.getVisibleCatalogProductsCount();
        rozetkaProductsListPageObject.clickShowMoreButton();
        rozetkaProductsListPageObject.waitToLoad();
        int newCount = rozetkaProductsListPageObject.getVisibleCatalogProductsCount();
        assertTrue(newCount > currentCount);
    }
}
