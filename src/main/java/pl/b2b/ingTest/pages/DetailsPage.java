package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class DetailsPage {
    public DetailsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    public String transferAmount = "1000";

    @FindBy(id="transfer-recipient-name")
    private WebElement nameAndAddress;

    @FindBy(id ="amount")
    private WebElement amount;

    @FindBy(id="title")
    private WebElement title;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement next;

    @FindBy(xpath = "//p[@class=\"product-tile__amount\"]")
    private WebElement copiedAmount;


    public void putNameAndAddress(String itemName) {

        WebPageMethods.sendKeysToElement(nameAndAddress, itemName);
    }
    public void putAmount(String itemAmount) {
        WebPageMethods.sendKeysToElement(amount, itemAmount);
    }
    public void putTitle(String itemTitle){
        WebPageMethods.sendKeysToElement(title,itemTitle);
    }

    public void clickNext(){
        WebPageMethods.clickElement(next);
    }
    public String getAmount() {
        String amount = copiedAmount.getText();
        amount = amount.substring(0,amount.length()-3).replace(" ", "").replace(",", ".");
        double amount2 = Double.valueOf(amount)/2;
        return String.valueOf(amount2);
    }

}
