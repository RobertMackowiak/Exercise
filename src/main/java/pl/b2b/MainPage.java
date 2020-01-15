package pl.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {

    @FindBy(xpath = "//span[@class =\"menu-item-name\"]")
    private WebElement performTransactionButton;


    public MainPage(){

        PageFactory.initElements(SingletonWebdriver.getDriver(),this);

    }
    public void performTransaction (){

//        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(performTransactionButton));
        performTransactionButton.click();
    }
}
