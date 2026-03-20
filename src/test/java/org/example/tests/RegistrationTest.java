package org.example.tests;

import org.example.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void testSuccessfulRegistration() throws InterruptedException {

        User user = User.getRandom();

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("login"));

    }

    @Test
    public void testNotSuccessfulRegistration() {

        User user = User.getRandom();

        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registrationPage.register(user.getName(), user.getEmail(), "12345");
        assertTrue(registrationPage.isErrorMessageDisplayed());

    }

}