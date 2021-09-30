package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {
    WebDriver webDriver;
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterEmailInInput(TestData.VALID_LOGIN);
        loginPage.enterPasswordInInput(TestData.VALID_PASSWORD);
        loginPage.clickOnButtonSignIn();
//        clickOnButtonSignIncheckExpectedResult("Button SignOut is not visible", homePage.isButtonSignOutPresent(), true);
    }
}
