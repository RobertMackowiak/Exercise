package pl.b2b;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransactionPage {
    public TransactionPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "(//a[@class=\"product-tile__container ing-hover\"])[3]")
    private WebElement wakacjeButton;

    @FindBy (id="transfer-recipient-account-number")
    private WebElement ibanNumber;

    @FindBy (xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement regularTransactionButton;

    @FindBy (id="transfer-recipient-name")
    private WebElement nameField;

    @FindBy (id="amount")
    private WebElement amount;

    @FindBy (id="title")
    private WebElement title;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement furtherButton;

    @FindBy (xpath = "(//div[@class=\"product-tile__iban is-long\"])[2]")
    private WebElement ibanNumber2;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    public void clickWakacjeButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(wakacjeButton));
        ((JavascriptExecutor)SingletonWebdriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", wakacjeButton);
        wakacjeButton.click();
    }

    public String getIbanNumber(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(ibanNumber));

        return ibanNumber.getText();
    }

    public void regularTransactionButtonClick(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(regularTransactionButton));
        regularTransactionButton.click();
    }

    public void setNameField(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys("nazwa");
    }

    public void setAmount(){
        amount.sendKeys("100");

    }

    public void setTitle(){
        title.sendKeys("tytuł przelewu");
    }

    public void furtherButtonClick(){
        ((JavascriptExecutor)SingletonWebdriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", furtherButton);
        furtherButton.click();
    }

    public boolean ibanNumberCheck(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(ibanNumber2));
        if (getIbanNumber().equals(ibanNumber2.getText())){
            return true;
        }
        else{
            return false;
        }
    }

    public void confirmButtonClick(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

}
