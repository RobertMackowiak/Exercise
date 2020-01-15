package pl.b2b.IngTest;

import com.sun.org.glassfish.gmbal.DescriptorFields;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class TransactionSummary {

    TransactionDetails myAccountNumber;

    public TransactionSummary() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
        myAccountNumber = new TransactionDetails();
    }

    @FindBy (xpath = "p//[@class=\"product-tile__iban is-long\"]")
    private WebElement assertionAccountNumber;

    @FindBy (xpath = "button//[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmTransaction;

    public boolean compareAccountNumbers(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(assertionAccountNumber));
        if (myAccountNumber.getMyAccountNumber().equals(assertionAccountNumber.getText())){
            return true;}
        else{
            return false;
        }
    }

    private void chooseConfirmTransaction(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(confirmTransaction));
        confirmTransaction.click();
    }
}
