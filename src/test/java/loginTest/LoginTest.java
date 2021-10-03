package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {
//    WebDriver webDriver;
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterEmailInInput(TestData.VALID_LOGIN);
        loginPage.enterPasswordInInput(TestData.VALID_PASSWORD);
        loginPage.clickOnButtonSignIn();

        checkExpectedResult("Button SignOut is not visible",
                accountPage.isBlockAccountPresent(),
                true);
    }
}
