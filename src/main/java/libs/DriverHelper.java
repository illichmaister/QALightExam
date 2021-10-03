package libs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver webDriver;
    public void createDriver(){
        webDriver = initDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void closeDriver(){
        webDriver.quit();
    }

    private WebDriver initDriver(){
        String browser = System.getProperty("browser");
        if ((browser == null)||browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("fireFox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
}
