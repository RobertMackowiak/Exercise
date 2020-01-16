package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class AccountHistoryPage {

    public AccountHistoryPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@class=\"row grid-row transactions-history-list-row row--cursor-pointer\"])[1]")
    private WebElement lastTransaction;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement accountNumber3;

    @FindBy(xpath = "//p[@class=\"transaction-details-subsection_content transaction-details_amount\"]")
    private WebElement transactionAmount;

    public void showLastTransactionDetails() {
        WebPageMethods.clickElement(lastTransaction);
    }

    public boolean accountsNumbersComparison2() {
        return TransactionsPage.accountNumberToCheck.equals(accountNumber3.getText());
    }

    /*
     *  method gets a text string from the WebElement, cut off a first sign (minus), decimal separator sign,
     *  digits on right side of decimal separator and currency code
     */
    public String getTransactionAmount() {
        return transactionAmount.getText().substring(1, transactionAmount.getText().length() - 7);
    }
}
