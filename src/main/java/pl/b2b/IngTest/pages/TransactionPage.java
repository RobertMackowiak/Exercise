package pl.b2b.IngTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.IngTest.utils.WebPageMethods;
import pl.b2b.SingletonWebDriver;

public class TransactionPage {

    public static String accountNumber = "";


    public TransactionPage() {

        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class=\"product-tile__container ing-hover\"])[3]")

    private WebElement vacationAccount;

    @FindBy(xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement usualTransfer;

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement myAccountNumber;

    @FindBy(id = "transfer-recipient-name")
    private WebElement nameField;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "title")
    private WebElement titleField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement nextButton;

    public void clickOnVacationAccount() {
        //SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(vacationAccount));
        //((JavascriptExecutor) SingletonWebDriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", vacationAccount);
        //vacationAccount.click();
        WebPageMethods.clickElement(vacationAccount);

    }

    public void clickOnUsualransfer() {
        WebPageMethods.clickElement(usualTransfer);
//        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(usualTransfer));
//        usualTransfer.click();

    }

    public void copyMyAccountNumber() {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(myAccountNumber));
        accountNumber = myAccountNumber.getText();
    }

    public void setTransactionFields(String name, String amount, String title) {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(nameField));
        WebPageMethods.sendKeysToElement(nameField, name);
        WebPageMethods.sendKeysToElement(amountField, amount);
        WebPageMethods.sendKeysToElement(titleField, title);
//        nameField.sendKeys("Michał Olszewski \n ul. Grzegorza Piramowicza 12 \n 45-725 Opole ");
//        amountField.sendKeys("300");
//        titleField.sendKeys("Polisa ubezpieczeniowa");
    }

    public void nextButtonClick() {
//        ((JavascriptExecutor) SingletonWebDriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        WebPageMethods.clickElement(nextButton);
    }


}

