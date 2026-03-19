package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Локаторы
    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'tab_tab') and .//span[text()='Булки']]")
    private WebElement bunsTab;

    @FindBy(xpath = "//div[contains(@class, 'tab_tab') and .//span[text()='Соусы']]")
    private WebElement saucesTab;

    @FindBy(xpath = "//div[contains(@class, 'tab_tab') and .//span[text()='Начинки']]")
    private WebElement fillingsTab;

    // Методы для кликов
    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickPersonalAccount() {
        personalAccountButton.click();
    }

    public void clickBunsTab() {
        bunsTab.click();
    }

    public void clickSaucesTab() {
        saucesTab.click();
    }

    public void clickFillingsTab() {
        fillingsTab.click();
    }

    // Методы для проверки активной вкладки
    public boolean isBunsTabSelected() {
        return isTabSelected(bunsTab);
    }

    public boolean isSaucesTabSelected() {
        return isTabSelected(saucesTab);
    }

    public boolean isFillingsTabSelected() {
        return isTabSelected(fillingsTab);
    }

    // Приватный вспомогательный метод
    private boolean isTabSelected(WebElement tab) {
        String classValue = tab.getDomAttribute("class");
        return classValue != null && classValue.contains("current");
    }
}