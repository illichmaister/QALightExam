package pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class LoginPage extends ParentPage{
   @FindBy(xpath = ".//input[@id=\"email\"]")
    private TextInput inputEmail;

   @FindBy(xpath = ".//input[@id=\"pass\"]")
    private TextInput inputPassword;

   @FindBy(xpath = ".//button[@id=\"send2\"]")
   private Button buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void openLoginPage(){
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened");
        }catch (Exception e){
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
}
