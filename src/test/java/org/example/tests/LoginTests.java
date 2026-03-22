package org.example.tests;

import io.qameta.allure.Description;
import org.example.pages.PasswordRecoveryPage;
import org.example.RestApi;
import org.example.model.User;
import org.example.steps.UserSteps;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private User user;
    private UserSteps userSteps;

    @Before
    public void setUp() throws InterruptedException {

        RestAssured.baseURI = RestApi.BASE_URL;
        userSteps = new UserSteps();

        super.setUp();

        user = userSteps.createRandomUser();
        userSteps.createUser(user);
        accessToken = userSteps.getAccessToken();
    }

    @Test
    @Description("Вход через кнопку Войти в аккаунт на главной странице.")
    public void loginByClickingLoginButton() {
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isBurgerConstructorDisplayed());
    }

    @Test
    @Description("Вход через кнопку Личный кабинет в шапке сайта.")
    public void loginByClickingAccountButton() {

        mainPage.clickPersonalAccount();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());

    }

    @Test
    @Description("Вход через кнопку Войти в форме регистрации.")
    public void loginByClickingButtonInRegistrationForm() {

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.clickLoginLink();
        loginPage.login(user.getEmail(),user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());
    }

    @Test
    @Description("Вход через кнопку Войти в форме восстановления пароля.")
    public void loginByClickingButtonInPasswordRecoveryForm() {
        PasswordRecoveryPage recoveryPage = new PasswordRecoveryPage(driver);
        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        recoveryPage.clickOnRecoveryPageLoginLink();
        loginPage.login(user.getEmail(),user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());

    }
}