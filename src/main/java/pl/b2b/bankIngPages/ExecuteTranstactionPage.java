package pl.b2b.bankIngPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class ExecuteTranstactionPage {
//    String accNumber = "79 1050 0028 2100 0023 0315 0007";
String accNumber;
    public ExecuteTranstactionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumber;

    @FindBy(xpath = "//a[@class=\"product-tile__container ing-hover\"]")
    private WebElement holidayButton;

    @FindBy(xpath = "(//div[@class=\"tile_title tile_title--icon-left\"])[1]")
    private WebElement normalTransaction;

    public void copyAccountNumber() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accountNumber));
       accNumber = accountNumber.getText();
    }

    public String getAccNumber() {

        return accNumber;
    }

    public void clickHolidayButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(holidayButton));
        holidayButton.click();
    }

    public void clickNormalTransaction() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(normalTransaction));
        normalTransaction.click();
    }
}