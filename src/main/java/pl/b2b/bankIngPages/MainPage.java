package pl.b2b.bankIngPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement coockiesButton;

//    @FindBy(id = "menu-transactions")
    @FindBy(xpath = "//li[@id=\"menu-transactions\"]")
    private WebElement executeTransactionButton;

    public void clickExecuteTransactionButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(executeTransactionButton));
        executeTransactionButton.click();
    }

    public void clickCookiesButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.invisibilityOf(executeTransactionButton));
        coockiesButton.click();
    }

}


