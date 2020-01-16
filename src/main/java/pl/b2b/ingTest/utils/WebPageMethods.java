package pl.b2b.ingTest.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebdriver;

public class WebPageMethods {

    private static WebDriverWait wait = SingletonWebdriver.getWait();


    public static void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeysToElement(WebElement element, String message){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(message);
    }
}
