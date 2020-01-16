package pl.b2b.ingTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class ConfirmationPage {
    public ConfirmationPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "div//[@class=\"sum_messages\"]")
    private WebElement confirmationMessage;

    public void checkConfirmation(){
        SingletonWebdriver.getWait().until(ExpectedConditions.visibilityOf(confirmationMessage));
        confirmationMessage.getText();
    }
}
