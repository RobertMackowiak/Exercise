package pl.b2b.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingletonWebdriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
//    public static WebDriverTimeOut time;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "C:/SeleniumDrivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

//    public static WebDriverTimeOut getTime() {
//        if(time == null){
//            time = new WebDriverTimeout(driver, 10)
//        }
    public static void quitDriver(){
        getDriver().quit();
        driver = null;
    }
}
