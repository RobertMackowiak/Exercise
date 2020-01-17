package pl.b2b.IngTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.IngTest.utils.WebPageMethods;
import pl.b2b.SingletonWebDriver;

public class TransactionHistoryPage {


    public TransactionHistoryPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"transactions-history-item-basic-info\"]")
    private WebElement lastTransfer;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement detailsFromAccountNumberTransaction;

    @FindBy(xpath = "//p[@class=\"transaction-details-subsection_content transaction-details_amount\"]")
    private WebElement transactionAmountOnHistoryPage;

    public void clickOnLastTransfer() {
        WebPageMethods.clickElement(lastTransfer);
    }

    public String getAccountNumberOnHistoryPage() {

        return detailsFromAccountNumberTransaction.getText();
    }

    public String getDetailsOfTransaction() {

        return transactionAmountOnHistoryPage.getText().substring(1).replace(",00 PLN", "");

    }


    public boolean accountComparisionFromPages() { //porównanie dwóch stringów
        //Alt+ Shift + Enter
        return TransactionPage.accountNumber.equals(detailsFromAccountNumberTransaction.getText());

    }

    public String getTransactionAmount() {
        return transactionAmountOnHistoryPage.getText().substring(1, transactionAmountOnHistoryPage.getText().length() - 7);
    }
}
