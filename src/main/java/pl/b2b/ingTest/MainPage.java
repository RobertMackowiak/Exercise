package pl.b2b.ingTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

//    @FindBy(xpath = "//li[contains(text(),'Wykonaj transakcję')]")
    @FindBy(xpath = "//li[@id=\"menu-transactions\"]")
    private WebElement wykonajTrans;

    @FindBy(xpath = "//p[@class=\"demo-curtain_container\"]")
    private WebElement demoVersionInfo;

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement closeCookieButton;

    @FindBy(xpath = "//li[@id=\"menu-products\"]")
    private WebElement myFinances;

    @FindBy(xpath = "//span[@class=\"name row_name--S\"]")
    private WebElement savingAccount;


    public void clickOnWykonaj(){
        WebPageMethods.clickElement(wykonajTrans);
    }

    public void waitForCookies(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(demoVersionInfo));
        WebPageMethods.clickElement(closeCookieButton);
    }

    public void clickOnMyFinances(){
        WebPageMethods.clickElement(myFinances);
    }

    public void clickOnSavingAccount(){
        WebPageMethods.clickElement(savingAccount);
    }
}
