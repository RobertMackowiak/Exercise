package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class PageSummary {

    public PageSummary() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumber2;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement acceptBtn;

    @FindBy(xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmMessage;

    public boolean accountsNumbersComparison() {
        return TransactionsPage.accountNumberToCheck.equals(accountNumber2.getText());
    }

    public void clickOnAcceptBtn() {
        WebPageMethods.clickElement(acceptBtn);
    }

    public String getConfirmMessage() {
        return confirmMessage.getText();
    }
}
