package org.example.tests;

import org.example.client.UserClient;
import org.example.model.User;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.example.steps.UserSteps;
import org.example.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected User user;
    protected UserSteps userSteps;
    protected UserClient userClient;
    protected String accessToken;

    protected static final String BASE_URL = "https://stellarburgers.education-services.ru/";

    @Before
    public void setUp() throws InterruptedException {
        // Получаем браузер из системной переменной (по умолчанию chrome)
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        }

        // Настройки драйвера
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Инициализация Page Objects
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);

        // API клиенты
        userSteps = new UserSteps();
        userClient = new UserClient();

        // Открываем сайт
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void startBrowserYandex() {
        // Яндекс использует Chromium, но нужно указать путь к браузеру
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xander\\Diploma\\Diploma_3\\src\\test\\resources\\drivers");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
    }

    protected void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete")
        );
    }

}