package org.example.tests;

import io.qameta.allure.Description;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTabsTest extends BaseTest {

    @Test
    @Description("Переключение на вкладку Начинки, затем на Булки. Проверка, что вкладка Булки активна.")
    public void bunsTabVisibilityTest() {
        mainPage.selectFillingsTab();
        mainPage.selectBunsTab();
        assertTrue(mainPage.isBunsTabSelected());
    }

    @Test
    @Description("Переключение на вкладку Начинки, затем на Соусы. Проверка, что вкладка Соусы активна.")
    public void sauceTabVisibilityTest() {
        mainPage.selectFillingsTab();
        mainPage.selectSaucesTab();

        assertTrue(mainPage.isSaucesTabSelected());
    }

    @Test
    @Description("Переключение на вкладку Соусы, затем на Начинки. Проверка, что вкладка Начинки активна.")
    public void fillingTabVisibilityTest() {
        mainPage.selectSaucesTab();
        mainPage.selectFillingsTab();   // Переключит на начинки

        assertTrue(mainPage.isFillingsTabSelected());
    }
}