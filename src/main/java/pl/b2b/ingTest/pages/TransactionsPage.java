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
    private WebElement transferRecipientNameField;

    @FindBy(id = "amount")
    private WebElement transferAmountField;

    @FindBy(id = "title")
    private WebElement transferTitleField;

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

    public void fillRecipientName(String name) {
        WebPageMethods.sendKeysToElement(transferRecipientNameField, name);
    }

    public void fillTransferAmount(String amount) {
        WebPageMethods.sendKeysToElement(transferAmountField, amount);
    }

    public void fillTransferTitle(String title) {
        WebPageMethods.sendKeysToElement(transferTitleField, title);
    }

    public void clickOnContinueBtn() {
        WebPageMethods.clickElement(continueBtn);
    }
}
