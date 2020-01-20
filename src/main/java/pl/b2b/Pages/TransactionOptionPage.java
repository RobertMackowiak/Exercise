package pl.b2b.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebPageMethods;
import pl.b2b.utils.SingletonWebdriver;

public class TransactionOptionPage {

    public static String accountNumber = "";


    public TransactionOptionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
    private WebElement holidayButton;

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement myAccountNumber;

    @FindBy(xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement usualTransfer;

    @FindBy(id = "transfer-recipient-name")
    private WebElement nameAndAddress;

    @FindBy(id = "amount")
    private WebElement ammount;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement nextPageButton;

    public void chooseHolidaysButton() {
        WebPageMethods.clickElement(holidayButton);
    }

    public void copyMyAccount() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(myAccountNumber));
        accountNumber = myAccountNumber.getText();
    }

    public void setUsualTransfer() {
        WebPageMethods.clickElement(usualTransfer);
    }

    public void setNameAndAddress(String name) {
        WebPageMethods.sendKeysToElement(nameAndAddress, name);
    }

    public void setAmmount(String kwota) {
        WebPageMethods.sendKeysToElement(ammount, kwota);

    }


    public void setTitle(String title2) {
        WebPageMethods.sendKeysToElement(title, title2);
    }

    public void setNextPageButton() {
        WebPageMethods.clickElement(nextPageButton);
    }

}
