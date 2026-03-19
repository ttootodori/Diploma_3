package org.example.tests;

import org.example.model.User;
import org.example.pages.RegisterPage;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void testSuccessfulRegistration() throws InterruptedException {

        User user = User.getRandom();

        driver.get("https://stellarburgers.education-services.ru/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("login"));

    }

}