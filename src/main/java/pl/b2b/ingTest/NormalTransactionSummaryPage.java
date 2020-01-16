package pl.b2b.ingTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class NormalTransactionSummaryPage {
    public NormalTransactionSummaryPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement fromAccountNumber;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmTransaction;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmMessageField;

    public boolean checkAccountNumber(){
        return MakeTransactionPage.accountNumber.equals(fromAccountNumber.getText());
    }

    public void clickConfirmButton(){
        WebPageMethods.clickElement(confirmTransaction);
    }

    public String getConfirmMessage(){
        return confirmMessageField.getText();
    }

}
