package pages;

import org.apache.log4j.lf5.viewer.LogFactor5InputDialog;
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
    private LogFactor5InputDialog successMessageElement;

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

    public void enterEmailToSubscribingField(String email) {
        enterTextToElement(inputSubMail,email);
    }

    public void clickOnButtonSubscribe() {
        clickOnElement(inputSubMail);
    }

    public LoginPage checkTextInSuccessMessage(String text) {
        String actualText = successMessageElement.getText();
        Assert.assertEquals("Text in message", text, actualText);
        return this;
    }
}


