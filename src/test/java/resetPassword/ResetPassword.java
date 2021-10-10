package resetPassword;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ResetPassword extends BaseTest {

    private String successMessage = "If there is an account associated with illichmaister@gmail.com you will receive an email with a link to reset your password.";

    @Test
    public void resetPassword(){
        loginPage.openLoginPage();
        loginPage.clickOnLinkForgotPassword();
        loginPage.fillEmailForRecovery(TestData.VALID_LOGIN);
        loginPage.clickOnButtonSendEmailForRecovery();
        loginPage.checkIsMessageEmailWasSentAppeared(successMessage.toUpperCase());
    }
}
