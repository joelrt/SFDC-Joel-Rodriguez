package Test;

import Framework.Browser.BrowserManager;
import Pages.LoginPage;
import Pages.OpportunityPage;
import Pages.TabOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

/**
 * Created by Joel Rodriguez on 8/10/2015.
 */

public class Exam {
    WebDriver driver;
    WebDriverWait wait;

    String OppNewName = "Opp0002";
    String OppCloseDate = "8/10/2015";
    String OppStage = "Prospecting";

    @BeforeMethod
    public void setUp() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        new LoginPage()
                .setUserName("joel.rt.1@gmail.com")
                .setPassword("Control123")
                .clickLogInButton();
    }

    @Test
    public void CreateNewOpportunity() {
        new TabOptions()
                .clickOppTab()
                .clickOppSave()
                .setName(OppNewName)
                .setCloseDate(OppCloseDate)
                .setStage(OppStage)
                .selectAccount()
                .clickSaveButton();
    }

    @AfterMethod
    public void tearDown() {
        new OpportunityPage().clickDeleteOppPage();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
