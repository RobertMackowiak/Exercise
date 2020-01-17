package pl.b2b.IngTest.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.IngTest.utils.WebPageMethods;
import pl.b2b.SingletonWebDriver;

public class MainPage {

    public MainPage() {

        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(id ="menu-transactions")
    private WebElement transactionButton;

    @FindBy(xpath = "//div[@class=\"demo-curtain_content text-center\"]")
    private WebElement demoCurtainContent;

    @FindBy(id="page-loader-overlay-region")
    private WebElement loadingPage;

    @FindBy (xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement closeCookies;


    public void clickIntoTransactionButton() {
        WebPageMethods.clickElement(transactionButton);
    }

    public void setCloseCookies(){
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(demoCurtainContent));
        SingletonWebDriver.getWait().until(ExpectedConditions.invisibilityOf(loadingPage));
        WebPageMethods.clickElement(closeCookies);
    }


//    public void clickIntoTransactionButton() {
//        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(demoCurtainContent));
//        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(transactionButton));
//        SingletonWebDriver.getWait().until(ExpectedConditions.invisibilityOf(loadingPage));
//        transactionButton.click();
//    }

}
