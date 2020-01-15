package pl.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    String numberToCompare;

    public MainPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class=\"menu-item-name\"])[5]")
    private WebElement newTransactionButton;

    @FindBy (id = "page-loader-overlay-region")
    private WebElement mustDiseapeare;

    @FindBy(xpath = "(//a[@class=\"product-tile__container ing-hover\"])[3]")
    private WebElement targetHolidayAccount;

    @FindBy(xpath = "//p[@class=\"product-tile__iban is-long\"]")
    private WebElement accontNumber;

    @FindBy(xpath = "//div[@class=\"tile_title tile_title--icon-left\"]")
    private WebElement traditionalTransferButton;

    @FindBy(id = "transfer-recipient-name")
    private WebElement nameAndAddresField;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy (xpath = "(//div[@class=\"form-group ing-button-group js-button-group\"])[2]")
    private WebElement forwardButton;

    public void newTransactionButtonClick () {
        SingletonWebdriver.getWait().until(ExpectedConditions.invisibilityOf(mustDiseapeare));
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(newTransactionButton));
        newTransactionButton.click();
    }


    public void setTargetHolidayAccountClick() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(targetHolidayAccount));
        targetHolidayAccount.click();
    }

    public void accountNumberCopy() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(accontNumber));
        numberToCompare = accontNumber.getText();
        System.out.println(numberToCompare);
    }

    public String getAccountNumberCopy() {
        return numberToCompare;
    }

    public void traditionalTransferButtonClick() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(traditionalTransferButton));
        traditionalTransferButton.click();
    }

    public void setTransactionValueAndGo() {
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(nameAndAddresField));
        nameAndAddresField.click();
        nameAndAddresField.sendKeys("Jacek Placek, Warszawa");
        amount.click();
        amount.sendKeys("150");
        title.click();
        title.sendKeys("Tytuł przelewu");
    }

    public void clickForwardButton () {
        forwardButton.click();
    }


}
