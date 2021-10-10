package pages;

import libs.TestData;
import org.apache.log4j.lf5.viewer.LogFactor5InputDialog;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccountPage extends ParentPage{

    @FindBy (xpath = ".//*[@title='Вийти']")
    private WebElement buttonSignOut;

    @FindBy (xpath = ".//*[contains(@class,'block-account')]")
    private WebElement blockAccount;

    private String bookNameLocator;

    @FindBy (xpath = ".//a[contains(text(), 'Змінити пароль')]")
    private WebElement changingPasswordLink;

    @FindBy (xpath = ".//input[@id='current_password']")
    private WebElement oldpassword;

    @FindBy (xpath = ".//input[@id='password']")
    private WebElement firstpassword;

    @FindBy (xpath = ".//input[@id='confirmation']")
    private WebElement confirmationField;

    @FindBy (xpath = ".//button[@title= 'Зберегти']")
    private WebElement saveChanges;

    @FindBy (xpath = ".//*[@class='success-msg']")
    private WebElement successMessageAfterAccountInfoChanging;

    @FindBy (xpath = ".//button[@title = 'Надіслати']")
    private WebElement sendEmailForRecovery;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage openAccountPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (!checkIsButtonSignOutPresent()){
            loginPage.loginWithValidCred();
        }
            return this;
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
    public boolean checkIsButtonSignOutPresent() {
        return isElementPresent(buttonSignOut);
    }

    public void clickOnChengingPasswordLink() {
        clickOnElement(changingPasswordLink);
    }



    public void fillOldPassword(String oldPassword) {
        enterTextToElement(oldpassword, oldPassword);
    }

    public void fillFirstNewPassword(String firstNewPassword) {
        enterTextToElement(firstpassword, firstNewPassword);
    }

    public void fillSecondNewPassword(String confirmation) {
        enterTextToElement(confirmationField, confirmation);
    }

    public void clickOnSaveButton() {
        clickOnElement(saveChanges);
    }

    public AccountPage checkTextInSuccessMessage(String text) {
        String actualText = successMessageAfterAccountInfoChanging.getText();
        Assert.assertEquals("Text in message", text, actualText);
        return this;
    }



//    public AccountPage deleteOrdersWhilePresent() {
//        List<WebElement> listOfOrders = webDriver.findElements(
//                By.xpath(String.format(bookNameLocator))
//        )
//
//    }
}
