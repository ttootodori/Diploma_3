package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement burgerConstructorTitle;

    @Step("Выбрать вкладку Булки")
    public void selectBunsTab() {
        if (isTabSelected(bunsTab)) {
            return;
        }

        smallPause();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bunsTab)).click();
        wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "current"));
        smallPause();

    }

    @Step("Выбрать вкладку Соусы")
    public void selectSaucesTab() {
        if (isTabSelected(saucesTab)) {
            return;
        }

        smallPause();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saucesTab)).click();
        wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "current"));

        smallPause();

    }

    @Step("Выбрать вкладку Начинки")
    public void selectFillingsTab() {
        if (isTabSelected(fillingsTab)) {
            return;
        }

        smallPause();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsTab)).click();
        wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "current"));

        smallPause();

    }

    @Step("Проверка, активна ли вкладка Булки")
    public boolean isBunsTabSelected() {
        return isTabSelected(bunsTab);
    }

    @Step("Проверка, активна ли вкладка Соусы")
    public boolean isSaucesTabSelected() {
        return isTabSelected(saucesTab);
    }

    @Step("Проверка, активна ли вкладка Начинки")
    public boolean isFillingsTabSelected() {
        return isTabSelected(fillingsTab);
    }

    @Step("Нажатие кнопки Войти в аккаунт")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Переход в личный кабинет")
    public void clickPersonalAccount() {
        personalAccountButton.click();
    }

    @Step("Проверка отображения конструктора бургера")
    public boolean isBurgerConstructorDisplayed() {
        try {
            return burgerConstructorTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isTabSelected(WebElement tab) {
        String classValue = tab.getDomAttribute("class");
        return classValue != null && classValue.contains("current");
    }

    public void smallPause() {
        new WebDriverWait(driver, Duration.ofMillis(2000))
                .until(driver -> true);
    }
}