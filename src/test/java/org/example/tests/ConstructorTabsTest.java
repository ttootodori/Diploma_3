package org.example.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTabsTest extends BaseTest {

    @Test
    public void bunsTabVisibilityTest() throws InterruptedException {
        mainPage.clickSaucesTab();
        Thread.sleep(500);
        mainPage.clickBunsTab();
        Thread.sleep(500);
        assertTrue(mainPage.isBunsTabSelected());
    }

    @Test
    public void sauceTabVisibilityTest() {
        mainPage.clickSaucesTab();
        assertTrue(mainPage.isSaucesTabSelected());
    }
    @Test
    public void fillingTabVisibilityTest() {
        mainPage.clickFillingsTab();
        assertTrue(mainPage.isFillingsTabSelected());
    }
}
