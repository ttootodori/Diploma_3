package org.example.tests;

import io.restassured.response.Response;
import org.example.RestApi;
import org.example.model.User;
import org.example.steps.UserSteps;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private User user;
    private String accessToken;
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

    @After
    public void cleanUp() {
        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
            System.out.println("Успешно удалён.");
        }
    }

    @Test
    public void loginByClickingLoginButton() {
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.isBurgerConstructorDisplayed());
    }

    @Test
    public void loginByClickingAccountButton() {

        mainPage.clickPersonalAccount();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());

    }

    @Test
    public void loginByClickingButtonInRegistrationForm() {

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.clickLoginLink();
        loginPage.login(user.getEmail(),user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());
    }

    @Test
    public void loginByClickingButtonInPasswordRecoveryForm() {

        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        loginPage.clickOnRecoveryPageLoginLink();
        loginPage.login(user.getEmail(),user.getPassword());
        assertTrue(mainPage.isBurgerConstructorDisplayed());

    }

}