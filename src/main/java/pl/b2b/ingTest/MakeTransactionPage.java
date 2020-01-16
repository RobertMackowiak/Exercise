package pl.b2b.ingTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class MakeTransactionPage {

    public static String accountNumber = "";

    public MakeTransactionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(),this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumberField;

    @FindBy(xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
    private WebElement vacationAccount;

    @FindBy(xpath = "//ul[@class=\"buttons-list\"]/li/a/div/div[contains(text(),'zwykły')]")
    private WebElement normalTransactionButton;

    @FindBy(id = "transfer-recipient-name")
    private WebElement nameAndAdressInput;

    @FindBy(id = "amount")
    private WebElement cashAmount;

    @FindBy(id = "title")
    private WebElement transactionTitle;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement forwardButton;


    public void clickVacationAccount(){
        WebPageMethods.clickElement(vacationAccount);
    }

    public void getTextFromAccountNumber(){
        accountNumber = accountNumberField.getText();
    }

    public void clickNormalTransaction(){
        WebPageMethods.clickElement(normalTransactionButton);
    }

    public void fillNameAndAdress(String name, String surname, String adress){
        WebPageMethods.sendKeysToElement(nameAndAdressInput,name+" "+surname+" "+adress);
    }

    public void fillCashAmount(String cash){
        WebPageMethods.sendKeysToElement(cashAmount,cash);
    }

    public void fillTitle(String title){
        WebPageMethods.sendKeysToElement(transactionTitle,title);
    }

    public void clickForwardButton(){
        WebPageMethods.clickElement(forwardButton);
    }



}
