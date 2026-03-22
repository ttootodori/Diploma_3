package org.example.pages;

import io.qameta.allure.Step;
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

    @Step("Ввод email")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Заполнение формы логина")
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    @Step("Нажатие кнопки Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Выполнение входа в систему")
    public void login(String email, String password) {
        fillLoginForm(email, password);
        clickLoginButton();
    }

    @Step("Переход на страницу регистрации")
    public void clickRegisterLink() {
        registerLink.click();
    }

    @Step("Переход на страницу восстановления пароля")
    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}