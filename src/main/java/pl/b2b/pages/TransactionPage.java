package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.WebDriverConfig;

public class TransactionPage {
    public TransactionPage() {
        PageFactory.initElements(pl.b2b.WebDriverConfig.getDriver(), this);

    }

    @FindBy(xpath = "//i[@class=\"glyphicon-rounded glyphicon-inverse glyphicon-ing-viewfinder\"]")
    private WebElement chooseAccount;

    @FindBy(xpath = "//span[contains(text(),'z rachunku')]/parent: :div/parent: :div/div[2]/span")
    private WebElement assertionAccountNumber;

    @FindBy(id = "transfer-recipient-name")
    private WebElement recipient;

    @FindBy(xpath = "//input[@id=\"form-control bound triggered\"]")
    private WebElement amount;

    @FindBy(xpath = "//textarea[@id=\"title\"]")
    private WebElement title;


    public void chooseAccount() {
        pl.b2b.WebDriverConfig.getWait().until(ExpectedConditions.elementToBeClickable(chooseAccount));
        chooseAccount.click();
    }

    public void copyAccountNumber() {
        WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(assertionAccountNumber));
        assertionAccountNumber.getText();
    }

    public void typeRecipient() {
        WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(recipient));
        recipient.sendKeys("100");
    }

    public void typeAmount() {
        WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(amount));
        amount.sendKeys("100");
    }

    public void typeTitle() {
        WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(title));
        title.sendKeys("sto");

    }
}


