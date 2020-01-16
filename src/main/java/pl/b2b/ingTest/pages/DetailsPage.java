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


    public void putDetails() {

        WebPageMethods.sendKeysToElement(nameAndAddress,"Monika Kowal Lublin");
        WebPageMethods.sendKeysToElement(amount, transferAmount);
        WebPageMethods.sendKeysToElement(title,"Przelew");
    }

    public void clickNext(){
        WebPageMethods.clickElement(next);
    }


}
