package Pages;

import Framework.Browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Joel Rodriguez on 8/10/2015.
 */

public class TabOptions {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "Opportunity_Tab")
    @CacheLookup
    WebElement OppTab;

    public TabOptions()
    {
        driver = BrowserManager.getInstance().Browser;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public OpportunityPage clickOppTab() {
        OppTab.findElement(By.linkText("Opportunities")).click();
        return new OpportunityPage();
    }
}
