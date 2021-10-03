package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends ParentPage{

    @FindBy (xpath = ".//*[contains(@class,'summary')]")
    private WebElement buttonSignOut;

    @FindBy (xpath = ".//*[contains(@class,'block-account')]")
    private WebElement blockAccount;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public AccountPage checkIsRedirectOnAccountPage(){
        checkUrl();
        checkIsButtonSignOutVisible();
        return this;
    }

    public boolean isBlockAccountPresent() {
        return isElementPresent(blockAccount);
    }

    public AccountPage checkIsButtonSignOutVisible() {
        Assert.assertTrue("Button Sign Out is not displayed", isBlockAccountPresent());
        return this;
    }
}
