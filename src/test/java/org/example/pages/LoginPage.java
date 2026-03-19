package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, 'register')]")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(@href, 'forgot-password')]")
    private WebElement forgotPasswordLink;

    // Методы для ввода данных
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    // Метод для заполнения обоих полей
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    // Метод для клика по кнопке входа
    public void clickLoginButton() {
        loginButton.click();
    }

    // Метод для полного действия логина
    public void login(String email, String password) {
        fillLoginForm(email, password);
        clickLoginButton();
    }

    // Методы для перехода по ссылкам
    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    // Твой универсальный метод оставил, если нужен
    public void clickOnElement(WebElement element) {
        element.click();
    }
}