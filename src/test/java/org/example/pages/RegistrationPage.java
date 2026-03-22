package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'input') and .//label[text()='Имя']]//input")
    private WebElement nameInput;

    @FindBy(xpath = "//div[contains(@class, 'input') and .//label[text()='Email']]//input")
    private WebElement emailInput;

    @FindBy(xpath = "//div[contains(@class, 'input') and .//label[text()='Пароль']]//input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//p[contains(@class, 'input__error')]")
    private WebElement errorMessage;

    @Step("Проверка отображения сообщения об ошибке")
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Ввод имени.")
    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Ввод email.")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    @Step("Нажатие кнопки Зарегистрироваться")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Переход на страницу логина")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Выполнение регистрации нового пользователя")
    public void register(String name, String email, String password) {
        fillRegistrationForm(name, email, password);
        clickRegisterButton();
    }
}