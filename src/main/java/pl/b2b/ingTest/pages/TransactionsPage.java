package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

import java.util.List;

public class TransactionsPage {

    public TransactionsPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindAll(@FindBy(xpath = "//ul[@class=\"ing-list\"]/li"))
    private List<WebElement> accountsList;

    @FindBy(xpath = "(//p[@class=\"product-tile__iban is-long\"])[3]")
    private WebElement accountNo3Iban;

//    @FindBy(xpath = "//li[@class=\"ing-list-element product-tile is-clickable is-goal\"]")
//    private WebElement accountNo3;

//    @FindBy(xpath = "(//div[@class=\"tile_title tile_title--icon-left\"])[1]")
//    private WebElement normalTransaction;

//    this method needs to be changed; assertion will be done later
    public void checkAccNumber () {
        String numberToCheck;
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountNo3Iban));
        numberToCheck = accountNo3Iban.getText();
        if (numberToCheck.equals("79 1050 0028 2100 0023 0315 0007")) {
            System.out.println("IBAN number OK");
        }
    }

    public void clickOnAccountNo3() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountsList.get(2)));
        accountsList.get(2).click();
    }

//    public void clickNormalTransaction() {
//        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(normalTransaction));
//        normalTransaction.click();
//    }
}
