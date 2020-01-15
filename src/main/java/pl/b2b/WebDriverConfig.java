package pl.b2b;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {

   private static WebDriver webDriver;
   private static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(webDriver, 10);
        }
        return wait;
    }
}
