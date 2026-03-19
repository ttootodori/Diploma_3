package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
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
    private WebElement loginLink;  // переименовал, чтобы не путать с кнопкой входа

    // Методы для заполнения полей
    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    // Метод для заполнения всех полей сразу
    public void fillRegistrationForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    // Метод для клика по кнопке регистрации
    public void clickRegisterButton() {
        registerButton.click();
    }

    // Метод для перехода на страницу логина
    public void clickLoginLink() {
        loginLink.click();
    }

    // Комбинированный метод для регистрации
    public void register(String name, String email, String password) {
        fillRegistrationForm(name, email, password);
        clickRegisterButton();
    }
}