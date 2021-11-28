package com.example.automated.testing.tests;

import com.example.automated.testing.pages.RozetkaProductsListPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Rozetka Products List Page")
public class RozetkaProductsListPageTests {
    private final RozetkaProductsListPage rozetkaProductsListPage = new RozetkaProductsListPage();

    @Test
    @DisplayName("Should show products in large tiles")
    public void shouldShowLargeTiles() {
        rozetkaProductsListPage.open();
        rozetkaProductsListPage.clickLargeIcons();
        assertFalse(rozetkaProductsListPage.isSmallTiles());
    }

    @Test
    @DisplayName("Should show products in small tiles")
    public void shouldShowSmallTiles() {
        rozetkaProductsListPage.open();
        rozetkaProductsListPage.clickSmallTiles();
        assertTrue(rozetkaProductsListPage.isSmallTiles());
    }

    @Test
    @DisplayName("Should add product to cart")
    public void shouldAddProductToCart() {
        rozetkaProductsListPage.open();
        rozetkaProductsListPage.buyProduct();
        rozetkaProductsListPage.waitForCartToAddProduct();
        assertEquals(1, rozetkaProductsListPage.getCartProductsCount());
    }

    @Test
    @DisplayName("Should add product to comparison list")
    public void shouldAddProductToComparisonList() {
        rozetkaProductsListPage.open();
        rozetkaProductsListPage.addToComparisonList();
        rozetkaProductsListPage.waitForComparisonListToAddProduct();
        assertEquals(1, rozetkaProductsListPage.getComparisonListProductsCount());
    }

    @Test
    @DisplayName("Should load more products")
    public void shouldLoadMoreProducts() {
        rozetkaProductsListPage.open();
        int currentCount = rozetkaProductsListPage.getVisibleCatalogProductsCount();
        rozetkaProductsListPage.clickShowMoreButton();
        rozetkaProductsListPage.waitToLoad();
        int newCount = rozetkaProductsListPage.getVisibleCatalogProductsCount();
        assertTrue(newCount > currentCount);
    }
}
