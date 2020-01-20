package pl.b2b.bankIng.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebdriver;

public class WebPageMethods {
    static WebDriverWait webDriverWait = SingletonWebdriver.getWait();


    public static void clickElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeysToElement(WebElement element, String message){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(message);
    }
}
