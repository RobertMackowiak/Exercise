package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;
import pl.b2b.ingTest.utils.WebPageMethods;

public class TransactionPage {
    public TransactionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }


    @FindBy(xpath = "//i[@class=\"tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-transactions\"]")
    private WebElement regularTransfer;

    public void chooseRegularTransfer() {
        WebPageMethods.clickElement(regularTransfer);
    }

}
