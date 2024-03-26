package Task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='user_email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@id='user_password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id='new_user']")
    WebElement buttonInput;
    @FindBy(xpath = "//li[@class='parsley-type']")
    WebElement textErrorBlock;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void inputEmail(String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(userEmail);
    }

    public void inputPassword(String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(userPassword);
    }

    public void clickButtonInput() {
        wait.until(ExpectedConditions.visibilityOf(buttonInput)).click();
    }

    public void authorization(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickButtonInput();
    }

    public boolean getTextError() {
        return wait.until(ExpectedConditions.invisibilityOf(textErrorBlock));
    }

    public void inputNotPassword(String email) {
        inputEmail(email);
        clickButtonInput();
    }

    public String checkFieldPassword() {
        return wait.until(ExpectedConditions.visibilityOf(passwordField)).getText();

    }



}