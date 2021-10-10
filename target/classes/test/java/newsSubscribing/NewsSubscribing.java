package newsSubscribing;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class NewsSubscribing extends BaseTest {

    @Test
    public void newsSubscribing(){
        loginPage.openLoginPage();
        loginPage.enterEmailToSubscribingField(TestData.SUB_MAIL);
        loginPage.clickOnButtonSubscribe();
        loginPage.checkTextInSuccessMessage("ЗАПИТ НА ПІДТВЕРДЖЕННЯ НАДІСЛАНО.");
    }
}
