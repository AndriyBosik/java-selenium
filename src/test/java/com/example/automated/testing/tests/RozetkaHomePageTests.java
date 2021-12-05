package com.example.automated.testing.tests;

import com.example.automated.testing.page.object.RozetkaHomePageObject;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Rozetka Home Page")
public class RozetkaHomePageTests {
    private final RozetkaHomePageObject rozetkaHomePageObject = new RozetkaHomePageObject();

    @Test
    @DisplayName("Should show search query in page header")
    public void shouldShowSearchQueryInPageHeader() {
        rozetkaHomePageObject.open();
        rozetkaHomePageObject.typeSearchQuery("NVME");
        rozetkaHomePageObject.startSearch();
        rozetkaHomePageObject.waitForPageToLoad();
        String productTitle = rozetkaHomePageObject.getFirstCatalogProductTitle();
        assertEquals("NVME", rozetkaHomePageObject.getPageHeader());
        assertTrue(productTitle.toLowerCase().contains("nvme"));
    }
}
