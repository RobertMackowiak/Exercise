package pl.b2b.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class DirectAcc {

    public DirectAcc() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy(xpath = ("(//a[@class=\"js-transaction-button link\"])"))
    private WebElement transfer;

    //(xpath = ("(//a[@title=\"Blouse\"])[2]"))
    //href="#transactions"

    public void clickTransfer(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(transfer));
        transfer.click();
    }

}
