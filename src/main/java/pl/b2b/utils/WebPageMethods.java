package pl.b2b.utils;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.b2b.SingletonWebdriver;

import java.io.File;

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

    public static void takeSnapShot(String testName) throws Exception{
//        int time = LocalTime.now().getHour();
//        String hourFolder = Integer.toString(time);
//        String data = LocalDate.now().toString();
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)SingletonWebdriver.getDriver());
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File("C:\\Users\\B2B\\Desktop\\screeny\\"+testName+".png");
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
