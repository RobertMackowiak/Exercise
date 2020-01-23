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
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(id="page-loader-overlay-region")
    private WebElement loader;

    @FindBy(xpath = "//div[@class=\"demo-curtain\"]")
    private WebElement curtain;

    @FindBy(id="menu-transactions")
    private WebElement transactions;
    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement cookies;

    @FindBy(id="menu-products")
    private WebElement myFinances;

    @FindBy(xpath = "//span[@class=\"name row_name--S\"]")
    private WebElement openSavingsAccount;

    @FindBy(id="menu-financemeter")
    private WebElement servicesAndTools;

    @FindBy(id="servicesRecipient")
    private WebElement recipients;

    public void closeCookies(){
        SingletonWebdriver.getWait().until(ExpectedConditions.invisibilityOf(loader));
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(curtain));
        if(!SingletonWebdriver.getDriver().findElements(By.xpath("//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")).isEmpty()) {
            WebPageMethods.clickElement(cookies);
        }
    }

    public void clickTransactionButton() {
        WebPageMethods.clickElement(transactions);
    }

    public void clickMyFinancesbutton(){
        WebPageMethods.clickElement(myFinances);
    }

    public void clickOpenSavingsAccount(){
        WebPageMethods.clickElement(openSavingsAccount);
    }

    public void clickServicesAndTools(){
        WebPageMethods.clickElement(servicesAndTools);
    }

    public void clickRecipients(){
        WebPageMethods.clickElement(recipients);
    }
}
