package pl.b2b.bankIng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class HistoryOfTransactionPage {
    private String lastAssertion;
    private String moneyTransfer;
    public HistoryOfTransactionPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@class=\"row grid-row transactions-history-list-row row--cursor-pointer\"])[1]")
    private WebElement lastTransaction;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement checkAccountNumberAgain;

    @FindBy(xpath = "(//p[@class=\"amount amount--orange \"])[1]")
    private WebElement money;

    public void clickLastTransaction(){
        WebPageMethods.clickElement(lastTransaction);
    }

    public void checkAccountAgain(){
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(lastTransaction));
        lastAssertion = checkAccountNumberAgain.getText();
    }

    public String getLastAssertion() {
        return lastAssertion;
    }

//    public void checkMoney(){
//        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(moneyTransfer));
//        moneyTransfer = money.getText();
//    }
}
