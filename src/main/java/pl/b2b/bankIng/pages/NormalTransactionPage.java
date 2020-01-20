package pl.b2b.bankIng.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class NormalTransactionPage {
    public NormalTransactionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
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

    public void putInTextInLabels(String name ,String surname, String address) {
        nameAndAdressLabel.sendKeys("Bonifacy, Jerozolimska");
        amountLabel.sendKeys("300");
        titleLabel.sendKeys("szampany");

        JavascriptExecutor jse = (JavascriptExecutor) SingletonWebdriver.getDriver();
        jse.executeScript("window.scrollBy(0,250)");

        nextButton.click();

    }

    public void clickConfirmButton() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public void checkTitle(){

    }

}
