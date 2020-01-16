package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(id = "menu-transactions")
    private WebElement transactionButton;

    @FindBy(xpath = "//p[@class=\"demo-curtain_container\"]")
    private WebElement demoInfo;

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement cookiesWindow;


    public void chooseTransactionButton() {
        WebPageMethods.clickElement(transactionButton);
    }

    public void closeCookiesWindow(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(demoInfo));
        WebPageMethods.clickElement(cookiesWindow);
    }
}
