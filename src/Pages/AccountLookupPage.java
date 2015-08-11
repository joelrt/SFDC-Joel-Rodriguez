package Pages;

import Framework.Browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Joel Rodriguez on 8/10/2015.
 */

public class AccountLookupPage {
    WebDriver driver;
    WebDriverWait wait;

    public AccountLookupPage() {
        driver = BrowserManager.getInstance().Browser;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public AccountLookupPage selectAccount() {
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        driver.switchTo().window(listWindows.getLast());
        driver.switchTo().frame("resultsFrame");
        driver.findElement(By.xpath("//a[contains(@href, '#')]")).click();
        driver.switchTo().window(listWindows.getFirst());
        return this;
    }
}


