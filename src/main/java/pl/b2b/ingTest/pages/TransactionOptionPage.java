package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionOptionPage {

    public static String accountNumber = "";

    public TransactionOptionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
    private WebElement holidaysButton;

    @FindBy (xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement myAccountNumber;

    @FindBy (xpath = "//a[@class=\"js-key-access tile tile--small ing-clickable ing-hover\"]")
    private WebElement usualTransfer;

    public void chooseHolidaysButton(){
        WebPageMethods.clickElement(holidaysButton);
    }

    public void copyMyAccountNumber(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(myAccountNumber));
        accountNumber = myAccountNumber.getText();
    }

    public void chooseUsualTransfer(){
        WebPageMethods.clickElement(usualTransfer);
    }
}
