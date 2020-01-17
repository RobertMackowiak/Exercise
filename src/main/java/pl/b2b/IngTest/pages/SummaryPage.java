package pl.b2b.IngTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.IngTest.utils.WebPageMethods;
import pl.b2b.SingletonWebDriver;

public class SummaryPage {

    public SummaryPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement vacationAccount;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmMessage;

    @FindBy(id = "menu-history")
    private WebElement historyButton;


    public boolean vacationAccountComparision() { //porównanie dwóch stringów
        if (TransactionPage.accountNumber.equals(vacationAccount.getText())) {
            return true;
        } else {
            return false; //Alt+ Shift + Enter
        }
    }

    public void confirmButtonClick() {

        WebPageMethods.clickElement(confirmButton);
    }

    public String getConfirmMessage() {

        return confirmMessage.getText();
    }

    public void historyButtonClick() {
        WebPageMethods.clickElement(historyButton);
    }
}

