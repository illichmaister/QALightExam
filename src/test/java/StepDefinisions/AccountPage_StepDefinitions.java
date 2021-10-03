package StepDefinisions;

import libs.DriverHelper;
import pages.AccountPage;
import pages.LoginPage;

public class AccountPage_StepDefinitions {
    private LoginPage loginPage = new LoginPage(DriverHelper.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverHelper.getWebDriver());

}
