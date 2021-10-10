package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
//import newsSubscribing.NewsSubscribing;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AccountPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class BaseTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
//    protected NewsSubscribing newsSubscribing;
    protected Logger logger = Logger.getLogger(getClass());

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        logger.info("------" + testName.getMethodName() + " was started ------");
        webDriver = initDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        accountPage = new AccountPage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertThat(message, actualResult, is(expectedResult));
    }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }

}

