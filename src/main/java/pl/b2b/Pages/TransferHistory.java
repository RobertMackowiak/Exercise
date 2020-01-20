package pl.b2b.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.utils.SingletonWebdriver;

import java.util.List;

public class TransferHistory {
    public String transferAmount;

    public TransferHistory() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindAll(@FindBy(xpath = "//ul[@class=\"transactions-history-list_container grid grid--hover\"]/li"))
    private List<WebElement> transferHistoryDetailsList;

    @FindBy(xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement accountNumberAfterTransaction;

    @FindBy(xpath = "//p[@class=\"transaction-details-subsection_content transaction-details_amount\"]")
    private WebElement accountValueAfterTransaction;


    public void clickOnTransferDeatailsHistory() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOfAllElements(transferHistoryDetailsList));
        for (int i = 0; i <= transferHistoryDetailsList.size(); i++) {
            transferHistoryDetailsList.get(0).click();
        }

    }

    public boolean getAccountNumberAfterTransaction() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountNumberAfterTransaction));
        return TransactionOptionPage.accountNumber.equals(accountNumberAfterTransaction.getText());
    }
    public boolean compareTransferValueAfterTransaction(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountValueAfterTransaction));
        transferAmount = accountValueAfterTransaction.getText();
        transferAmount = transferAmount.substring(1,transferAmount.length() -4);
        System.out.println(transferAmount);
        return PageSummary.transferAmount.equals(transferAmount);
    }
}


