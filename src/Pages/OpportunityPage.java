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

public class OpportunityPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "new")
    @CacheLookup
    WebElement createNewOpp;

    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteOpp;

    public OpportunityPage() {
        driver = BrowserManager.getInstance().Browser;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public CreateNewOpp clickOppSave() {
        createNewOpp.click();
        return new CreateNewOpp();
    }

    public void clickDeleteOppPage() {
        deleteOpp.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }


}
