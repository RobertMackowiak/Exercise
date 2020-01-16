package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionSummary {
    public TransactionSummary() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement assertionAccountNumber;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmTransaction;

    @FindBy (xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmationMessage;

    @FindBy (id = "menu-history")
    private WebElement historyTab;

    public boolean checkAccountNumber(){
        return TransactionOptionPage.accountNumber.equals(assertionAccountNumber.getText());
    }

    public void chooseConfirmTrannsaction(){
        WebPageMethods.clickElement(confirmTransaction);
    }

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public void chooseHistoryTab(){
        WebPageMethods.clickElement(historyTab);
    }
}
