package pl.b2b.IngTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class TransactionDetails {
    private  String myAccountNumber;

    public TransactionDetails() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "p//[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumber;

    @FindBy (xpath = "a//[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement normalTransactionButton;

    @FindBy (id = "transfer-recipient-name")
    private WebElement recipientAddress;

    @FindBy (id = "amount")
    private WebElement transactionAmount;

    @FindBy (id = "title")
    private WebElement transactionTitle;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement nextButton;

    public void copyAccountNumber(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountNumber));
        myAccountNumber = accountNumber.getText();
    }

    public void chooseNormalTransactionButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(normalTransactionButton));
        normalTransactionButton.click();
    }

    public void fillRecipientAddress(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(recipientAddress));
        recipientAddress.sendKeys("ul. Adreswa");
    }

    public void fillTransactionAmount(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(transactionAmount));
        transactionAmount.sendKeys("200");
    }

    public void fillTransactionTitle(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(transactionTitle));
        transactionTitle.sendKeys("Moja testowa transakcja");
    }

    public void chooseNextButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public String getMyAccountNumber() {
        return myAccountNumber;
    }

}
