package pl.b2b.IngTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class TransactionPage {
    public TransactionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }
    @FindBy(xpath = "//li[@class=\"tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-transactions\"]")
    private WebElement regularTransfer;

    public void chooseRegularTransfer() {
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(regularTransfer));
        regularTransfer.click();
    }

}
