package pl.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

//    @FindBy (xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
//    private WebElement cookieButton;

    @FindBy (id="menu-transactions")
    private WebElement transactionButton;

    @FindBy (xpath = "//div[@class=\"demo-curtain_content text-center\"]")
    private WebElement stupidCurtain;

//    public void closeCookie(){
//        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(cookieButton));
//        cookieButton.click();
//    }


    public void clickTransactionButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(stupidCurtain));
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(transactionButton));
        transactionButton.click();
    }
}
