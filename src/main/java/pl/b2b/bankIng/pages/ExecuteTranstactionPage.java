package pl.b2b.bankIng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebDriver;

public class ExecuteTranstactionPage {
    String accNumber;

    public ExecuteTranstactionPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accountNumber;

    @FindBy(xpath = "//a[@class=\"product-tile__container ing-hover\"]")
    private WebElement holidayButton;

    @FindBy(xpath = "(//div[@class=\"tile_title tile_title--icon-left\"])[1]")
    private WebElement normalTransaction;

    public void copyAccountNumber() {
        SingletonWebDriver.getWait().until(ExpectedConditions.visibilityOf(accountNumber));
        accNumber = accountNumber.getText();
    }

    public String getAccNumber() {

        return accNumber;
    }

    public void clickHolidayButton() {
        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(holidayButton));
        holidayButton.click();
    }

    public void clickNormalTransaction() {
        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(normalTransaction));
        normalTransaction.click();
    }
}
