package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionPage {
    public String transferAmount ="1236";
    public static String accountNumber ="";

    public TransactionPage() { PageFactory.initElements(SingletonWebdriver.getDriver(),this); }

    @FindBy(xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
    private WebElement holidaysButton;

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement myAccountNumber;

    @FindBy(xpath = "//i[@class=\"tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-transactions\"]")
    private WebElement regularTransferBtn;

    @FindBy(id="transfer-recipient-name")
    private WebElement nameAndAddress;

    @FindBy(id ="amount")
    private WebElement amount;

    @FindBy(id="title")
    private WebElement title;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement nextBtn;

    @FindBy(xpath = "//p[@class=\"product-tile__amount\"]")
    private WebElement currentAmount;

    public void clickHolidayButton(){
        WebPageMethods.clickElement(holidaysButton);
    }
    public void copyMyAccountNumber(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(myAccountNumber));
        accountNumber = myAccountNumber.getText();
        System.out.println(accountNumber);
    }
    public void clickRegularTransferBtn(){
        WebPageMethods.clickElement(regularTransferBtn);
    }

    public void putNameAndAddress(String itemName) {    WebPageMethods.sendKeysToElement(nameAndAddress, itemName);
    }
    public void putAmount(String itemAmount) {
        WebPageMethods.sendKeysToElement(amount, itemAmount);
    }
    public void putTitle(String itemTitle){
        WebPageMethods.sendKeysToElement(title,itemTitle);
    }

    public void clickNextBtn(){
        WebPageMethods.clickElement(nextBtn);
    }

    public String getAmount(){
        String amount = currentAmount.getText();
        amount = amount.substring(0,amount.length()-3).replace(" ", "").replace(",",".");
        double amount2 = Double.valueOf(amount)/2;
        return String.valueOf(amount2);
    }
}
