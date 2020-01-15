package pl.b2b.IngTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.b2b.SingletonWebdriver;

public class TransactionOptionPage {
    public TransactionOptionPage() {
        PageFactory.initElements(SingletonWebdriver.getDriver(), this);
    }

    @FindBy (xpath = "(a//[@class=\"product-tile__container ing-hover\"])[3]")
    private WebElement holidaysButton;

    public void chooseHolidaysButton(){
        SingletonWebdriver.getWait().until(ExpectedConditions.elementToBeClickable(holidaysButton));
        holidaysButton.click();
    }
}
