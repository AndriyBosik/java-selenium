package com.example.automated.testing.tests;

import com.example.automated.testing.pages.RozetkaHomePage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Rozetka Home Page")
public class RozetkaHomePageTests {
    private final RozetkaHomePage rozetkaHomePage = new RozetkaHomePage();

    @Test
    @DisplayName("Should show search query in page header")
    public void shouldShowSearchQueryInPageHeader() {
        rozetkaHomePage.open();
        rozetkaHomePage.typeSearchQuery("NVME");
        rozetkaHomePage.startSearch();
        rozetkaHomePage.waitForPageToLoad();
        String productTitle = rozetkaHomePage.getFirstCatalogProductTitle();
        assertEquals("NVME", rozetkaHomePage.getPageHeader());
        assertTrue(productTitle.toLowerCase().contains("nvme"));
    }
}
