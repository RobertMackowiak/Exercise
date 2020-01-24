package pl.b2b.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement cookieButton;

    @FindBy (id="menu-transactions")
    private WebElement transactionButton;

    @FindBy (xpath = "//div[@class=\"demo-curtain_content text-center\"]")
    private WebElement stupidCurtain;

    @FindBy (id="page-loader-overlay-region")
    private WebElement loaderOverlay;

    @FindBy (id="menu-products")
    private WebElement myFinanses;

    @FindBy (xpath = "//span[@class=\"name row_name--S\"]")
    private WebElement mySavings;

    @FindBy (id="menu-financemeter")
    private WebElement financeMeter;

    @FindBy (id="servicesRecipient")
    private WebElement recipientButton;

//    public void closeCookie(){
//        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(cookieButton));
//        cookieButton.click();
//    }

    public void closeCookies(){
        SingletonWebdriver.getWait().until(ExpectedConditions.invisibilityOf(loaderOverlay));
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(stupidCurtain));
        if (!SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).isEmpty()){
        WebPageMethods.clickElement(cookieButton);
        }
    }

    public void clickTransactionButton(){

        WebPageMethods.clickElement(transactionButton);
    }

    public void clickMyFinansesButton(){
        WebPageMethods.clickElement(myFinanses);
    }

    public void clickMySavingsButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(mySavings));
        WebPageMethods.clickElement(mySavings);
    }

    public void clickRecipientButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(financeMeter));
        WebPageMethods.clickElement(financeMeter);
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(recipientButton));
        WebPageMethods.clickElement(recipientButton);


    }
}
