package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class HistoryTab {
    public HistoryTab() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@class=\"transactions-history-item-basic-info\"]")
    private WebElement lastTransfer;

    @FindBy (xpath = "//p[@class=\"col-xs-12 payer-details_from-account-number transaction-details-subsection_content\"]")
    private WebElement historyAccountNumber;

    @FindBy (xpath = "//p[@class=\"amount amount--orange \"]")
    private WebElement historyTransferAmount;

    public void chooseLastTransfer(){
        WebPageMethods.clickElement(lastTransfer);
    }

    public String checkHistoryAccountNumber(){
       return historyAccountNumber.getText();
    }

    public String checkHistoryTransferAmount(){
        return historyTransferAmount.getText();
    }
}
