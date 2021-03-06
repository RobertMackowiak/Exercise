package pl.b2b;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingletonWebdriver {

    WebDriver driver;
    WebDriverWait wait;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "C:/SeleniumDrivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }
}
