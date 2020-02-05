package pl.b2b;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.utils.SingletonWebdriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WebPageMethods {
    static WebDriverWait webDriverWait = SingletonWebdriver.getWait();

    public static void clickElement(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public static void sendKeysToElement(WebElement element, String message){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(message);
    }
    public static void takeAScreenShoot(){
        TakesScreenshot takesScreenshot = ((TakesScreenshot)SingletonWebdriver.getDriver());
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\B2B\\Desktop\\screenshots\\screen"+ getTime() +".png");
        try {
            FileUtils.copyFile(file, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm.ss");
        LocalTime now = LocalTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }
    public static void sliderMove(WebElement element, int x, int y){
        Actions move = new Actions(SingletonWebdriver.getDriver());
        move.dragAndDropBy(element, x, y).build().perform();

    }

}
