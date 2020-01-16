package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionDetails {

    public static String myTransferAmount = "200,00";

    public TransactionDetails() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//textarea[@id=\"transfer-recipient-name\"]")
    private WebElement addressContainer;

    @FindBy (id = "amount")
    private WebElement transferAmount;

    @FindBy (xpath = "//textarea[@id=\"title\"]")
    private WebElement  transferTitle;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement nextButton;

    public void fillAddressContainer(){
        WebPageMethods.sendKeysToElement(addressContainer, "ul. Adresowa 56");
    }

    public void  fillTransferAmount(){
        WebPageMethods.sendKeysToElement(transferAmount, myTransferAmount);
    }

    public void fillTransferTitle(){
        WebPageMethods.sendKeysToElement(transferTitle, "pinionżki");
    }

    public void chooseNextButton(){
        WebPageMethods.clickElement(nextButton);
    }
}
