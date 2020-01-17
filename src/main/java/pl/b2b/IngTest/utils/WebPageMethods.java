package pl.b2b.IngTest.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebDriver;

public class WebPageMethods {
    static WebDriverWait webDriverWait = SingletonWebDriver.getWait();

    public static void clickElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeysToElement(WebElement element,String message){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(message);
    }

}