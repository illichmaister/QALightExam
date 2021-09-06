package pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static pages.ParentPage.configProperties;


public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void validLogin(){
        try {
            webDriver.get(baseUrl);
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open Login page" + e);
            Assert.fail("Cannot open Login page");
        }

    }
}
