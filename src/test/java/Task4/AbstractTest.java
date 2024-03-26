package Task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {
    public WebDriver driver;

    @BeforeAll
    static void initialization() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeEach
    void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBrowserVersion("116.0.5845.111");
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void close() {
        driver.quit();
    }
}