package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionsPage {

    public static String accountNumberToCheck = "";

    public TransactionsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
    private WebElement holidayAccountBtn;

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumber1;

    @FindBy(xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement usualTransfer;

    @FindBy(id = "transfer-recipient-name")
    private WebElement transferRecipientName;

    @FindBy(id = "amount")
    private WebElement transferAmount;

    @FindBy(id = "title")
    private WebElement transferTitle;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement continueBtn;

    public void clickOnHolidayAccount() {
        WebPageMethods.clickElement(holidayAccountBtn);
    }

    public void copyMyAccountNumber() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountNumber1));
        accountNumberToCheck = accountNumber1.getText();
    }

    public void clickOnUsualTransfer() {
        WebPageMethods.clickElement(usualTransfer);
    }

    public void fillRecipientName() {
        WebPageMethods.sendKeysToElement(transferRecipientName, "Jack Daniels");
    }

    public void fillTransferAmount() {
        WebPageMethods.sendKeysToElement(transferAmount, "500");
    }

    public void fillTransferTitle() {
        WebPageMethods.sendKeysToElement(transferTitle, "for transport");
    }

    public void clickOnContinueBtn() {
        WebPageMethods.clickElement(continueBtn);
    }
}
