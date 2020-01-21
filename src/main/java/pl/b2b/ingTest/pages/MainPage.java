package pl.b2b.ingTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }
    @FindBy(id="menu-transactions")
    private WebElement executeTransactionBtn;

    @FindBy(xpath = "//p[@class=\"demo-curtain_container\"]")
    private WebElement demoInfo;

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement cookies;

    @FindBy(id="menu-products")
    private WebElement myFinancesButton;

    @FindBy(xpath = "//span[@class=\"name row_name--S\"]")
    private WebElement openSavingAccount;

    public void closeCookies(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(demoInfo));
        if (!SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).isEmpty()) {
            WebPageMethods.clickElement(cookies);
        }
    }

    public void clickExecuteTransactionBtn(){
        WebPageMethods.clickElement(executeTransactionBtn);
    }

    public void clickMyFinancesButton(){
        WebPageMethods.clickElement(myFinancesButton);
    }

    public void clickOpenSavingAccount(){
        WebPageMethods.clickElement(openSavingAccount);
    }

}
