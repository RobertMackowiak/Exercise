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

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement vacationAccNumberAgain;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement acceptButton;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmMessage;

    @FindBy(id="menu-history")
    private WebElement historyButton;

    public boolean vacationAccNumbersComparison() {
        return TransactionPage.accountNumber.equals(vacationAccNumberAgain.getText());
    }
    public void clickAcceptButton(){
        WebPageMethods.clickElement(acceptButton);
    }
    public String getConfirmMessage(){
        return confirmMessage.getText();
    }
    public void clickHistoryButton(){
        WebPageMethods.clickElement(historyButton);
    }
}

//    INNA WERSJA:
//    public boolean vacationAccNumbersComparison(){
//        if (TransactionPage.accountNumber.equals(vacationAccNumberAgain.getText())){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
