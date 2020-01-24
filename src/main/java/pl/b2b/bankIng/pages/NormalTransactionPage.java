package pl.b2b.bankIng.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebDriver;
import pl.b2b.bankIng.utils.WebPageMethods;

public class NormalTransactionPage {
    public NormalTransactionPage() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }


    @FindBy(id = "transfer-recipient-name")
    private WebElement nameAndAdressLabel;

    @FindBy(id = "amount")
    private WebElement amountLabel;

    @FindBy(xpath = "//button[@aria-labelledby=\"further-label\"]")
    private WebElement nextButton;

    @FindBy(id = "title")
    private WebElement titleLabel;

    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement confirmButton;

    @FindBy(xpath = "strong[class=\"sum_title no-outline-on-focus\"]")
    private WebElement title;

    @FindBy(id = "menu-history")
    private WebElement historyButton;

    @FindBy(xpath = "//p[@class=\"product-tile__amount\"]")
    private WebElement getFullAmount;

    public void putInTextInLabels(String name, String surname, String address) {
        nameAndAdressLabel.sendKeys("Bonifacy, Jerozolimska");
        amountLabel.sendKeys(get50cash());
        titleLabel.sendKeys("szampany");

        JavascriptExecutor jse = (JavascriptExecutor) SingletonWebDriver.getDriver();
        jse.executeScript("window.scrollBy(0,250)");

        nextButton.click();

    }

    public void clickConfirmButton() {
        SingletonWebDriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public void checkTitle() {

    }

    public void clickHistoryButton() {
        WebPageMethods.clickElement(historyButton);
    }

    public String get50cash() {
        String text = getFullAmount.getText();

        text = text.replaceAll(" ", "").replaceAll(",", ".").replaceAll("PLN","");
        double textToDouble = Double.parseDouble(text) / 2;
        return String.valueOf(textToDouble);

    }

}
