package changingPasswordTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ChangingPasswordTest extends BaseTest {
    @Test
    public void changingPassword(){
        loginPage.loginWithValidCred();
        accountPage.checkIsButtonSignOutVisible();
        accountPage.clickOnChengingPasswordLink();
        accountPage.fillOldPassword(TestData.VALID_PASSWORD);
        accountPage.fillFirstNewPassword(TestData.VALID_PASSWORD);
        accountPage.fillSecondNewPassword(TestData.VALID_PASSWORD);
        accountPage.clickOnSaveButton();
        accountPage.checkTextInSuccessMessage("ДАНІ ОБЛІКОВОГО ЗАПИСУ ЗБЕРЕЖЕНО.");


    }
}
