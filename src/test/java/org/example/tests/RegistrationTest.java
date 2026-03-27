package org.example.tests;

import io.qameta.allure.Description;
import org.example.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    @Test
    @Description("Успешная регистрация нового пользователя. Проверка редиректа на страницу логина.")
    public void testSuccessfulRegistration() {
        User user = User.getRandom();

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        waitForUrlChange();
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @Description("Неуспешная регистрация с паролем менее 6 символов. Проверка отображения сообщения об ошибке.")
    public void testNotSuccessfulRegistration() {

        User user = User.getRandom();

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.register(user.getName(), user.getEmail(), "12345");
        assertTrue(registrationPage.isErrorMessageDisplayed());

    }
}