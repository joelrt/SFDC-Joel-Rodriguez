package Pages;

import Framework.Browser.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Joel Rodriguez on 8/10/2015.
 */

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement password;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement login;

    public LoginPage() {
        driver = BrowserManager.getInstance().Browser;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName(String email) {
        userNameField.clear();
        userNameField.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public void clickLogInButton() {
        login.click();
    }
}
