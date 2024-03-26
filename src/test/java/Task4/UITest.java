package Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UITest extends AbstractTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private static final String EMPTYLOGIN = "";
    private static final String LOGIN = "login";
    private static final String EMPTYPASSWORD = "";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "login@login.ru";

    @Test
    void enterWithoutLoginTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.authorization(EMPTYLOGIN, PASSWORD);
        Assertions.assertFalse(driver.findElements(By.xpath("//ul[@id='parsley-id-5']")).isEmpty());
    }

    @Test
    void enterWithoutPasswordTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.authorization(LOGIN, EMPTYPASSWORD);
        Assertions.assertFalse(driver.findElements(By.xpath("//ul[@id='parsley-id-7']")).isEmpty());

    }

}
