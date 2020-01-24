package pl.b2b.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.utils.WebPageMethods;

public class TransactionPage {
    public TransactionPage(){
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "(//a[@class=\"product-tile__container ing-hover\"])[3]")
    private WebElement wakacjeButton;

    @FindBy (xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement ibanNumber1;

    @FindBy (xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement regularTransferButton;

    @FindBy (id="transfer-recipient-name")
    private WebElement nameField;

    @FindBy (id="amount")
    private WebElement amountField;

    @FindBy (id="title")
    private WebElement titleField;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement furtherButton;

    @FindBy (xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement ibanNumber2;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy (xpath = "//strong[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement confirmMessage;

    @FindBy (xpath = "//p[@class=\"product-tile__amount\"]")
    private WebElement money;

    private String ibanNumber;


    public void clickWakacjeButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(wakacjeButton));
        ((JavascriptExecutor)SingletonWebdriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", wakacjeButton);
        wakacjeButton.click();
    }

    public void getIbanNumber(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(ibanNumber1));

        ibanNumber = ibanNumber1.getText();
    }

    public void regularTransactionButtonClick(){
        WebPageMethods.clickElement(regularTransferButton);
    }

//    public void setNameField(){
//        WebPageMethods.sendKeysToElement(nameField,"nazwa");
//    }
//
//    public void setAmount(){
//        WebPageMethods.sendKeysToElement(amount, "100");
//    }
//
//    public void setTitle(){
//        WebPageMethods.sendKeysToElement(title, "tytuł przelewu");
//    }

    public void setTransactionFields(String name, String amount, String title) {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(nameField));
        WebPageMethods.sendKeysToElement(nameField, name);
        WebPageMethods.sendKeysToElement(amountField, amount);
        WebPageMethods.sendKeysToElement(titleField, title);
    }

    public void furtherButtonClick(){
//        ((JavascriptExecutor)SingletonWebdriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", furtherButton);
        furtherButton.click();
    }

    public boolean ibanNumberCheck(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(ibanNumber2));
        return ibanNumber.equals(ibanNumber2.getText());
    }

    public void confirmButtonClick(){
        WebPageMethods.clickElement(confirmButton);
    }

    public String getConfirmMessage(){
        return confirmMessage.getText();
    }

    public void setExcel(){

    }

    public String getMoney(){
        String amount = money.getText();
        amount = amount.substring(0,amount.length()-3).replace(" ","").replace(",",".");
        double amount2 = Double.valueOf(amount)/2;

        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(money));

        return String.valueOf(amount2);
    }


}
