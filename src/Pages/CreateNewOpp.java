package Pages;

import Framework.Browser.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Joel Rodriguez on 8/10/2015.
 */

public class CreateNewOpp {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "opp3")
    @CacheLookup
    WebElement nameField;

    @FindBy(id = "opp9")
    @CacheLookup
    WebElement closeDate;

    @FindBy(id = "opp11")
    @CacheLookup
    WebElement stage;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveButton;

    @FindBy(className = "lookupIcon")
    @CacheLookup
    WebElement account;

    public CreateNewOpp() {
        driver = BrowserManager.getInstance().Browser;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public CreateNewOpp setName(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
    }

    public CreateNewOpp setCloseDate(String date) {
        closeDate.clear();
        closeDate.sendKeys(date);
        return this;
    }

    public CreateNewOpp setStage(String stageName) {
        new Select(stage).selectByVisibleText(stageName);
        return this;
    }

    public CreateNewOpp selectAccount() {
        account.click();
        new AccountLookupPage().selectAccount();
        return this;
    }

    public OpportunityPage clickSaveButton() {
        saveButton.click();
        return new OpportunityPage();
    }
}
