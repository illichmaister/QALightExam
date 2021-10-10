package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id=\"email\"]")
    private TextInput inputEmail;

    @FindBy(xpath = ".//input[@id=\"pass\"]")
    private TextInput inputPassword;

    @FindBy(xpath = ".//button[@id=\"send2\"]")
    private Button buttonSignIn;

    @FindBy(xpath = ".//input[@id=\"footer-newsletter\"]")
    private WebElement inputSubMail;

    @FindBy(xpath = ".//*[@class='success-msg']")
    private WebElement successMessageElement;

    @FindBy(xpath = ".//*[@title=\"Підписатися\"]")
    private WebElement buttonSubscribe;

    @FindBy(xpath = ".//*[@id=\"search\"]")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@title=\"Пошук\"]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//*[@title=\"До кошика\"]")
    private WebElement buttonAddToCart;

    @FindBy(xpath = ".//*[@class='qty']")
    private WebElement cartCounter;

    @FindBy(xpath = ".//*[@class='header-switch header-cart']")
    private WebElement cartButton;

    @FindBy(xpath = ".//*[@id='fancybox-close']")
    private WebElement closeButton;

    @FindBy(xpath = ".//*[@class='forgot-password']")
    private WebElement forgotPassword;

    @FindBy(xpath = ".//input[@id='email_address']")
    private TextInput recoveryEmailField;

    @FindBy (xpath = ".//button[@title = 'Надіслати']")
    private WebElement sendEmailForRecovery;

    @FindBy (xpath = ".//*[@class='success-msg']")
    private WebElement successMessageAfterRecoveryLinkWasSent;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void openLoginPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login page" + e);
            Assert.fail("Cannot open Login page");
        }
    }


    public void enterEmailInInput(String email) {
        enterTextToElement(inputEmail, email);
    }

    public void enterPasswordInInput(String password) {
        enterTextToElement(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void enterBookName(String bookName){
        enterTextToElement(searchField, bookName);
    }
    public void enterEmailToSubscribingField(String email) {
        enterTextToElement(inputSubMail,email);
    }

    public void clickOnButtonSubscribe() {
        clickOnElement(buttonSubscribe);
    }

    public LoginPage checkTextInSuccessMessage(String text) {
        String actualText = successMessageElement.getText();
        Assert.assertEquals("Text in message", text, actualText);
        return this;
    }


    public void clickOnButtonSearch() {
        clickOnElement(buttonSearch);
    }

    public void clickOnButtonAddToCart() {
        clickOnElement(buttonAddToCart);
    }

    public Integer checkActualAmountOfOrders() {

        String viewedOrders = cartCounter.getText();
        Integer orderAmount = Integer.parseInt(viewedOrders);
        return orderAmount;


    }

    public void checkIsBookWasAddedToCart() {
        Integer actualOrderAmount;
        Assert.assertEquals("Amount of added books", checkActualAmountOfOrders(), actualOrderAmount = Integer.parseInt(cartCounter.getText()));
    }

    public void clickOnCartButton() {
        clickOnElement(cartButton);
    }

    public void closePopup() {
        clickOnElement(closeButton);
    }

    public AccountPage loginWithValidCred() {
        fillLoginAndSubmit(TestData.VALID_LOGIN, TestData.VALID_PASSWORD);
        return new AccountPage(webDriver);
    }

    private void fillLoginAndSubmit(String Login, String Password) {
        openLoginPage();
        enterEmailInInput(Login);
        enterPasswordInInput(Password);
        clickOnButtonSignIn();
    }

    public void clickOnLinkForgotPassword() {
        clickOnElement(forgotPassword);
    }

    public void fillEmailForRecovery(String email) {
        enterTextToElement(recoveryEmailField, email);
    }

    public void clickOnButtonSendEmailForRecovery() {
        clickOnElement(sendEmailForRecovery);
    }

    public LoginPage checkIsMessageEmailWasSentAppeared(String text) {
        String actualText = successMessageAfterRecoveryLinkWasSent.getText();
        Assert.assertEquals("Text in message", text, actualText);
        return this;
    }


}


